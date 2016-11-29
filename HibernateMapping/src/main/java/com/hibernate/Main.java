package com.hibernate;

import java.io.File;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args)
	{
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t= session.beginTransaction();
		
//		saveCustomer(session);
//		viewCustomer(session);
//		delCustomer(session);
		
		
		saveMarket(session);
		viewMarket(session);
//		delMarket(session);
		
		
//		saveStudent(session);
//		viewStudent(session);
//		delStudent(session);
		

		t.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	
	
	
	
	
	public static void saveStudent(Session session)
	{

		Student s1= new Student("ABC");
		Student s2= new Student("ABC2");
		Course c1=new Course("DEF");
		Course c2=new Course("DEF2");
				
		s1.setS(new HashSet<Course>());
		s1.getS().add(c1);
		s1.getS().add(c2);
		s2.setS(new HashSet<Course>());
		s2.getS().add(c1);
		
		session.persist(s1);
		session.persist(s2);
		int id=s1.getId();
		System.out.println("Student_course SAVED !");
		updateStudent(session, id);
		
	}
	public static void updateStudent(Session session,int id)
	{
		Student m=session.get(Student.class, id);
		m.setName("QWER");
		session.persist(m);
		System.out.println("Student_course updated");
		
	}
	public static void viewStudent(Session session)
	{
		List<Student> pList=session.createQuery("from Student").list();
		for (Student p:pList)
			System.out.println(p);
		
	}
	
	public static void delStudent(Session session)
	{
		Query q=session.createQuery("Delete from Student");
		q.executeUpdate();
		System.out.println("Student_course DELETED !");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void saveMarket(Session session)
	{
		Market e1=new Market("Market1");
		Stock c1=new Stock("ABC");
		Stock c2=new Stock("DEF");
		c1.setMarket(e1);
		c2.setMarket(e1);
		
		e1.setS(new HashSet<Stock>());
		e1.getS().add(c1);
		e1.getS().add(c2);
		
		session.persist(e1);
		int id=e1.getId();
		System.out.println("Market SAVED !");
		updateMarket(session, id);
		
	}
	public static void updateMarket(Session session,int id)
	{
		Market m=session.get(Market.class, id);
//		Stock c=session.get(Stock.class, id);
		m.setName("QWER");
		session.persist(m);
		System.out.println("Stock-mrkt updated");
		
	}
	public static void viewMarket(Session session)
	{
		List<Market> pList=session.createQuery("from Market").list();
		for (Market p:pList)
			System.out.println(p);
		
	}
	
	public static void delMarket(Session session)
	{
		Query q=session.createQuery("Delete from Market");
		q.executeUpdate();
		System.out.println("Stock-market DELETED !");
		
	}
	
	
	
	
	
	
	
	
	
	public static void saveCustomer(Session session)
	{
		Enquiry e1=new Enquiry("Enquiry 1");
		Customer c1=new Customer("ABC", e1);
		session.persist(c1);
		int id=c1.getId();
		System.out.println("Cust_Enq SAVED !");
		updateCustomer(session, id);
		
	}
	public static void updateCustomer(Session session,int id)
	{
		Customer c=session.get(Customer.class, id);
		c.setName("DEF");
		session.persist(c);
		System.out.println("CUst updated");
		
	}
	public static void viewCustomer(Session session)
	{
		List<Customer> pList=session.createQuery("from Customer").list();
		for (Customer p:pList)
			System.out.println(p);
		
	}
	
	public static void delCustomer(Session session)
	{
		Query q=session.createQuery("Delete from Enquiry");
//		Query q1=session.createQuery("Delete from Enquiry");
		q.executeUpdate();
		System.out.println("Cust_Enq DELETED !");
		
	}

}
