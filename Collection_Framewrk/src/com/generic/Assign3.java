package com.generic;

class OrderedPair<K extends Number, V extends Object>
{
	private K key;
	private V value;
	public OrderedPair(K key, V value) 
	{
		this.key = key;
		this.value = value;
	}
	public OrderedPair() {
		// TODO Auto-generated constructor stub
	}
	public K getKey() { return key; }
	public V getValue() { return value; }
	public void printMapKeyValues() 
	{
		System.out.println(this.key+" - "+this.value);
	}
}
public class Assign3 {
	
	public static void main(String[] args)
	{
			
		OrderedPair<Integer,String> op=new OrderedPair<Integer,String>(1,"ABC");
		OrderedPair<Integer,String> op2=new OrderedPair<Integer,String>(2,"DEF");
		OrderedPair<Double,String> op3=new OrderedPair<Double,String>(3.5,"GHI");
		OrderedPair<Integer,String> op4=new OrderedPair<Integer,String>(4,"JKL");
		OrderedPair<Double,String> op5=new OrderedPair<Double,String>(5.7,"MNO");
		
		op.printMapKeyValues();
		op2.printMapKeyValues();
		op3.printMapKeyValues();
		op4.printMapKeyValues();
		op5.printMapKeyValues();
		
	}

}
