package spring.bookcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.bookdao.BooksDao;
import spring.bookvo.Books;
import spring.exception.MemberNotFoundException;



@Controller
public class BookDetailController {

	private BooksDao booksdao;
	
	public void setBooksDao(BooksDao booksdao) {
		this.booksdao = booksdao;
	}
	
	@RequestMapping("/library/bookdetail/{id}")
	public String detail(@PathVariable("id") Long memId,Model model) {
		//특정 누군가의 정보를 보고 싶은 것
		// 필요한 정보?? 특정 누군가를 식별할수 있는 정보 => Id => memId
		
		// 보여주고 싶은 것 => 누군가의 정보(Member)
		
		Books m = booksdao.selectById(memId);
		
		if(m==null) {
			throw new MemberNotFoundException();
		}
		
		model.addAttribute("books",m);
		
		
		return "library/bookdetail";
	}
	
	@RequestMapping("/bookedit/bookedit/{id}")
	public String changedetail(@PathVariable("id") Long memId,Model model) {
		//특정 누군가의 정보를 보고 싶은 것
		// 필요한 정보?? 특정 누군가를 식별할수 있는 정보 => Id => memId
		// 보여주고 싶은 것 => 누군가의 정보(Member)
		
		
		Books m = booksdao.selectById(memId);
		
		if(m==null) {
			throw new MemberNotFoundException();
		}
		model.addAttribute("cbooks",m);

		
		return "/bookedit/bookedit";
	}
	
	@RequestMapping("/bookedit/bookdelete/{id}")
	public String deletedata(@PathVariable("id") Long memId,Model model) {
		//특정 누군가의 정보를 보고 싶은 것
		// 필요한 정보?? 특정 누군가를 식별할수 있는 정보 => Id => memId
		// 보여주고 싶은 것 => 누군가의 정보(Member)
		
		
		Books m = booksdao.selectById(memId);
		
		if(m==null) {
			throw new MemberNotFoundException();
		}
		model.addAttribute("dbooks",m);

		
		return "/bookedit/bookdelete";
	}
	
	
	
	
	
	
	
	
}
