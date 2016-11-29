package com.annotation;
import java.lang.annotation.*;
class A
{
	public void fA()
	{
		System.out.println("Class A..Fuction f");
	}
}
class B extends A
{	@Override
	public void fA()
	{
		System.out.println("Class B..Fuction f");
	}
	
	@Deprecated
	public void print()
	{
		System.out.println("Printinf function");
	}
}
public class AnnBuiltin {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		B a=new B();
		a.fA();
		a.print();
	}

}
