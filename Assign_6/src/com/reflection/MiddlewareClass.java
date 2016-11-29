package com.reflection;
import  java.lang.reflect.*;

class TestServer
{
	public void sampMethod(String s)
	{
		System.out.println("Deatils passed : "+s);
	}
}

class MiddleWare
{
	public static Object invokeMethod(String clsName, String methodName, Class[] parameterTypes, Object[] parameterValues) throws Exception
	{
		Class c=Class.forName(clsName);
		Method m=c.getMethod(methodName, parameterTypes);
		
		return m.invoke(c.newInstance(), parameterValues);
	}
}

public class MiddlewareClass {

	public static void main(String[] args) throws Exception {
		
		try {
		String cls="com.reflection.TestServer";
		String mthd="sampMethod";
		Class[] pTypes=new Class[1];
		pTypes[0]=String.class;
		Object[] pValues=new Object[1];
		pValues[0]="Hello";
		MiddleWare m=new MiddleWare();
		m.invokeMethod(cls,mthd,pTypes,pValues);
		}
		catch(Exception e)
		{
			System.out.println("Unable to invoke");
			System.out.println(e.getMessage());
		}
	}

}
