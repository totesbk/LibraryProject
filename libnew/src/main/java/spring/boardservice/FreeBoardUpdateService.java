package spring.boardservice;

import java.util.Date;

import spring.boarddao.FreeBoardDao;
import spring.boardvo.FreeBoard;
import spring.boardvo.UpdateBoardCommand;


public class FreeBoardUpdateService {

	
	
	private FreeBoardDao boardDao;

	public FreeBoardUpdateService(FreeBoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public void updateBoard(UpdateBoardCommand req) {
		
		FreeBoard updateBoard = new FreeBoard(
						req.getBoardTitle(), req.getBoardContents(),
						new Date());
		
			boardDao.update(updateBoard);
	}
}
