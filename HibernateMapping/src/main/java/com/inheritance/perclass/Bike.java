package com.inheritance.perclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BIKE")
@AttributeOverrides({  
    @AttributeOverride(name="bid", column=@Column(name="id")),  
    @AttributeOverride(name="bname", column=@Column(name="name"))  
})
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
