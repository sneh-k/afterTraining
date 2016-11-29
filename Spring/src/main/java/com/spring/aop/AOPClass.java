package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPClass {
	
	static long st;
	static long et;
	@Pointcut("execution(* AddTime.*(..))")
    public void time_add(){}
    
    @Before("time_add()")  
    public void getTime(JoinPoint jp)  
    {  
    	st=System.currentTimeMillis();
    	System.out.println(" Start time : " + st );
    }
    
    @After("time_add()")
    public void endTime(JoinPoint jp)  
    {  
    	et=System.currentTimeMillis();
    	System.out.println(" End time : " + et );
    }
    
    @AfterReturning("time_add()")
    public void totaltime(JoinPoint jp)
    {
    	System.out.println("Total Time : " + (et-st));
    }
}
