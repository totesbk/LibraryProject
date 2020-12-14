package spring.bookservice;



import spring.bookdao.BooksDao;
import spring.bookvo.Books;
import spring.bookvo.DeleteBookCommand;

public class BookDeleteService {

	private BooksDao booksDao;

	public BookDeleteService(BooksDao booksDao) {
		this.booksDao = booksDao;
	}

	public void deleteBook(DeleteBookCommand req) {
		
		Books deleteBook = new Books(req.getBookname());

		booksDao.delete(deleteBook);
		
	}

}
