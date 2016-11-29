package com.filehandling;

import java.io.Serializable;

class Date implements Serializable
{

	private static final long serialVersionUID = 1L;
	private int dd;
	private int mm;
	private int yy;
	
	public Date(int dd, int mm, int yy)
	{
		this.dd=dd;
		this.mm=mm;
		this.yy=yy;
	}
	
	public String toString()
	{
		return this.dd+"/"+this.mm+"/"+this.yy;
	}
}
public class Acc implements Serializable
{

	private int acno;
	private String name;
	transient private Date dob;
	
	public Acc(int acno,String name, Date d)
	{
		this.acno=acno;
		this.name=name;
		this.dob=d;
	}
	
	public String toString()
	{
		return "Acno : "+this.acno+"\nName : "+this.name+"\nDoj : "+dob;
	}
	
	public static void main(String[] args) {
		
		
	}

}
