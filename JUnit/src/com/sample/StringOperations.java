package com.sample;

public class StringOperations {
	String str=new String("");
//	
//	StringOperations(String s)
//	{
//		this.str=s;
//	}
	
	public static  String concatinat(String s1,String s2)
	{
		return s1.concat(s2);
	}
	
	public static char getChar(String str,int index)
	{
		return str.charAt(index);
	}
	
	public static int getLength(String str)
	{
		return str.length();
	}
	
	public static void main(String[] args) {

	}

}
