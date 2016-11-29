package com.spring.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AddTime {

	public void addInVector()
	{
		Vector<Integer> vector=new Vector<Integer>();
		for(int i=1;i<=1000;i++)
			vector.add(((Integer)i));
	}
	
	public void addInList()
	{
		List<Integer> list=new ArrayList<Integer>();
		for(int i=1;i<=1000;i++)
			list.add(((Integer)i));
	}
	
}
