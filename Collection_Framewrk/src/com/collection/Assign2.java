package com.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Assign2 {

	public static void main(String[] args) {
		
		Person p[]=new Person[6];
		p[0]=new Person(54,170,"A");
		p[1]=new Person(62,165,"B");
		p[2]=new Person(65,173,"C");
		p[3]=new Person(76,179,"D");
		p[4]=new Person(49,150,"E");
		p[5]=new Person(69,158,"F");
		
		Set<Person> hset= new HashSet<Person>();
		hset.add(p[0]);
		hset.add(p[1]);
		hset.add(p[2]);
		hset.add(p[3]);
		hset.add(p[4]);
		hset.add(p[5]);
		
		Iterator<Person> itr = hset.iterator();		
		while(itr.hasNext()) {
			Person key = itr.next();
			System.out.println(key);
		}
		System.out.println("\n");

		hset= new LinkedHashSet<Person>();
		hset.add(p[0]);
		hset.add(p[1]);
		hset.add(p[2]);
		hset.add(p[3]);
		hset.add(p[4]);
		hset.add(p[5]);
		
		itr = hset.iterator();		
		while(itr.hasNext()) {
			Person key = itr.next();
			System.out.println(key);
		}
		System.out.println("\n");

	}

}
