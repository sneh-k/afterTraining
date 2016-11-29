package com.generic;

import java.util.ArrayList;
import java.util.List;

public class Assign2 {
	
	public static void printList(List<? extends Number> list) {
		for (Object elem: list)
		System.out.println(elem + " ");
		}
	
	public static void main(String[] args) {
		
		List<Integer> l1=new ArrayList<Integer>();
		l1.add(45);
		l1.add(54);
		l1.add(75);
		
		printList(l1);
		
		System.out.println();
		
		List<Double> l2=new ArrayList<Double>();
		l2.add(45.26);
		l2.add(54.74);
		l2.add(75.01);
		
		printList(l2);
		
	}

}
