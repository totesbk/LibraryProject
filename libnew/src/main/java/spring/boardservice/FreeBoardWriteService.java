package spring.boardservice;

import java.util.Date;

import spring.boarddao.FreeBoardDao;
import spring.boardvo.BoardWrite;
import spring.boardvo.FreeBoard;
import spring.exception.AlreadyExistingMemberException;

public class FreeBoardWriteService {

	private FreeBoardDao boardDao;
	
	
	public FreeBoardWriteService(FreeBoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public void write(BoardWrite req) {
		FreeBoard boards = boardDao.selectByBoardTitle(req.getBoardTitle());
		if (boards != null) {
			throw new AlreadyExistingMemberException("dup boardTitle " + req.getBoardTitle());
		}
		FreeBoard newBoard = new FreeBoard(
				req.getBoardTitle(), req.getBoardWriter(), req.getBoardContents(),
				new Date());
		boardDao.insert(newBoard);
	}
	
	
}
