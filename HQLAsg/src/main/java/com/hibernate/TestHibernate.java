package com.hibernate;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;



public class TestHibernate 
{
	public static void main(String[] args) 
	{
		
		Configuration configuration=new Configuration();
		configuration.configure(new File("src/hibernate.cfg.xml"));
	
		SessionFactory sessionFactory=configuration.buildSessionFactory();
/*		
		//INSERT
		Session ses1=sessionFactory.openSession();
		Transaction t1=ses1.beginTransaction();
		Emp p1=new Emp("JKL",12000,"PUNE");
		ses1.save(p1);
		Emp p2=new Emp("DEF",25000,"BGLR");
		ses1.save(p2);		
		long id=p2.getId();
		Emp p3=new Emp("GHI",15000,"MUMBAI");
		ses1.save(p3);
		Emp p4=new Emp("ABC",18000,"PUNE");
		ses1.save(p4);	
		t1.commit();
		ses1.close();
*/		
		//SUM OF ALL SALARY
		Session s1=sessionFactory.openSession();
		Query q=s1.getNamedQuery("getSum");	//createQuery("Select sum(sal) from Emp");
		List l=q.list();
		System.out.println("SUM of all Sal : " +l);
		s1.close();
		
		
		//ORDER BY SAL
		Session s2=sessionFactory.openSession();
		Query q2=s2.getNamedQuery("getOrderSal");	//createQuery("from Emp ORDER BY sal");
		List<Emp> pList=q2.list();
		for(Emp e:pList)
			System.out.println(e);
		s2.close();
		
//		Session s3=sessionFactory.openSession();
//		Criteria cr=s3.createCriteria(Emp.class);
//		cr.addOrder(Order.asc("sal"));
//		List<Emp> cl= cr.list();
//		for(Emp e:cl)
//			System.out.println(e);
//		s3.close();
		
		
		//GROUP BY CITY
		Session s4=sessionFactory.openSession();
		Query sq=s4.getNamedQuery("getGroupCity");	//createQuery("Select count(*) from Emp GROUP BY city");
		List p2List=sq.list();
		for(Object o:p2List)
			System.out.println(o);
		s4.close();
		
		//AVERAGE SAL
		Session s5=sessionFactory.openSession();
		Query q5=s5.getNamedQuery("getAvgSal");	//createQuery("Select avg(sal) from Emp");
		List l5=q5.list();
		System.out.println("Avg of all Sal : " +l5);
		s5.close();
		
		//SAL>10000
		Session s6=sessionFactory.openSession();
		Criteria cr6=s6.createCriteria(Emp.class);
		cr6.add(Restrictions.gt("sal", ((float)17000)));
		List<Emp> cl= cr6.list();
		for(Emp e:cl)
			System.out.println(e);
		s6.close();
		
		
		sessionFactory.close();
	}
}
