package com.spring.chatapp;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String[] args)
	{
		AbstractApplicationContext context= new ClassPathXmlApplicationContext("Beans_simple2.xml");
		Map<String,Chatroom> orders=context.getBeansOfType(Chatroom.class);
		
		for(Map.Entry<String, Chatroom> entry : orders.entrySet())
		    System.out.println(entry.getKey() + "-" + entry.getValue());
		context.registerShutdownHook();
	}
}
