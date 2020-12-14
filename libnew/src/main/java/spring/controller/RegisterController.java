package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.exception.AlreadyExistingMemberException;
import spring.service.MemberRegisterService;
import spring.validator.RegisterRequestValidator;
import spring.vo.Admin;
import spring.vo.RegisterRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {
   
   
   
private MemberRegisterService memberRegisterService;
   
   public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
      this.memberRegisterService = memberRegisterService;
   }
   
   @RequestMapping("step1")
   public String handlerLogin1() {  // => /register/step1
      return "/register/step1";
   }

//   요청 파라미터를 받는 첫 번째 방법 HttpServletRequest 사용
   
//   @RequestMapping(value = "/step2", method = RequestMethod.POST) // => /register/step2 포스트 방식으로 
//   public String handlerStep2(HttpServletRequest request) {  // => /register/step2
//      //                   => 서블릿 doget(HttpServletRequest request,HttpServletRequest response)
//      String agreeParam = request.getParameter("agree");
//      if(agreeParam == null || !agreeParam.equals("true")) {
//         return "/register/step1";
//      }
//      return "/register/step2";
//   }
   
//   요청 파라미터를 받는 두 번째 방법 @RequestParam 어노테이션

   @RequestMapping(value = "/step2", method = RequestMethod.POST)
   public String handlerStep2(@RequestParam(value = "agree",defaultValue="false")boolean agree,Model model) {  // => /register/step2
//                        'agree'라는 파라미터로 들어온 속성값을 => 매개변수 agree에 담는다.

      if(!agree) {
         return "/register/step1";
      }
      model.addAttribute("formData",new RegisterRequest());
      return "/register/step2";
   }

   @RequestMapping(value="/step2",method=RequestMethod.GET)
   public String handlerStep2Get() {
      return "redirect:step1";
      //return "register/step1";
   }
   
//   @RequestMapping("/step3")
//   public String handlerStep3(
//     @RequestParam(value="email")String email,
//     @RequestParam(value="name")String name,
//     @RequestParam(value="password")String password,
//     @RequestParam(value="confirmPassword")String confirmPassword
//     ){
//        return "register/step3";
//     }
//   }

   @RequestMapping(value="/step3",method=RequestMethod.POST)
   public String handlerStep3(@ModelAttribute("formData")RegisterRequest regReq, Errors errors, Admin Admin) {
     
//      System.out.println("이름 :"+regReq.getName());
//      System.out.println("이메일 :"+regReq.getEmail());
//      System.out.println("비밀번호 :"+regReq.getPassword());
      
      new RegisterRequestValidator().validate(regReq,errors);
      //errors 객체는 getFieldValue() 메서드가 존재해서 커맨드객체의 특정 프로퍼티의 값을 가져올 수 있다.
      if(errors.hasErrors()) {
         //에러가 발생하면(rejectValue 메서드가 실행되면) 단 한번이라도 에러 발생시 hasErrors 메소드는 true를 반환
         return "register/step2";
      }
      try {
         
		memberRegisterService.regist(regReq, Admin);         
         return "register/step3";
      }catch(AlreadyExistingMemberException ee) {
         errors.rejectValue("id", "duplicate");
         ee.getMessage();
         return "register/step2";
      }
      
      
   }
}
