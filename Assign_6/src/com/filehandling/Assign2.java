package com.filehandling;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

public class Assign2 {

	public static void main(String[] args) throws IOException {
		
		
		File dir = new File("C:/Users/kamat_sn/samples/");
		File[] files = dir.listFiles();
		for(File f: files)
		{	
			System.out.println("NAme is: "+ f.getName());
			FileInputStream fis = new FileInputStream(f);
			StringBuilder sb = new StringBuilder("");
			int i = 0;
			do {
			i = fis.read();
			if(i != -1)
			sb.append((char)i);
			}
			while(i != -1); 
			
			System.out.println("File name : " + f.getName());
			System.out.println("File contents : " + sb);
			System.out.println("File size : " + f.length());
			System.out.println("File created : " + f.lastModified());
			System.out.print("File permissions : " );
			if (f.canRead()) {
	            System.out.print("Read ");
	        } else {
	            System.out.print("Cannot Read ");
	        }
			if (f.canWrite()) {
	            System.out.print("Write ");
	        } else {
	            System.out.print("Cannot Write ");
	        }
			if (f.canExecute()) {
	            System.out.println("Execute ");
	        } else {
	            System.out.println("Cannot Execute ");
	        }
			
			System.out.print("File type : " );
			if( f.isDirectory())
			{
				System.out.println(" Directory ");
			}
			else if(f.isFile())
			{
				System.out.println(" File ");
			}
			else
				System.out.println(" Unknown ");
			
			System.out.println("");
			
			fis.close();
		}
		
	}

}
