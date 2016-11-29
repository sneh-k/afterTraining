package com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ENQUIRY")
public class Enquiry {

	@Id
	@GeneratedValue
	@Column(name="eid")
	private int eid;
	
	@Column(name="enq")
	private String enq;
	
	public Enquiry() {
	}

	public Enquiry(String enq) {
		this.enq = enq;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEnq() {
		return enq;
	}

	public void setEnq(String enq) {
		this.enq = enq;
	}

	@Override
	public String toString() {
		return "Enquiry [eid=" + eid + ", enq=" + enq + "]";
	}
	
	
	
}
