package spring.boarddao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import spring.boardvo.FreeBoard;

public class FreeBoardDao {

private JdbcTemplate jdbcTemplate;
   
   
   
   public void setDataSource(DataSource dataSource) {
      this.jdbcTemplate = new JdbcTemplate(dataSource);
   }
   
   
   RowMapper<FreeBoard> rowMapper = //데이터(RowMapper인터페이스를 구현받은 객체); 
         new RowMapper<FreeBoard>() {//데이터(RowMapper인터페이스를 구현받은 익명 구현 객체); 
            @Override
            public FreeBoard mapRow(ResultSet rs, int rowNum) 
                  throws SQLException {
               FreeBoard freeBoards = new FreeBoard(
                     rs.getString("boardTitle"),
                     rs.getString("boardWriter"),
                     rs.getString("boardContents"),
                     rs.getLong("boardCount"),
                     rs.getTimestamp("regdate")
                     );
               freeBoards.setBoardNum(rs.getLong("boardNum"));
               return freeBoards;
            }
         };
   
   public List<FreeBoard> selectAll() {
      List<FreeBoard> results = jdbcTemplate.query(
            "SELECT * FROM freeboard ORDER BY boardNum DESC",// 첫번째 매개값 : 쿼리문
         
            rowMapper);
            return results;
   }
   public FreeBoard selectByboardNum(Long boardNum) {
      String sql = "SELECT * FROM freeboard WHERE boardnum=?";
      List<FreeBoard> result = jdbcTemplate.query(sql,rowMapper,boardNum);
      
      return result.isEmpty()?null:result.get(0);
   }
   
   
   public void insert(FreeBoard freeBoard) {
      KeyHolder keyHolder = new GeneratedKeyHolder();
      
      jdbcTemplate.update(// update(PreparedStatementCreator객체,keyHolder);
            new PreparedStatementCreator() {

               @Override
               public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                  PreparedStatement psmt = con.prepareStatement(
                        "INSERT INTO FreeBoard VALUES(Free_Boards_seq.nextval,?,?,?,0,?)",
                        new String[] {"boardNum"});
                  psmt.setString(1,freeBoard.getBoardTitle());
                  psmt.setString(2,freeBoard.getBoardWriter());
                  psmt.setString(3,freeBoard.getBoardContents());
							/* psmt.setLong(4,freeBoard.getBoardCount()); */

                  psmt.setTimestamp(4,
                        new Timestamp(freeBoard.getRegdate().getTime()));
                  
                  return psmt;
               }
            },keyHolder);
      Number keyValue = keyHolder.getKey();
      freeBoard.setBoardNum(keyValue.longValue());
   }
   

   public void update(FreeBoard freeBoard) {
      jdbcTemplate.update(
            "UPDATE FreeBoard set boardContents=? WHERE boardTitle=?",
            freeBoard.getBoardContents(),
            freeBoard.getBoardTitle()
            );
   }
   
   public void delete(FreeBoard freeBoard) {
       jdbcTemplate.update(
            "DELETE FreeBoard WHERE boardTitle=?",
            freeBoard.getBoardTitle()
            );
   }
   
   public FreeBoard selectByBoardTitle(String boardTitle) {
      String sql = "SELECT * FROM FreeBoard WHERE boardTitle=?";
      List<FreeBoard> result = jdbcTemplate.query(sql, rowMapper, boardTitle);
      return result.isEmpty() ? null : result.get(0);
   }   
   

   
}