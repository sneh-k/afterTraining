package com.spring.chatapp;

import java.util.List;
import java.util.Set;

public class User {
	
	private int uid;
	private String uname;
	private List<Message> message;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public List<Message> getMessage() {
		return message;
	}
	public void setMessage(List<Message> message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", message=" + message + "]";
	}
	
}
