package com.spring.entity;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="USER1")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="userId")
	private int userId;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="passWord")
	private String passWord;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="emailId")
	private String emailId;
	
	@Column(name="phNo")
	private int phNo;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(mappedBy="user", cascade={CascadeType.ALL})
	private Set<Message> msg;

	public User() {
	}

	public User(String userName, String passWord, String firstName, String lastName, String emailId, int phNo, Set<Message> msgs) {
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phNo = phNo;
		this.msg=msgs;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public int getPhNo() {
		return phNo;
	}

	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}

	public Set<Message> getMsg() {
		return msg;
	}

	public void setMsg(Set<Message> msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", phNo=" + phNo + "]";
	}

	
}
