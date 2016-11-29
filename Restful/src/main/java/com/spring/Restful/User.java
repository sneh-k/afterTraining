package com.spring.Restful;

public class User {
	
	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String emailId;
	private long phNo;

	public User() {
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(int userId, String username, String password) {
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	
	public User(int userId, String username, String password, String firstName, String lastName, String emailId,
			long phNo) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phNo = phNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhNo() {
		return phNo;
	}

	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", phNo=" + phNo + "]";
	}

//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", username=" + username + "]";
//	}
	
	

}
