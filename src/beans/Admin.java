package beans;

import java.util.Date;

public class Admin {

	private String userName;
	private String name;
	private String email;
	private String telephone;
	private String password;

	private String address;

	public Admin() {
	}
	
	public Admin(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Admin(String userName, String name, String email, String telephone, String password,
			String address) {
		this.userName = userName;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return this.getName() + ", " + this.getEmail() + ", " + this.getTelephone() + ", " + this.getPassword() + ", "
				 + this.getAddress();
	}

}
