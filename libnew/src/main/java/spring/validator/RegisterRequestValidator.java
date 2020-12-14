package spring.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.vo.RegisterRequest;

public class RegisterRequestValidator implements Validator{
   
   private static final String emailExp = 
         "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
   
   private Pattern pattern;
   
   public RegisterRequestValidator() {
      pattern = Pattern.compile(emailExp);
   }

   @Override
   public boolean supports(Class<?> clazz) {
      return RegisterRequest.class.isAssignableFrom(clazz);
   }
   //파라미터로 전달받은 객체가 RegisterRequest로 변환 가능한지 확인
   // 스프링에서 자동 검사 진행

   @Override
   public void validate(Object target, Errors errors) {
    //                  검사 대상 객체,     검사 결과 에러 코드
   //  검사 대상 객체의 특정 프로퍼티나 상태등이 올바른지 검사하고
   //  올바르지 않다면 Errors의 rejectValue() 메서드를 사용해서 에러코드를 저장
      
      RegisterRequest regReq = (RegisterRequest)target;
      
      if(regReq.getId()==null || regReq.getId().trim().isEmpty()) {
         errors.rejectValue("id","required");
      }else {
         Matcher matcher = pattern.matcher(regReq.getEmail());
         if(!matcher.matches()) {
            errors.rejectValue("email", "bad");
         }
      }
   
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
      // ValidationUtils객체는 자주 사용하는 객체의 값 검증 코드를 보다 간결하게 만들어준다.
      ValidationUtils.rejectIfEmpty(errors, "password", "required");
      ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
      
      if(!regReq.getPassword().isEmpty()) {
         if(!regReq.isPasswordEqualToConfirmPassword()) {
         errors.rejectValue("confirmPassword", "nomatch");
         }
      }
   }

}