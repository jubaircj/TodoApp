package mvc.com.bean;

public class UserBEAN {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private String first_name, last_name, username, password;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserBEAN [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", username="
				+ username + ", password=" + password + ", loginusername=" + loginusername + ", loginpassword="
				+ loginpassword + "]";
	}
	
	private String loginusername, loginpassword;
	public String getLoginusername() {
		return loginusername;
	}
	public void setLoginusername(String loginusername) {
		this.loginusername = loginusername;
	}
	public String getLoginpassword() {
		return loginpassword;
	}
	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}
	
}
