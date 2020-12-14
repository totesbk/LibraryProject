package spring.bookcontroller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.bookservice.BookDeleteService;
import spring.bookvo.DeleteBookCommand;
import spring.exception.AlreadyExistingMemberException;

@Controller
public class BookDeleteController {

	private BookDeleteService bookDeleteService;
	
	
	public void setBookDeleteService(BookDeleteService bookDeleteService) {
		this.bookDeleteService = bookDeleteService;
	}
	
	@RequestMapping(value="deletedone", method=RequestMethod.POST)	//
	public String handlerStep3(
			@ModelAttribute("delbook") DeleteBookCommand req, Errors errors) {
	
		if(errors.hasErrors()) {
			return "bookedit/bookdelete";
		}
		try {
			bookDeleteService.deleteBook(req);
			return "bookedit/deletedone";
		}catch(AlreadyExistingMemberException ee) {
			return "bookedit/bookdelete";
		}

	}
}
