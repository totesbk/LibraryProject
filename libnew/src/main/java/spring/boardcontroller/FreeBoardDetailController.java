package spring.boardcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.boarddao.FreeBoardDao;
import spring.boardvo.FreeBoard;
import spring.exception.MemberNotFoundException;

@Controller
public class FreeBoardDetailController {

	private FreeBoardDao boardDao;
	
	public void setBoardDao(FreeBoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@RequestMapping("/board/freeBoardDetail/{boardnum}")
	public String detail(@PathVariable("boardnum") Long memId,Model model) {

		FreeBoard m = boardDao.selectByboardNum(memId);
		
		if(m==null) {
			throw new MemberNotFoundException();
		}
		
		model.addAttribute("board",m);
		
		
		return "board/freeBoardDetail";
	}
	
	@RequestMapping("/boardEdit/boardEdit/{boardNum}")
	public String changedetail(@PathVariable("boardNum") Long memId,Model model) {
	
		
		FreeBoard m = boardDao.selectByboardNum(memId);
		
		if(m==null) {
			throw new MemberNotFoundException();
		}
		
		model.addAttribute("editBoard",m);
		
		
		return "boardEdit/boardEdit";
	}
	
	@RequestMapping("/boardEdit/boardDelete/{boardNum}")
	public String deletedata(@PathVariable("boardNum") Long memId,Model model) {
		
		FreeBoard m = boardDao.selectByboardNum(memId);
		
		if(m==null) {
			throw new MemberNotFoundException();
		}
		
		model.addAttribute("deleteBoard",m);
		
		
		return "boardEdit/boardDelete";
	}
	
	
	
	
	
}
