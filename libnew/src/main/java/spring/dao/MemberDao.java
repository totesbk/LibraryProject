package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import spring.exception.MemberNotFoundException;
import spring.vo.Member;

public class MemberDao {   //데이터베이스 연결과 쿼리 전송
   
   private JdbcTemplate jdbcTemplate;

   
//    생성자 주입
//   public MemberDao(DataSource dataSource) {
//      this.jdbcTemplate = new JdbcTemplate(dataSource);
//   }
   
   //Set메소드 주입
   public void setDataSource(DataSource dataSource) {
      this.jdbcTemplate = new JdbcTemplate(dataSource);
   }
   
   RowMapper <Member> rowMapper = //데이터(RowMapper인터페이스 구현받은 객체);
           new RowMapper<Member>() {   //데이터(RowMapper인터페이스를 익명 구현받은 객체);

              @Override
              public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                 Member member = new Member(
                       rs.getString("email"),
                       rs.getString("phone"),
                       rs.getString("name"),  
                       rs.getString("password"), 
                       rs.getString("id"),
                       rs.getString("authority"),
                       rs.getTimestamp("regdate")
                      );

                 member.setMemberNumber(rs.getLong("memberNumber"));
                 
                 return member;   
              }

           };
           
           public Member selectById(String id) {
              String sql = "SELECT * FROM memberLibraryex WHERE id=?";
              List<Member> result = jdbcTemplate.query(sql, rowMapper, id);
              
              return result.isEmpty()?null:result.get(0);
          }

//   public Member selectById(String id) {      
//      List<Member> result = jdbcTemplate.query("SELECT * FROM memberLibary WHERE id=?", 
//            new RowMapper<Member>(){
//
//               @Override
//               public Member mapRow(ResultSet rs, int rowNum) throws SQLException {                  
//                  Member member = new Member(
//                        rs.getString("email"),
//                        rs.getString("phone"),
//                        rs.getString("name"),  
//                        rs.getString("password"), 
//                        rs.getString("id"),
//                        rs.getTimestamp("registerDate")
//                        
//                        );
//                  member.setMemberNumber(rs.getLong("memberNumber"));
//                  
//                  
//                  
//                  return member;
//               }
//               
//            },id);
//      return result.isEmpty() ? null : result.get(0);
//   }

   public void insert(Member member) {
      KeyHolder keyHolder = new GeneratedKeyHolder();
      
      jdbcTemplate.update(
            new PreparedStatementCreator() {

               @Override
               public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                  PreparedStatement psmt = con.prepareStatement(
                        "INSERT INTO memberLibraryex VALUES(memberLibaryex_seq.nextval,?,?,?,?,?,?,?)",new String[] {"memberNumber"});
                  psmt.setString(1, member.getEmail());
                  psmt.setString(2, member.getPhone());
                  psmt.setString(3, member.getName());                 
                  psmt.setString(4, member.getPassword());
                  psmt.setString(5, member.getId());      
                  psmt.setString(6, member.getAuthority());
                  psmt.setTimestamp(7,
                        new Timestamp(member.getRegisterDate().getTime()));
                  return psmt;
               }               
            },keyHolder);
      Number keyValue = keyHolder.getKey();

   }

   public void update(Member member) {
  
      jdbcTemplate.update(
            "UPDATE memberLibraryex set name=?,password=? WHERE id=?",
            member.getName(),
            member.getPassword(),
            member.getId()
            );
   }

   public List<Member> selectAll() {
      List<Member> result = jdbcTemplate.query("SELECT * FROM memberLibraryex ORDER BY id DESC",   //첫번째 매개값 : 쿼리문
            new RowMapper<Member>() {   //두번째 매개값 : 조회 후 받아올 데이터를 담을 그릇역할을 할 클래스. Row Mapper
               @Override
               public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                  Member member = new Member(
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("name"),  
                        rs.getString("password"), 
                        rs.getString("id"),
                        rs.getString("authority"),
                        rs.getTimestamp("registerDate")
                        );
                  member.setMemberNumber(rs.getLong("memberNumber"));
                  return member;
               }         
      });                        
      return result;
   }
   public int count() {
      Integer cnt = jdbcTemplate.queryForObject("SELECT count(*) from memberLibraryex",
            Integer.class);
      return cnt;
   }
   
   public void delete(String id) throws RuntimeException{
      Member member = selectById(id);
      try {
      if(member!=null) {
         jdbcTemplate.update(
               "DELETE FROM memberLibraryex WHERE id=?",
               id);   
         }else {
         throw new MemberNotFoundException();
         }
      }catch(MemberNotFoundException e) {
         System.out.println("해당 이메일이 존재하지 않습니다.");
      }
               
   }

      
   }
   










