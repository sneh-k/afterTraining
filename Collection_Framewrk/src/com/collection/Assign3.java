package com.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class Assign3 {

	public static void main(String[] args) {

		List<Integer> arlist= new ArrayList();
		arlist.add(24);
		arlist.add(46);
		arlist.add(81);
		arlist.add(36);
		arlist.add(94);
		arlist.add(19);
		
		ListIterator<Integer> itr = arlist.listIterator();		
		while(itr.hasNext()) 
		{
			 int key = itr.next();
		}
		while(itr.hasPrevious())
		{
			System.out.println(itr.previous());
			
		}
		System.out.println("\n");

	}

}
