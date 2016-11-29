package com.lambda;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Order
{
	private int price;
	private String status;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	Order(int price, String status)
	{
		this.price=price;
		this.status=status;
	}

	@Override
	public String toString() {
		return "Order [price=" + price + ", status=" + status + "]";
	}
	
}
public class Assign2 {

	public static void main(String[] args) {
		
		List<Order> list=new ArrayList<Order>();
		list.add(new Order(15000, "ACCEPTED"));
		list.add(new Order(5000, "ACCEPTED"));
		list.add(new Order(20000, "REJECTED"));
		list.add(new Order(9000, "REJECTED"));
		
		Predicate<Order> p1=(Order o)->{return o.getPrice()>10000;};
		List<Order> l1=filter(list,p1);
		
		for(Order od : l1)
			System.out.println(od+"");
		
		System.out.println();
		
		Predicate<Order> p2=(Order o)->{return o.getStatus()=="ACCEPTED";};
		List<Order> l2=filter(list,p2);
		
		for(Order od : l2)
			System.out.println(od+"");
		
	}

	private static List<Order> filter(List<Order> list, Predicate<Order> p1) {
		List<Order> list2=new ArrayList<Order>();
		for(Order od : list)
			if(p1.test(od))
			{
				list2.add(od);
			}
		return list2;
	}

}
