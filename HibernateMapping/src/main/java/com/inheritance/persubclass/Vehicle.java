package com.inheritance.persubclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE")
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle {

	@Id
	@Column(name="id")
	private int vid;
	
	@Column(name="name")
	private String name;

	public Vehicle() {
	}

	public Vehicle(int vid, String name) {
		this.vid = vid;
		this.name = name;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", name=" + name + "]";
	}
		
}
