package spring.vo;

public class LoginCommand {//사용자로 부터 정보를 가져오는 커맨드 객체
		
	private String id;
	private String password;
	private boolean rememberId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isRememberId() {
		return rememberId;
	}
	public void setRememberEmail(boolean rememberId) {
		this.rememberId = rememberId;
	}
	public void setPassword(boolean b) {
		this.password=password;
		
	}
	
	
	
}
