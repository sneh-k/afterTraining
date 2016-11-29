package com.spring.logg;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAOP {
	
	public static void main(String[] args)
	{
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("simple.xml");
		UserHandler obj=context.getBean(UserHandler.class);
		
		obj.login("ABC", "ABC");
		obj.logout();
		obj.register("ABC", "ABC");
		
		context.registerShutdownHook();		
	}

}
