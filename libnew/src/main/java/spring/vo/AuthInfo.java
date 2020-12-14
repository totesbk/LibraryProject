package spring.vo;

public class AuthInfo {	//로그인 성공후 로그인 정보를 저장하기 위한 객체

	private String id;
	private String password;
	private String name;
	private String authority;
	
	public AuthInfo(String id, String password,String name,String authority) {
		this.id = id;
		this.password = password;
		this.name=name;
		this.authority = authority;
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getAuthority() {
		return authority;
	}
	
	
	
	
}
