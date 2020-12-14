package spring.bookvalidator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.bookvo.ChangeBookCommand;


public class ChangeBookCommandValidator implements Validator{

	
	@Override
	public boolean supports(Class<?> clazz) {
		return ChangeBookCommand.class.isAssignableFrom(clazz);
	}
	
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookgenre", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookauthor", "required");
	}
	
	
}
