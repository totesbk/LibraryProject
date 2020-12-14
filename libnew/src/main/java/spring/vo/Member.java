package spring.vo;

import java.util.Date;

import spring.exception.IdPasswordNotMatchingException;

public class Member {

	private Long memberNumber;
	private String email;
	private String phone;
	private String name;
	private String password;
	private String id;
	private String authority;
	private Date registerDate;

	
	public Member(String email, String phone, String name, String password,String id, Date registerDate) {
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.password = password;
		this.id=id;
		this.registerDate = registerDate;
	}
	
	public Member(String email, String phone, String name, String password,String id,String authority, Date registerDate) {
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.password = password;
		this.id=id;
		this.authority = authority;
		this.registerDate = registerDate;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new IdPasswordNotMatchingException();
		this.password = newPassword;
		System.out.println(password+"비밀번호 바꿈!");
		
	}

	public boolean matchPassword(String inputPassword) {
		return this.password.equals(inputPassword);
		
	}

	public Long getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(Long memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getId() {
		return id;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public String getAuthority() {
		return authority;
	}

	
	
	
	
}
