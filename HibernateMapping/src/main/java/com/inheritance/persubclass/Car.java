package com.inheritance.persubclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CAR")
@PrimaryKeyJoinColumn(name="id")
public class Car extends Vehicle {

	@Column(name="cost")
	private int cost;

	public Car() {
	}
	
	public Car(int vid, String name, int cost) {
		super(vid, name);
		this.cost = cost;
	}

	public int getWheels() {
		return cost;
	}

	public void setWheels(int wheels) {
		this.cost = wheels;
	}

	@Override
	public String toString() {
		return "Car [cost=" + cost + "]";
	}
	
		
}
