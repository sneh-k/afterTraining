package com.lambda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

public class Assign4 {

	public static void main(String[] args) {
		
		List<String> list=new CopyOnWriteArrayList<String>();
		list.add("ABC");
		list.add("ABCD");
		list.add("ABCE");
		list.add("CDSVF");
		list.add("ABCG");
		
		for(String od : list)
			System.out.println(od+"");	
		
		System.out.println();
		
		Predicate<String> p1=(String s)->{return (s.length()%2)==1;};
		list=filter(list,p1);
		
		for(String od : list)
			System.out.println(od+"");		
	}

	private static List<String> filter(List<String> list, Predicate<String> p1) {
		
		for(String od : list)
			if(p1.test(od))
			{
				list.removeIf(p1);
			}
		return list;
	}

}
