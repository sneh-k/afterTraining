package com.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Assign8
{
	ListIterator<String> listItr = nameAryList.listIterator();
	Assign8()
	{
		
		Thread t1=new Thread(new Runnable() 
		{
			@Override
			public void run()
			{
				while(listItr.hasNext()) {
				System.out.println(listItr.next());
				try
				{
					Thread.sleep(500);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				}
			}
		}
		 
		);
		
		Thread t2=new Thread(new Runnable() 
		{
			@Override
			public void run()
			{
					addL("\tJenny");
			}
		} 
		);
		
		t1.start();
		t2.start();
		
	}
 	static List<String> nameAryList = new ArrayList<String>();
 	//	static List<String> nameAryList = new CopyOnWriteArrayList<String>();
	
	 
	
	public void addL(String s)
	{
		nameAryList.add(s);
	}
	
	
	public static void main(String[] args) 
	{
		Assign8 a=new Assign8();
		a.addL("Ivan");
		a.addL("Tom");
		a.addL("Jerry");
//		ListIterator<String> listItr = nameAryList.listIterator();
//		while(listItr.hasNext()) {
//			System.out.println(listItr.next());
//		}
		System.out.println();

	
	}

}
