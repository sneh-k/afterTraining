package com.nestedclass;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.sql.Date.*;
public class App1 {
		
	private class cache
	{
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		HashMap<Integer, Timestamp> hdmap = new HashMap<Integer, Timestamp>();
		void add(int i, String name,Timestamp t)
		{
			hmap.put(i,name);
			hdmap.put(i, t);
			
		}
		void get(int i)
		{
			String var= hmap.get(i);
		    System.out.println("Value at index "+i+" is: "+var);
		}
		void print()
		{
			Set set = hmap.entrySet();
			Set set1 = hdmap.entrySet();
		      Iterator iterator = set.iterator();
		      Iterator iterator1 =set1.iterator();
		      while(iterator.hasNext()) {
		    	 Map.Entry mentry = (Map.Entry)iterator.next();
		    	 Map.Entry mentry1 = (Map.Entry)iterator1.next();
		         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
		         System.out.println(mentry.getValue());
		         System.out.println(" TimeStamp is : "+mentry1.getValue());
		      }
		}
		
	}

	public void addCache(cache c ,int i, String name,Timestamp time)
	{
		c.add(i,name,time);
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
		App1 a1=new App1();
		cache c1=a1.new cache();
		java.util.Date d = new java.util.Date();
		
		a1.addCache(c1,1,"ABC", new Timestamp(d.getTime()));
		a1.addCache(c1,2,"BCD", new Timestamp(d.getTime()));
		a1.addCache(c1,3,"CDE", new Timestamp(d.getTime()));
		a1.addCache(c1,4,"DEF", new Timestamp(d.getTime()));
		a1.addCache(c1,5,"EFG", new Timestamp(d.getTime()));
		a1.addCache(c1,6,"FGH", new Timestamp(d.getTime()));
		
		a1.printCache(c1);
		
		a1.getCache(c1, 5);
		}
		catch(Exception e)
		{
			System.out.println("Exception caught");
		}
	}

}
