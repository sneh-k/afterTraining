package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Assign3 {

	public static void main(String[] args) {
		
		Consumer<Integer> consumer =(Integer x)->System.out.println(x);
		printList(Arrays.asList(13, 46, 79, 17, 28, 39, 19, 37), consumer);
				
		System.out.println();
		
		Supplier<Integer> supplier = () -> {return 75;};
		System.out.println("RESULT : "+ printGrade(supplier) );
		
		System.out.println();
		
		Function<Integer, String> function = (Integer marks)->marks > 40 ? "PASS" : "FAILED";
		System.out.println("Result = " + function.apply(45));
		System.out.println("Result = " + function.apply(23));
		
	}

	public static String printGrade(Supplier<Integer> supplier)
	{
		Integer marks = supplier.get();
		if(marks>=90)
			return "A";
		else if(marks>=75)
			return "B";
		else if(marks>=60)
			return "C";
		else if(marks>=35)
			return "D";
		else
			return "E";
		
	}
	
	public static void printList(List<Integer> asList, Consumer<Integer> consumer) {
		
		for(Integer i:asList)
			consumer.accept(i);
	}

}
