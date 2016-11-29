package com.spring.chatapp;

import java.util.List;
import java.util.Set;

public class Chatroom {
	
	private int id;
	private String cname;
	private List<User> user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Chatroom [id=" + id + ", cname=" + cname + ", user=" + user + "]";
	}
	
}
