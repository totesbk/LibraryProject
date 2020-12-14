package spring.boardvo;

import java.util.Date;

public class FreeBoard {

	private Long boardNum;
	private String boardTitle;
	private String boardWriter;
	private String boardContents;
	private Long boardCount;
	private Date regdate;
	
	
	
	//출력 관련
	public FreeBoard(String boardTitle, String boardWriter, String boardContents, Long boardCount,
			Date regdate) {
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContents = boardContents;
		this.regdate = regdate;
	}

	//Update 관련
	public FreeBoard(String boardTitle, String boardContents, Date regdate) {
		this.boardTitle = boardTitle;
		this.boardContents = boardContents;
		this.regdate = regdate;
	}
	
	//생성 관련
	public FreeBoard(String boardTitle, String boardWriter, String boardContents, Date regdate) {
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContents = boardContents;
		this.regdate = regdate;
	}
	
	
	//Delete 관련
	public FreeBoard(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	
	
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public Date getRegdate() {
		return regdate;
	}
	public Long getBoardCount() {
		return boardCount;
	}
	
	

	
	
	

	
	
}
