package com.inheritance.perclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CAR")
@AttributeOverrides({  
    @AttributeOverride(name="cid", column=@Column(name="id")),  
    @AttributeOverride(name="cname", column=@Column(name="name"))  
})public class Car extends Vehicle {

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
