package model;

public class JavaBeans {
	private String id;
	private String name;
	private String email;
	private String phone;
	private String user;
	private String password;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String name, String email, String phone, String user, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.user = user;
		this.password = password;
	}

	public JavaBeans(String id, String name, String email, String phone, String user, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.user = user;
		this.password = password;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
