package spring.boardcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.boardservice.FreeBoardWriteService;
import spring.boardvo.BoardWrite;
import spring.exception.AlreadyExistingMemberException;

@Controller
@RequestMapping("/boardwrite")
public class FreeBoardWriteController {
	
	private FreeBoardWriteService boardWriteService;
	
	
	public void setBoardWriteService(FreeBoardWriteService boardWriteService) {
		this.boardWriteService = boardWriteService;
	}
	
	
	@RequestMapping(value ="/boardWrite", method=RequestMethod.GET)
			public String handlerStep2Get(Model model) {
			model.addAttribute("boardData",new BoardWrite());
			return "boardwrite/boardWrite";
	}
			
	@RequestMapping(value ="/boardWriteSuccess", method=RequestMethod.POST)	//	/register/step3;
	public String handlerStep3(
			@ModelAttribute("boardData") BoardWrite regReq, Errors errors) {
			//errors 객체는 getFieldValue()메서드가 존재해서 커맨드객체의 특정 프로퍼티의 값을 가져올 수 있다.
		if(errors.hasErrors()) {
			return "boardwrite/boardWrite";
		}
		try {
			boardWriteService.write(regReq);
			return "boardwrite/boardWriteSuccess";
		}catch(AlreadyExistingMemberException ee) {
			return "boardwrite/boardWrite";
		}

	}
}
