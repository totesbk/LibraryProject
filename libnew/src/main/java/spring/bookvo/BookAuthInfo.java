package spring.bookvo;

public class BookAuthInfo {

	private Long id;
	private String bookname;
	private String bookgenre;
	private String bookauthor;
	
	
	public BookAuthInfo(Long id, String bookname, String bookgenre, String bookauthor) {
		this.id = id;
		this.bookname = bookname;
		this.bookgenre = bookgenre;
		this.bookauthor = bookauthor;
	}


	public Long getId() {
		return id;
	}
	public String getBookname() {
		return bookname;
	}
	public String getBookgenre() {
		return bookgenre;
	}
	public String getBookauthor() {
		return bookauthor;
	}

	
}
	
	

