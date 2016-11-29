package com.nestedclass;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.sql.Date.*;

class WrapperC
{
	String name;
	Timestamp time;
	
	public WrapperC(String name,Timestamp time)
	{
		this.name=name;
		this.time=time;
	}
	public String toString()
	{
		return " Data : "+this.name+" TimeStamp : "+this.time;
	}
}

public class App2 {
		
	private class cache
	{
		HashMap<Integer, WrapperC> hmap = new HashMap<Integer, WrapperC>();

		void add(int i,WrapperC w)
		{
			hmap.put(i,w);
			
		}
		void get(int i)
		{
			WrapperC var= hmap.get(i);
		    System.out.println("Value at index "+i+" is: "+var);
		}
		void print()
		{
			Set set = hmap.entrySet();

		      Iterator iterator = set.iterator();

		      while(iterator.hasNext()) {
		    	 Map.Entry mentry = (Map.Entry)iterator.next();

		         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
		         System.out.println(mentry.getValue());

		      }
		}
		
	}

	public void addCache(cache c ,int i, WrapperC w)
	{
		c.add(i,w);
	}
	public void getCache(cache c ,int i)
	{
		c.get(i);
	}
	public void printCache(cache c)
	{
		c.print();
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		
		try
		{
		App2 a1=new App2();
		cache c1=a1.new cache();
		java.util.Date d = new java.util.Date();
		
		WrapperC wc[]=new WrapperC[6];
		wc[0]= new WrapperC("ABC", new Timestamp(d.getTime()));
		wc[1]= new WrapperC("BCD", new Timestamp(d.getTime()));
		wc[2]= new WrapperC("CDE", new Timestamp(d.getTime()));
		wc[3]= new WrapperC("DEF", new Timestamp(d.getTime()));
		wc[4]= new WrapperC("EFG", new Timestamp(d.getTime()));
		wc[5]= new WrapperC("FGH", new Timestamp(d.getTime()));
		
		for(int i=0;i<6;i++)
		{
			a1.addCache(c1,i+1,wc[i]);
//			Thread.sleep(1000);
		}

		a1.printCache(c1);
		
		a1.getCache(c1, 5);
		}
		catch(Exception e)
		{
			System.out.println("Exception caught");
		}
	}

}
