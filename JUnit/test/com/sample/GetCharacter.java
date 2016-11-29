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
public class GetCharacter {
	
	
	@Before
	public void beforetest()
	{
		System.out.println("\t...Before getChar test");
	}
		
	@After
	public void aftertest()
	{
		System.out.println("\t...After getChar test");
	} 
	
	@BeforeClass
	public static void before()
	{
		System.out.println("...Before getChar CLass...");
	}
		
	@AfterClass
	public static void after()
	{
		System.out.println("...After getChar CLass...");
	}

	
	
	@Parameter(value = 0)
	public char s1;
	
	@Parameter(value = 1)
	public int i;
	
	@Parameters
	 public static Collection<Object[]> data() 
	{
	      return Arrays.asList(new Object[][] {
	         { 'H', 0},
	         { 'E', 1},
	         { 'L', 2},
	         { 'O', 4},
      
	      });
	   }	
	
	@Test
	public void test() 
	{
		System.out.println("\tGetChar test");
		String str1=new String("HELLO");
		Assert.assertEquals(s1, StringOperations.getChar(str1,i));
	}
	
//	@Test
//	public void test1()
//	{	
//		System.out.println("GetChar test1");
//		String str1=new String("HELLO");
//		Assert.assertEquals('L', StringOperations.getChar(str1,3));
//	}

}
