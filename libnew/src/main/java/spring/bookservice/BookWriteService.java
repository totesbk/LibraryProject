package spring.bookservice;

import java.util.Date;

import spring.bookdao.BooksDao;
import spring.bookvo.BookWrite;
import spring.bookvo.Books;
import spring.exception.AlreadyExistingMemberException;


public class BookWriteService {

	
	private BooksDao booksDao;
	
	
	public BookWriteService(BooksDao booksDao) {
		this.booksDao = booksDao;
	}

	public void write(BookWrite req) {
		Books books = booksDao.selectByBookname(req.getBookname());
		if (books != null) {
			throw new AlreadyExistingMemberException("dup bookname " + req.getBookname());
		}
		Books newBook = new Books(
				req.getBookname(), req.getBookgenre(), req.getBookauthor(),req.getBookcontents(),
				new Date());
		booksDao.insert(newBook);
	}
	
	
	
	
	
	
	
	
	
}
