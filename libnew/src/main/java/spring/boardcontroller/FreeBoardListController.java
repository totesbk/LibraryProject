package spring.boardcontroller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.boarddao.FreeBoardDao;
import spring.boardvo.FreeBoard;

@Controller
public class FreeBoardListController {

	
	private FreeBoardDao dao;
	
	public void setBoardDao(FreeBoardDao dao) {
		this.dao = dao;
	}


	@RequestMapping("board/freeBoardList")
	public String list(
				Model model) {
			List<FreeBoard> boards = dao.selectAll();
			model.addAttribute("boards",boards);
		
		return "board/freeBoardList";
	}

}
