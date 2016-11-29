package com.spring.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAOP {
	
	public static void main(String[] args)
	{
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("simple.xml");
		AddTime obj=(AddTime)context.getBean(AddTime.class);
		System.out.println("LIST");
		obj.addInList();
		System.out.println("VECTOR");
		obj.addInVector();
		context.registerShutdownHook();		
	}

}
