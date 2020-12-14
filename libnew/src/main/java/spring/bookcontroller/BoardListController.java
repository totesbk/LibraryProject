package spring.bookcontroller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.bookdao.BooksDao;
import spring.bookvo.Books;


@Controller
public class BoardListController {
	
	private BooksDao dao;
		
	public void setBooksDao(BooksDao dao) {
		this.dao = dao;
	}


	@RequestMapping("library/board")
	public String list(
				Model model) {
			List<Books> books = dao.selectAll();
			System.out.println("books : " + books.size());
			model.addAttribute("books",books);
		
		return "library/board";
	}

}

			
	