package spring.bookvalidator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class BookSearchValidator implements Validator{

	
	@Override
	public boolean supports(Class<?> clazz) {
		return BookSearchValidator.class.isAssignableFrom(clazz);
	}
	
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookName", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookGenre", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookAuthor", "required");

	}
	
	
}
