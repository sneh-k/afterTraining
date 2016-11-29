package com.inheritance.persubclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="BIKE")
@PrimaryKeyJoinColumn(name="id")
public class Bike  extends Vehicle{

	@Column(name="price")
	private int price;

	public Bike() {
	}
	
	public Bike(int vid, String name, int price) {
		super(vid, name);
		this.price = price;
	}

	public int getWheels() {
		return price;
	}

	public void setWheels(int wheels) {
		this.price = wheels;
	}

	@Override
	public String toString() {
		return "Bike [price=" + price + "]";
	}
	
}
