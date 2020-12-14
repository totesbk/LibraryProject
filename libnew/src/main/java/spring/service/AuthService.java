package spring.service;

import spring.dao.MemberDao;
import spring.exception.IdPasswordNotMatchingException;
import spring.vo.AuthInfo;
import spring.vo.Member;

public class AuthService {   //회원 인증 기능 => 빈 객체로 등록 => 주입을 받는다.
   
   private MemberDao memberDao;   

   public void setMemberDao(MemberDao memberDao) {
      this.memberDao = memberDao;
   }

   public AuthInfo authenticate(String id, String password) {
      Member member = memberDao.selectById(id);

      if(member==null) {
         throw new IdPasswordNotMatchingException();
      }
     // if(!member.getPassword().equals(password)) {
      if(!member.matchPassword(password)) {   
         throw new IdPasswordNotMatchingException();
      }

      return new AuthInfo(member.getId(), member.getPassword(), member.getName(), member.getAuthority());
   }

}