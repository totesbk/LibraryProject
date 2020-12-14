package spring.bookcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.bookdao.BooksDao;
import spring.bookservice.BookWriteService;
import spring.bookvo.BookWrite;
import spring.bookvo.Books;
import spring.exception.AlreadyExistingMemberException;
import spring.exception.MemberNotFoundException;



@Controller
@RequestMapping("/write")
public class WriteBookController {
	
	
	private BookWriteService bookWriteService;
	
	
	public void setBookWriteService(BookWriteService bookWriteService) {
		this.bookWriteService = bookWriteService;
	}
	
	
	@RequestMapping(value ="/writebook", method=RequestMethod.GET)
			public String handlerStep2Get(Model model) {
			model.addAttribute("bookData",new BookWrite());
			return "write/writebook";
	}
			
	@RequestMapping(value ="/writesucces", method=RequestMethod.POST)	//	/register/step3;
	public String handlerStep3(
			@ModelAttribute("bookData") BookWrite regReq, Errors errors) {
			//errors 객체는 getFieldValue()메서드가 존재해서 커맨드객체의 특정 프로퍼티의 값을 가져올 수 있다.
		if(errors.hasErrors()) {
			return "write/writebook";
		}
		try {
			bookWriteService.write(regReq);
			return "write/writesucces";
		}catch(AlreadyExistingMemberException ee) {
			return "write/writebook";
		}

	}

}
