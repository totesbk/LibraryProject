package spring.boardcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.boardservice.FreeBoardUpdateService;
import spring.boardvo.UpdateBoardCommand;
import spring.exception.AlreadyExistingMemberException;

@Controller
public class FreeBoardUpdateController {

private FreeBoardUpdateService boardUpdateService;
	
	
	public void setBoardUpdateService(FreeBoardUpdateService boardUpdateService) {
		this.boardUpdateService = boardUpdateService;
	}
	
	@RequestMapping(value="boardEditDone", method=RequestMethod.POST)	//
	public String handlerStep3(
			@ModelAttribute("updateboard") UpdateBoardCommand req, Errors errors) {
	
		if(errors.hasErrors()) {
			return "boardEdit/boardEdit";
		}
		try {
			boardUpdateService.updateBoard(req);
			return "boardEdit/boardEditDone";
		}catch(AlreadyExistingMemberException ee) {
			return "boardEdit/boardEdit";
		}

	}
}
