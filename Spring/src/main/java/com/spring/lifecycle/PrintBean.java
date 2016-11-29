package com.spring.lifecycle;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class PrintBean implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName)  {
	      System.out.println("BeforeInitialization : " + beanName);
	      return bean;  // you can return any other object as well
	   }

	   public Object postProcessAfterInitialization(Object bean, String beanName) {
	      System.out.println("AfterInitialization : " + beanName);
	      return bean;  // you can return any other object as well
	   }
}
