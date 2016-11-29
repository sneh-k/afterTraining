package com.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Emp
{
	private int id;
	private String name;
	
	Emp(int id, String name)
	{
		this.id=id;
		this.name=name;
	}
	
	public String toString()
	{
		return this.id+" - "+this.name;
	}
	
	@Override
	public boolean equals(Object d)
	{
		return true;
	}
	
	@Override
	public int hashCode()
	{
			return 1;
	}
	
}
public class Assign5 {

	public static void main(String[] args) {
		
		Emp e1=new Emp(101,"ABC");
		Emp e2=new Emp(102,"BCD");
		Emp e3=new Emp(103,"CDE");
		Emp e4=new Emp(104,"DEF");
		Emp e5=new Emp(105,"EFG");		
		Map<Emp,String> hmap=new HashMap<Emp,String>();
		hmap.put(e1, "A");
		hmap.put(e2, "B");
		hmap.put(e3, "C");
		hmap.put(e4, "D");
		hmap.put(e5, "E");
		
		Iterator<Emp> itr=hmap.keySet().iterator();
		while(itr.hasNext()) {
			Emp key = itr.next();
			System.out.println(key+ " - " + hmap.get(key));
		}
		System.out.println();
//		System.out.println(e1+ " - " + hmap.get(e1));
	}

}
