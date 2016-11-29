package com.inheritance.singleclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t= session.beginTransaction();
		
		saveData(session);

		t.commit();
		session.close();
		sessionFactory.close();

	}
	
	public static void saveData(Session session)
	{
		Vehicle v=new Vehicle(101,"ABC");
		Car c=new Car(102,"DEF",150000);
		Bike b=new Bike(103,"GHI",25000);
		session.persist(v);
		session.persist(c);
		session.persist(b);
		System.out.println("Vehicle,Car & Bike STORED..");
	}

}
