package com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(name="getAllEmp",
			query="from Emp"),
	@NamedQuery(name="getSum",
		query="Select sum(sal) from Emp"),
	@NamedQuery(name="getOrderSal",
		query="from Emp ORDER BY sal"),
	@NamedQuery(name="getGroupCity",
		query="Select count(*) from Emp GROUP BY city"),
	@NamedQuery(name="getAvgSal",
		query="Select avg(sal) from Emp")

})
@Entity
@Table(name="EMP_MAIN")
public class Emp{

	@Id
	@GeneratedValue
	@Column(name="e_id")
	private int id;
	
	@Column(name="name")
	private String name;

	@Column(name="sal")
	private float sal;

	@Column(name="city")
	private String city;
	
	
	public Emp()
	{
	}
	
	public Emp( String name, float sal, String city) {
		this.name = name;
		this.sal = sal;
		this.city=city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", sal=" + sal + ", city=" + city + "]";
	}


	
}
