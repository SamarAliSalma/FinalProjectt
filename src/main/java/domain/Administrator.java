package domain;

public class Administrator extends Person {
	private String userName;
	private String password;

	public Administrator() {
	}

	public Administrator(String name, int age, String userName, String password) {
		super(name, age);
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
