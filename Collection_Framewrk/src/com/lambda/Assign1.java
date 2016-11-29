package com.lambda;

public class Assign1 {

	public static void main(String[] args) {
		
		Functional f=(int a,int b)->{return a+b;};
		int x=f.operation(5,10);
		System.out.println("Addition : "+x);

		f=( a, b)->{return b-a;};
		 x=f.operation(5,10);
		System.out.println("Subtraction : "+x);
		
		f=( a, b)->{return a*b;};
		 x=f.operation(5,10);
		System.out.println("Multiplication : "+x);
		
		f=( a, b)->{return b/a;};
		 x=f.operation(5,10);
		System.out.println("Division : "+x);
		
	}

}
