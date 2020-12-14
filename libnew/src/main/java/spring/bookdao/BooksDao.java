package spring.bookdao;

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

import spring.bookvo.Books;

public class BooksDao {

	private JdbcTemplate jdbcTemplate;
	
	
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	RowMapper<Books> rowMapper = //데이터(RowMapper인터페이스를 구현받은 객체); 
			new RowMapper<Books>() {//데이터(RowMapper인터페이스를 구현받은 익명 구현 객체); 
				@Override
				public Books mapRow(ResultSet rs, int rowNum) 
						throws SQLException {
					Books book = new Books(
							rs.getString("bookname"),
							rs.getString("bookgenre"),
							rs.getString("bookauthor"),
							rs.getString("bookcontents"),
							rs.getTimestamp("regdate")							
							);
					book.setId(rs.getLong("id"));
					return book;
				}
			};
	
	
	
	public List<Books> selectAll() {
		List<Books> results = jdbcTemplate.query(
				"SELECT * FROM BOOKS ORDER BY id DESC",// 첫번째 매개값 : 쿼리문

				
				rowMapper);
				return results;
	}
	
	
	public Books selectById(Long id) {
		String sql = "SELECT * FROM BOOKS WHERE id=?";
		List<Books> result = jdbcTemplate.query(sql,rowMapper,id);
		
		return result.isEmpty()?null:result.get(0);
	}
	
	
	public void insert(Books book) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(// update(PreparedStatementCreator객체,keyHolder);
				new PreparedStatementCreator() {

					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement psmt = con.prepareStatement(
								"INSERT INTO BOOKS VALUES(books_seq.nextval,?,?,?,?,?)",
								new String[] {"id"});
						psmt.setString(1,book.getBookname());
						psmt.setString(2,book.getBookgenre());
						psmt.setString(3,book.getBookauthor());
						psmt.setString(4,book.getBookcontents());

						psmt.setTimestamp(5,
								new Timestamp(book.getRegisterDate().getTime()));
						
						return psmt;
					}
				},keyHolder);
		Number keyValue = keyHolder.getKey();
		book.setId(keyValue.longValue());
	}
	
	
	public Books selectByBookname(String email) {
		String sql = "SELECT * FROM BOOKS WHERE bookname=?";
		
		List<Books> result = jdbcTemplate.query(sql,rowMapper,email);//*****
		
		return result.isEmpty()?null:result.get(0);
		
		
	}
	
	
	public void update(Books book) {
		jdbcTemplate.update(
				"UPDATE BOOKS set bookgenre=?, bookauthor=?, bookcontents=? WHERE bookname=?",
				book.getBookgenre(),
				book.getBookauthor(),
				book.getBookcontents(),
				book.getBookname()
				);
	}
	
	public void delete(Books book) {
		 jdbcTemplate.update(
				"DELETE BOOKS WHERE bookname=?",
				book.getBookname()
				);
	}

	
	public List<Books> selectByBookName(String bookName) {
		/* System.out.println("이름으로 찾으로 왓다"); */
		bookName = "%"+bookName+"%";
		String sql = "SELECT * FROM books WHERE bookName LIKE ?";
		List<Books> result = jdbcTemplate.query(sql, rowMapper, bookName);
		return result;
	}	

}
	
	
	
	
	
	
	

