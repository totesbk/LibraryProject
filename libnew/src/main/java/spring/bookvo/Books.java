package spring.bookvo;

import java.util.Date;

import spring.exception.IdPasswordNotMatchingException;

public class Books {

	private Long id;
	private String bookname;
	private String bookgenre;
	private String bookauthor;
	private String bookcontents;
	private Date registerDate;
	
	public Books(String bookname, String bookgenre, String bookauthor, String bookcontents,Date registerDate) {
		this.bookname = bookname;
		this.bookgenre = bookgenre;
		this.bookauthor = bookauthor;
		this.bookcontents = bookcontents;
		this.registerDate = registerDate;
	}
	
	public Books(String bookname) {
		this.bookname = bookname;
	}

	
	public void setId(Long id) {
		this.id = id;
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
	public String getBookcontents() {
		return bookcontents;
	}
	public Date getRegisterDate() {
		return registerDate;
	}

	
}
