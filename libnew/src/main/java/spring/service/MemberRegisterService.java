package spring.service;

import java.util.Date;

import spring.dao.MemberDao;
import spring.exception.AlreadyExistingMemberException;
import spring.vo.Admin;
import spring.vo.Member;
import spring.vo.RegisterRequest;

public class MemberRegisterService {
   
   private MemberDao memberDao; // = new MemberDao();

   public MemberRegisterService(MemberDao memberDao) {
      this.memberDao = memberDao;
   }

   public void regist(RegisterRequest req, Admin adm) {
      Member member = memberDao.selectById(req.getId());
      if (member != null) {
         throw new AlreadyExistingMemberException("dup id " + req.getId());
      }
      if(req.getAuthority().equals(adm.getCode_admin()) ) {
      	Member newMember = new Member(
      			req.getEmail(), req.getPhone(), req.getName(),req.getPassword(),req.getId(),req.getAuthority(),
      			new Date());
      	
      	memberDao.insert(newMember);
      }else {
    	  Member newMember = new Member(
        			req.getEmail(), req.getPhone(), req.getName(),req.getPassword(),req.getId(),null,
        			new Date());
        	
        	memberDao.insert(newMember);
      }
      
      
   }
}
