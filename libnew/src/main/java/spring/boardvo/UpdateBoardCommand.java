package spring.boardvo;

public class UpdateBoardCommand {
	
	private String boardTitle;
	private String boardContents;
	
	
	
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}

	
	
	

}
