package com.spring.logg;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class UserAspect {


	
	@Pointcut("execution(* UserHandler.login(..))")
	public void pc1(){}
	
	@Pointcut("execution(* UserHandler.logout(..))")
	public void pc2(){}
	
	@Pointcut("execution(* UserHandler.register(..))")
	public void pc3(){}
	
	@Before("pc1()")
	public void beforeLogin(JoinPoint jp) throws Exception
	{
		Object[] args = jp.getArgs();
		if(((String)args[0]).length()<3)
		{
			throw new Exception();
		}
	}
	
	@Before("pc2()")
	public void beforeLogout(JoinPoint jp)
	{
		System.out.println(" At time : "+System.currentTimeMillis());
	}
	
	@Before("pc3()")
	public void beforeRegister(JoinPoint jp) throws Exception
	{
		Object[] args = jp.getArgs();
		if(((String)args[0]).length()<3)
		{
			throw new Exception();
		}
	}
	
}
