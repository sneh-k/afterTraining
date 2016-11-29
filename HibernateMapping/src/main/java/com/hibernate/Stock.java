package com.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Stock")
public class Stock {

	@Id
	@GeneratedValue
	@Column(name="eid")
	private int eid;
	
	@Column(name="enq")
	private String enq;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private Market market;

	public Stock()
	{
		
	}
	
	
	public Stock( String enq) {
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

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}


	@Override
	public String toString() {
		return "Stock [eid=" + eid + ", enq=" + enq + "]";
	}

	
}
