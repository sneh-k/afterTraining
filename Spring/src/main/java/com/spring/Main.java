package com.spring;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) 
	{
		
		AbstractApplicationContext context= new ClassPathXmlApplicationContext("Beans_simple.xml");
		Map<String,Order> orders=context.getBeansOfType(Order.class);
		double sum=0;
		for (Map.Entry<String, Order> entry : orders.entrySet())
		{
			sum=sum+entry.getValue().getItem().getPrice();
		    System.out.println(entry.getKey() + "-" + entry.getValue());
		    
		}
		System.out.println("Total price : " +sum);
		context.registerShutdownHook();
	}

}
