package com.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToOne(cascade= CascadeType.ALL , fetch=FetchType.LAZY)
	@JoinColumn(name="eid")
	private Enquiry e;

	public Customer() 
	{
	}
	
	public Customer(String name, Enquiry eid) 
	{
		this.name = name;
		this.e = eid;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Enquiry getEid() {
		return e;
	}

	public void setEid(Enquiry eid) {
		this.e = eid;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", eid=" + e + "]";
	}
	
	
	
	
}
