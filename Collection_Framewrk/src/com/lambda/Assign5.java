package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Assign5 {

	public static void main(String[] args) {

		List<String> list=new ArrayList<String>();
		list.add("abc");
		list.add("bcd");
		list.add("cde");
		list.add("def");
		list.add("efg");
		StringBuilder str=new StringBuilder();
		
		Consumer<List<String>> consumer =(List<String> s)->{
			for(String i:list)
				str.append(i.charAt(0));
			System.out.println(str);
		};
			
		
		consumer.accept(list);

	}
	
}
