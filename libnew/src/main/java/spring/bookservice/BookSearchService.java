package spring.bookservice;

import java.util.Date;
import java.util.List;

import org.springframework.validation.Errors;

import spring.bookdao.BooksDao;
import spring.bookvo.BookCommand;
import spring.bookvo.Books;
import spring.exception.AlreadyExistingMemberException;



public class BookSearchService {

	
	private BooksDao booksDao;
	
	
	public BookSearchService(BooksDao booksDao) {
		this.booksDao = booksDao;
	}

	public List<Books> search(Books req) {
		List<Books> books = booksDao.selectByBookName(req.getBookname());
		if (books != null) {
			throw new AlreadyExistingMemberException("dup bookname " + req.getBookname());
		}
		
		
		return books;
		
	}

	
	
}
