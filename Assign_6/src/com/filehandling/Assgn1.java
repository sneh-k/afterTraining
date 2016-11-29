package com.filehandling;
import java.io.*;

public class Assgn1 {

	public static void main(String[] args) throws IOException {

		File file = new File("abc.txt");
		FileOutputStream fos = new FileOutputStream(file);
		String strData = "Hi Frnds..";
		fos.write(strData.getBytes());
		fos.flush();
		fos.close();
		
		FileInputStream fis = new FileInputStream(file);
		StringBuilder sb = new StringBuilder("");
		int i = 0;
		do {
		i = fis.read();
		if(i != -1)
		sb.append((char)i);
		}
		while(i != -1); // -1 represents end of file (EOF)
		System.out.println("File abc.txt contents: " + sb);
		fis.close();
		
		File file2=new File("pqr.txt");
		FileOutputStream fos2 = new FileOutputStream(file2);
		StringBuilder strData2 = sb;
		fos2.write(strData.getBytes());
		fos2.flush();
		fos2.close();
		
		FileInputStream fis2 = new FileInputStream(file2);
		StringBuilder sb2 = new StringBuilder("");
		int i2 = 0;
		do {
		i2 = fis2.read();
		if(i2 != -1)
		sb2.append((char)i2);
		}
		while(i2 != -1); // -1 represents end of file (EOF)
		System.out.println("File pqr.txt contents : " + sb2);
		fis2.close();
		
	}

}
