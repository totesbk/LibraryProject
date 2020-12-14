package spring.bookcontroller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.bookdao.BooksDao;
import spring.bookservice.BookSearchService;
import spring.bookvo.BookCommand;
import spring.bookvo.Books;


@Controller
public class BookSearchController {
	
//	private BooksDao booksDao;
	private BooksDao booksDao;
	
	public BookSearchController(BooksDao booksDao) {
		this.booksDao = booksDao;
	}
//	public void setBooksdao(BooksDao booksDao) {
//		this.booksDao = booksDao;
//	}


	private BookSearchService bookSearchService;
	
	public void setBookSearchService(BookSearchService bookSearchService) {
		this.bookSearchService = bookSearchService;
	}
	

	
	/*
	 * private BookSearchService bookSearchService; private Books books;
	 * 
	 * public void setBookSearchService(BookSearchService bookSearchService) {
	 * this.bookSearchService = bookSearchService; }
	 * 
	 * @RequestMapping(value = "/bookSearch", method = RequestMethod.POST) public
	 * String handlerStep2(@RequestParam(value = "agree",defaultValue="false")Model
	 * model) { // => /register/step2 // 'agree'라는 파라미터로 들어온 속성값을 => 매개변수 agree에
	 * 담는다.
	 * 
	 * model.addAttribute("bookCmd",new books()); return "/library/bookSearch"; }
	 */
	
	
	
	@RequestMapping(value="bookSearch",method=RequestMethod.GET)	
	public String form(BookCommand bookCommand,Errors errors) {	
		return "library/bookSearch";
	}

	
	@RequestMapping(value="bookSearch",method=RequestMethod.POST)
	public String submit(@ModelAttribute("bookCommand")BookCommand bookCommand,Errors errors,Model model) {
		System.out.println("포스트 들어옴");
		System.out.println(bookCommand.getBookName());
		String bookName = bookCommand.getBookName();
		//System.out.println(bookCommand.getBookNumber());
		List<Books> books = booksDao.selectByBookName(bookName);

		model.addAttribute("books",books); 
		model.addAttribute("bookCommand",bookCommand);
		return "library/bookSearch";
		
		

	}

//	private BooksDao dao;
//	
//	public void setBookDao(BooksDao dao) { 
//		this.dao=dao;
//	}
//	
//	@RequestMapping("library/bookSerach")
//	public String search(
//		BookCommand bookCommand,
//		Errors errors, Model model) {
//		
//		
//		if(errors.hasErrors()) {
//			return "library/bookSearch";
//		}
//		
//		if(bookCommand.getBookName()!=null) {
//			
//			Books books = 
//				dao.selectByBookName(bookCommand.getBookName());
//			model.addAttribute("bookCmd", books);
//		}
//	
//		return "library/bookSearch";
//	}
}
