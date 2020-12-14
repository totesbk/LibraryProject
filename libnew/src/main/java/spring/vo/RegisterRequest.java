package spring.vo;

import java.util.Date;

public class RegisterRequest {

	private long memberNumber;
	private String email;
	private String phone;
	private String name;
	private String password;
	private String confirmPassword;
	private String id;
	private String authority;
	private Date registerDate;
	

	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public long getMemberNumber() {
		return memberNumber;
	}


	public void setMemberNumber(long memberNumber) {
		this.memberNumber = memberNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}


	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword);
	}


	

	

	
}
