package com.hibernate.ChattingApp;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="User")
public class User {

	@Id
	@GeneratedValue
	@Column(name="userid")
	private int userid;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private Chatroom chatroom;
		
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(mappedBy="user", cascade={CascadeType.ALL})
	private Set<Messages> msgs;

	
	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public Chatroom getChatroom() {
		return chatroom;
	}

	public void setChatroom(Chatroom chatroom) {
		this.chatroom = chatroom;
	}

	public Set<Messages> getMsgs() {
		return msgs;
	}

	public void setMsgs(Set<Messages> msgs) {
		this.msgs = msgs;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", msgs=" + msgs + "]";
	}
	
}
