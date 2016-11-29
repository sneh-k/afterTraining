package com.annotation;
import  java.lang.reflect.*;
import java.lang.*;
import java.lang.Class.*;

class A1
{
	int age;
	String name;
	int id;
	A1()
	{
		System.out.println("in a1");
	}
	@Getter
	public int getAge()
	{
		return this.age;
	}
	@Getter
	public String getNames()
	{
		return this.name;
	}
}

public class AnnCustom {

	public static void main(String[] args) throws Exception {
		
		Class a1=Class.forName("com.annotation.A1");
		Field f[]=a1.getDeclaredFields();
		Method mi[]=a1.getDeclaredMethods();
		
		try {

			for(Method m: mi )
			{
				boolean ch=false;
				
				Getter g=m.getAnnotation(Getter.class);
				if(g==null)
				{
					String s=m.getName();
					String str=s.substring(3,s.length());
					for(Field f1 : f)
					{	if((f1.getName()).equalsIgnoreCase(str))
						{
							ch=true;
						}
						
					}
					if(ch)
						System.out.println("Getter Annoted method : "+m.getName());
					else
						System.out.println("Getter Error Annoted method : "+m.getName());
							
				}
			}
		
		
		}
		catch(Exception e)
		{
			System.out.println("Unable to process");
			System.out.println(e.getMessage());
		}
	}

}
