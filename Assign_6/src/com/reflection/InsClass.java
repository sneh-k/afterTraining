package com.reflection;
import  java.lang.reflect.*;

public class InsClass {

	public static void main(String[] args)  throws Exception {
		
		try {
		String cls=args[0];
		
//		m.invokeMethod(cls,mthd,pTypes,pValues);
		}
		catch(Exception e)
		{
			System.out.println("Unable to invoke");
			System.out.println(e.getMessage());
		}	
	}

}
