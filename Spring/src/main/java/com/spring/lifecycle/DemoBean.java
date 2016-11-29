package com.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DemoBean implements InitializingBean, DisposableBean,ApplicationContextAware,
BeanNameAware
{

	public void setBeanName(String name) {
		System.out.println("beanName : " + name);
	}

	public void setApplicationContext(ApplicationContext a) throws BeansException {
		System.out.println("Appln Context running : "+a);
	}

	public void destroy() throws Exception {
		System.out.println("Bean Destroyed");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Initialising Bean");
	}
	
	public void customInit() 
    {
        System.out.println("Method customInit() invoked...");
    }
 
    public void customDestroy() 
    {
        System.out.println("Method customDestroy() invoked...");
    }

}
