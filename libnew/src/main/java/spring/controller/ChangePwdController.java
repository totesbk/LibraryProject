package spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.exception.IdPasswordNotMatchingException;
import spring.service.ChangePasswordService;
import spring.validator.ChangePwdCommandValidator;
import spring.vo.AuthInfo;
import spring.vo.ChangePwdCommand;

@Controller
@RequestMapping("edit/changePassword")
public class ChangePwdController{

	private ChangePasswordService changePasswordService;
	
	public ChangePwdController(ChangePasswordService changePasswordService) {
		this.changePasswordService=changePasswordService;
	}
	
//  1.   Model객체를 이용하는 방법 
//	@RequestMapping(method=RequestMethod.GET)
//	public String form(Model model) {
//		model.addAttribute("changePwdCommand", new ChangePwdCommand());
//		return "edit/changePwdForm";
//	}
	
//	2.   @ModelAttribute 애노테이션을 이용하는 방법
//	@RequestMapping(method=RequestMethod.GET)
//	public String form(
//			@ModelAttribute("changePwdCommand") ChangePwdCommand changePwdCommand) {
//		return "edit/changePwdForm";
//	}
	
//  3.   Post하고 같은 커맨드 객체를 사용하는 경우 model을 생략 가능
	@RequestMapping(method=RequestMethod.GET)
	public String form(ChangePwdCommand changePwdCommand, HttpSession session) {
//		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
//		
//		if(authInfo==null) {
//			return "redirect:/login";
//		}
		
		return "edit/changePwdForm";
	}
	
//	@RequestMapping(method=RequestMethod.POST)
//	public String submit(
//			@ModelAttribute("changePwdCommand") ChangePwdCommand changePwdCommand,
//			Errors errors) {
	@RequestMapping(method=RequestMethod.POST)
	public String submit(ChangePwdCommand changePwdCommand,
			Errors errors,HttpSession session) {
		new ChangePwdCommandValidator().validate(changePwdCommand, errors);
		
		if(errors.hasErrors()) {
			return "edit/changePwdForm";
		}
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		try {
			changePasswordService.changePassword(
					authInfo.getId(), 
					changePwdCommand.getCurrentPassword(),
					changePwdCommand.getNewPassword());
			
			return "edit/changedPwd";
		
		}catch(IdPasswordNotMatchingException err) {// 입력한 기존 비밀번호가 저장된 비밀번호와 다른 경우     
			errors.rejectValue("currentPassword", "notMatching");
			return "edit/changePwdForm";
		}
		
		
		
		
	}
	
}





