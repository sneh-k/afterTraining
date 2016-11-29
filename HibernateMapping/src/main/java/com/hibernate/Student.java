package com.hibernate;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn; 
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="STUDENT")
public class Student {
	
	
	@Id
	@GeneratedValue
	@Column(name="sid")
	private int sid;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE})  
    @JoinTable(name="student_course", joinColumns=@JoinColumn(name="sid"), inverseJoinColumns=@JoinColumn(name="id"))
	private Set<Course> s;

	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public int getId() {
		return sid;
	}

	public void setId(int id) {
		this.sid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getS() {
		return s;
	}

	public void setS(Set<Course> s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "Student [id=" + sid + ", name=" + name + ", s=" + s + "]";
	}

}
