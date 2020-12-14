package spring.boardservice;

import spring.boarddao.FreeBoardDao;
import spring.boardvo.FreeBoard;
import spring.boardvo.DeleteBoardCommand;

public class FreeBoardDeleteService {

	private FreeBoardDao boardDao;

	public FreeBoardDeleteService(FreeBoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public void deleteBoard(DeleteBoardCommand req) {
		
		FreeBoard deleteBoard = new FreeBoard(req.getBoardTitle());

		boardDao.delete(deleteBoard);
		
	}
}
