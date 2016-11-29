package com.spring.lifecycle;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) 
	{
		
		AbstractApplicationContext context= new ClassPathXmlApplicationContext("Beans_simple.xml");
		DemoBean db=(DemoBean)context.getBean("demoBean");
		
		context.registerShutdownHook();
		context.close();
	}

}
