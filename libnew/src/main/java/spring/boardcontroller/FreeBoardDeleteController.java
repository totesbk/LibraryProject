package spring.boardcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.boardservice.FreeBoardDeleteService;
import spring.boardvo.DeleteBoardCommand;
import spring.exception.AlreadyExistingMemberException;

@Controller
public class FreeBoardDeleteController {


	private FreeBoardDeleteService boardDeleteService;
	
	
	public void setBoardDeleteService(FreeBoardDeleteService boardDeleteService) {
		this.boardDeleteService = boardDeleteService;
	}
	
	@RequestMapping(value="boardDeleteDone", method=RequestMethod.POST)	//
	public String handlerStep3(
			@ModelAttribute("delboard") DeleteBoardCommand req, Errors errors) {
	
		if(errors.hasErrors()) {
			return "boardEdit/boardDelete";
		}
		try {
			boardDeleteService.deleteBoard(req);
			return "boardEdit/boardDeleteDone";
		}catch(AlreadyExistingMemberException ee) {
			return "boardEdit/boardDelete";
		}

	}
	
}
