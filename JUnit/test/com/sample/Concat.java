package com.sample;

import static org.junit.Assert.assertEquals;

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
import org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class Concat{
	
	
	@Before
	public void beforetest()
	{
		System.out.println("\t...Before Concat test");
	}
		
	@After
	public void aftertest()
	{
		System.out.println("\t...After Concat test");
	} 
	
	@BeforeClass
	public static void before()
	{
		System.out.println("...Before Concat CLass...");
	}
		
	@AfterClass
	public static void after()
	{
		System.out.println("...After Concat CLass...");
	}


	
	@Parameter(value = 0)
	public String s1;
	
	@Parameter(value = 1)
	public String s2;
	
	@Parameter(value = 2)
	public String s3;
	
	@Parameters
	 public static Collection<Object[]> data() 
	{
	      return Arrays.asList(new Object[][] {
	         { "ABC","DEF" ,"ABCDEF"},
	         { "GHI","JKL","GHIJKL" },
	         { "MNO","PQR","MNOPQR" },
	         { "STU","VWX","STUVWX" }
	      });
	   }
	
	@Test
	public void test()
	{	
		System.out.println("Concat test");
		Assert.assertEquals(s3,StringOperations.concatinat(s1,s2));
	}
	
//	@Test
//	public void test1()
//	{	
//		System.out.println("Concat test1");
//		Assert.assertEquals("HelloWorld",StringOperations.concatinat("Hello","World"));
//	}
	
}
