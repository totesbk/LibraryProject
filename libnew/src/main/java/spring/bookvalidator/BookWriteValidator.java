package spring.bookvalidator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.bookvo.BookWrite;
import spring.vo.RegisterRequest;


public class BookWriteValidator  implements Validator{
	

	@Override
	public boolean supports(Class<?> clazz) {
		return BookWrite.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		// 			검사 대상 객체, 			검사 결과 에러 코드
		//검사 대상 객체의 특정 프로퍼티나 상태등이 올바른지 검사하고
		//올바르지 않다면 Errors의 rejectValue() 메서드를 사용해서 에러코드를 저장	
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookname", "required");
		ValidationUtils.rejectIfEmpty(errors, "bookgenre", "required");
		ValidationUtils.rejectIfEmpty(errors, "bookauthor", "required");
		ValidationUtils.rejectIfEmpty(errors, "bookcontents", "required");

	}

		

}