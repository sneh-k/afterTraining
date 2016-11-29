package com.sample;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GetLength {
	
	@Before
	public void beforetest()
	{
		System.out.println("\t...Before getLen test");
	}
		
	@After
	public void aftertest()
	{
		System.out.println("\t...After getLen test");
	} 
	
	@BeforeClass
	public static void before()
	{
		System.out.println("...Before getLen CLass...");
	}
		
	@AfterClass
	public static void after()
	{
		System.out.println("...After getLen CLass...");
	}


	@Parameter(value = 0)
	public String s1;
	
	@Parameter(value = 1)
	public int i;
	
	@Parameters
	 public static Collection<Object[]> data() 
	{
	      return Arrays.asList(new Object[][] {
	         { "ABC", 3 },
	         { "ABDC", 4 },
	         { "AB" ,2 },
	         { "ABWDSC" ,6 },
	         { "ABSC", 4 },
	      });
	   }
	
	@Test
	public void test() 
	{
		System.out.println("\t\tGetLength test");
		Assert.assertEquals(i, StringOperations.getLength(s1));
	}
	
//	@Test
//	public void testGetLength() 
//	{
//		String str1=new String("ABCDEFG");
//		Assert.assertEquals(7, StringOperations.getLength(str1));
//	}
	
	
}
