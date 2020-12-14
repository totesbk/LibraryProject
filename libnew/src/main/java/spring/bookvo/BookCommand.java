package spring.bookvo;

public class BookCommand {

	private Long bookNumber;
	private String bookName;
	private String bookGenre;
	private String bookAuthor;	
	
	public Long getBookNumber() {
		return bookNumber;
	}


	public void setBookNumber(Long bookNumber) {
		this.bookNumber = bookNumber;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBookGenrer() {
		return bookGenre;
	}


	public void setBookGenrer(String bookGenrer) {
		this.bookGenre = bookGenrer;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	


	
	
}
