package com.hibernate;

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
@Table(name="Market")
public class Market {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(mappedBy="market", cascade={CascadeType.ALL})
	private Set<Stock> s;

	Market()
	{
		
	}
	
	public Market(String name) {
		this.name = name;
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

	public Set<Stock> getS() {
		return s;
	}

	public void setS(Set<Stock> s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "Market [id=" + id +" name=" + name + ", s=" + s + "]";
	}



	
	
}
