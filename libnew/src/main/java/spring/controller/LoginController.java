package spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.exception.IdPasswordNotMatchingException;
import spring.service.AuthService;
import spring.validator.LoginCommandValidator;
import spring.vo.AuthInfo;
import spring.vo.LoginCommand;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private AuthService authService;

	public void setAuthService(AuthService authService) { //스프링으로부터 주입
		this.authService = authService;
	}
	
//	@RequestMapping(method=RequestMethod.GET)
//	public String form(Model model) {
//		model.addAttribute("loginCommand",new LoginCommand());
	
	@RequestMapping(method=RequestMethod.GET)	
	public String form(LoginCommand loginCommand) {
		return "login/loginForm";
	}


	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(LoginCommand loginCommand, Errors errors, HttpSession session,HttpServletResponse response) {
		//1. 아이디 , 비밀번호가 입력이 되기는 했는지 검증
		new LoginCommandValidator().validate(loginCommand,errors);
		
		if(errors.hasErrors()) {
			return "login/loginForm";
			
		}
		//2. 입력받은 아이디가 DB에 저장이 되었는가? 저장이 되어있다면 DB에서 가져온 비밀번호 일치여부 조사		
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getId(), loginCommand.getPassword());
			
			session.setAttribute("authInfo", authInfo);
			
			
			return "login/loginSuccess";
			//로그인 성공시 인증 정보를 저장
		}catch(IdPasswordNotMatchingException e) {
			// 이메일이 없거나 or 비밀번호가 틀렸을경우
			errors.reject("idPasswordNotMatching");
			return "login/loginForm";
		}
		
	}
	
	
}


