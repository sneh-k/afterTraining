package com.enumn;

import com.enumn.Order.status;

class Order
{
	enum status{
		REJECTED(1),ACCEPTED(2),COMPLETED(3);
		int i;
		private status(int n)
		{
			this.i=n;
		}
		public String toString()
		{
			String str = "Status : ";
			switch(this)
			{
			case REJECTED : str=str+"REJECTED";break;
			case ACCEPTED : str=str+"ACCEPTED";break;
			case COMPLETED : str=str+"COMPLETED";break;
			}
			return str;
		}
	}
	private int id;
	private String name;
	private int qty;
	private int price;
	private status s;
	
	public Order(int id,String name,int qty,int price,status si)
	{
		this.id=id;
		this.name=name;
		this.qty=qty;
		this.price=price;
		this.s=si;
	}
	public String toString()
	{
		return "id : "+this.id+"\nName :"+this.name+"\nQty : "+this.qty+"\nPrice : "+this.price+"\n"+this.s;
	}

}

public class Assgn {

	
	public static void main(String[] args) {
		Order o[]=new Order[3];
		o[0]=new Order(101,"ABC",10,5,status.REJECTED);
		o[1]=new Order(102,"BCD",20,15,status.ACCEPTED);
		o[2]=new Order(103,"CDE",15,10,status.COMPLETED);
		
		for(int i=0;i<3;i++)
		{
			System.out.println(o[i]);
			System.out.println();
		}

	}

}
