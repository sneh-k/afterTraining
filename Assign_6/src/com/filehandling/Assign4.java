package com.filehandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class Assign4 {


	public static void main(String[] args) throws IOException {
		
		
		FileInputStream f1= new FileInputStream("C:/Users/kamat_sn/workspace/Assign_6/abc2.txt");
		FileInputStream f2= new FileInputStream("C:/Users/kamat_sn/workspace/Assign_6/bcd2.txt");
		FileInputStream f3= new FileInputStream("C:/Users/kamat_sn/workspace/Assign_6/cde2.txt");
		
		Vector v=new Vector();  
		v.add(f1);  
		v.add(f2);  
		v.add(f3);  
		Enumeration e=v.elements();
		SequenceInputStream sis=new SequenceInputStream(e);
		
		int i=0;  
		  
		while((i=sis.read())!=-1){  
		System.out.print((char)i);  
		}  
		  
		sis.close();  
		f1.close();  
		f2.close();
		f3.close();

	}

}
