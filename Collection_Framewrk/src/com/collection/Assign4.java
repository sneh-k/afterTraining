package com.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map;

class Date
{
	private int d;
	private int m;
	private int y;
	
	Date(int d, int m , int y)
	{
		this.d=d;
		this.m=m;
		this.y=y;
	}
	
	public String toString()
	{
		return this.d+"/"+this.m+"/"+this.y;
	}

	public int getDay()
	{
		return this.d;
	}
	
	public int getMonth()
	{
		return this.m;
	}
	
	public int getYear()
	{
		return this.y;
	}
	
	@Override
	public boolean equals(Object d)
	{
		if((((Date)d).d==this.d)&&(((Date)d).m==this.m))
		{
			return true;
		}
		else
			return false;
	}
	
	@Override
	public int hashCode()
	{
			int r=d*m;
			return r;
	}

}

public class Assign4 {

	public static void main(String[] args) {
		
		Date d1=new Date(10,5,1997);
		Map<Date,String> hmap=new HashMap<Date,String>();
		hmap.put(d1, "A");
		hmap.put(new Date(16,8,1999), "B");
		hmap.put(new Date(28,6,1994), "C");
		hmap.put(new Date(10,5,1995), "D");
		hmap.put(new Date(9,7,1992), "E");
		
		Iterator<Date> itr=hmap.keySet().iterator();
		while(itr.hasNext()) {
			Date key = itr.next();
			System.out.println(key+ " - " + hmap.get(key));
		}
		System.out.println();
		System.out.println((d1)+ " - " + hmap.get(d1));
		
		
		System.out.println("\n");

		

	}

}
