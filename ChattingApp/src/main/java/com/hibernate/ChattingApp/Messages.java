package com.hibernate.ChattingApp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Messages")
public class Messages {

	@Id
	@GeneratedValue
	@Column(name="mid")
	private int mid;
	
	@Column(name="msg")
	private String msg;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
	private User user;

	
	public Messages() {
	}

	public Messages(String msg) {
		this.msg = msg;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Messages [mid=" + mid + ", msg=" + msg + "]";
	}
	
	
	
}
