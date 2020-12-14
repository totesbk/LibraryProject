package spring.bookservice;


import java.util.Date;

import spring.bookdao.BooksDao;
import spring.bookvo.Books;
import spring.bookvo.ChangeBookCommand;


public class BookUpdateService {
	
	
	
	private BooksDao booksDao;

	public BookUpdateService(BooksDao booksDao) {
		this.booksDao = booksDao;
	}

	public void changeBook(ChangeBookCommand req) {
		
		Books updateBook = new Books(
						req.getBookname(), req.getBookgenre(), req.getBookauthor(), req.getBookcontents(),
						new Date());
		
				booksDao.update(updateBook);
		
	}


}