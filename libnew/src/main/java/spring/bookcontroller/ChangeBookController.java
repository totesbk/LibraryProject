package spring.bookcontroller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.bookservice.BookUpdateService;
import spring.bookvo.ChangeBookCommand;
import spring.exception.AlreadyExistingMemberException;


@Controller
public class ChangeBookController {
	

	private BookUpdateService bookUpdateService;
	
	
	public void setBookUpdateService(BookUpdateService bookUpdateService) {
		this.bookUpdateService = bookUpdateService;
	}
	
	@RequestMapping(value="editdone", method=RequestMethod.POST)	//
	public String handlerStep3(
			@ModelAttribute("chbook") ChangeBookCommand req, Errors errors) {
	
		if(errors.hasErrors()) {
			return "bookedit/bookedit";
		}
		try {
			bookUpdateService.changeBook(req);
			return "bookedit/editdone";
		}catch(AlreadyExistingMemberException ee) {
			return "bookedit/bookedit";
		}

	}
	
}
