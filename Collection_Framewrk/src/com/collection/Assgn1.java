package com.collection;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person>
{
	private double weight;
	private double height;
	private String name;
	
	public Person()
	{
		
	}
	public Person(double weight, double height, String name)
	{
		this.weight=weight;
		this.height=height;
		this.name=name;
	}
	
	public String toString()
	{
		return this.weight+" - "+this.height+" - "+this.name;
	}
	
	public double getWeight()
	{
		return this.weight;
	}
	
	public double getHeight()
	{
		return this.height;
	}

	@Override
	public int compareTo(Person p1) {
		if(p1.getWeight() < this.getWeight())
			return 1;
		else if(p1.getWeight() > this.getWeight())
			return -1;
		else 
		{
			if(p1.getHeight() < this.getHeight())
				return 1;
			else if(p1.getHeight() > this.getHeight())
				return -1;
			else return 0;
		}
		
	}
	
}

class PersonWeight implements Comparator<Person>
{

	@Override
	public int compare(Person p1, Person p2) {
		if(p1.getWeight() > p2.getWeight())
			return 1;
		else if(p1.getWeight() < p2.getWeight())
			return -1;
		else return 0;
	}
	
}

class PersonHeight implements Comparator<Person>
{

	@Override
	public int compare(Person p1, Person p2) {
		if(p1.getHeight() > p2.getHeight())
			return 1;
		else if(p1.getHeight() < p2.getHeight())
			return -1;
		else return 0;
	}
	
}

public class Assgn1 {

	public static void main(String[] args) {

	//	Person p[]=new Person[4];
		Person p0=new Person(54,170,"abc");
		Person p1=new Person(54,180,"abc");
		Person p2=new Person(60,169,"abc");
		Person p3=new Person(65,170,"abc");
				
		Set<Person> hset = new TreeSet<Person>();
		hset.add(p0);
		hset.add(p1);
		hset.add(p2);
		hset.add(p3);
		
		Iterator<Person> itr = hset.iterator();		
		while(itr.hasNext()) {
			Person key = itr.next();
			System.out.println(key);
		}
		System.out.println("\n");

		hset = new TreeSet<Person>(new PersonWeight());
		hset.add(p0);
		hset.add(p1);
		hset.add(p2);
		hset.add(p3);
		
		itr = hset.iterator();		
		while(itr.hasNext()) {
			Person key = itr.next();
			System.out.println(key);
		}
		System.out.println("\n");
		
		
		hset = new TreeSet<Person>(new PersonHeight());
		hset.add(p0);
		hset.add(p1);
		hset.add(p2);
		hset.add(p3);
		
		itr = hset.iterator();		
		while(itr.hasNext()) {
			Person key = itr.next();
			System.out.println(key);
		}
		System.out.println("\n");
		
	}

}
