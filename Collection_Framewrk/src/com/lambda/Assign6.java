package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class Assign6 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("bcd");
		list.add("cde");
		list.add("def");
		list.add("efg");
		list.add("fgh");
		
		for(String s : list)
			System.out.println(s);
		
		UnaryOperator<String> operator = (String s) -> String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1);
		
		System.out.println();
		
		list.replaceAll(operator);
		for(String s : list)
			System.out.println(s);
	}

}
