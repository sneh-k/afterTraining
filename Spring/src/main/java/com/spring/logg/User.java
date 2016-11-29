package com.spring.logg;

public class User {

	private String username;
	private String password;
	private String first_name;
	private String country;
	
	public User() {
	}

	public User(String username, String password, String first_name, String country) {
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.country = country;
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", first_name=" + first_name + ", country="
				+ country + "]";
	}
	
}
