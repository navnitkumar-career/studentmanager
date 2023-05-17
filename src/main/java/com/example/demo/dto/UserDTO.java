package com.example.demo.dto;

public class UserDTO {

	long id;
	String emailId;
	String userName;
	String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public void setPasword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", emailId=" + emailId + ", userName=" + userName + ", password=" + password + "]";
	}

}
