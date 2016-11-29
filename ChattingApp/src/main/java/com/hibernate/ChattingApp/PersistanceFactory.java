package com.hibernate.ChattingApp;

public class PersistanceFactory {

	private static PersistanceFactory pf=null;
	private PersistanceFactory()
	{
	}
	public static PersistanceFactory getInstance()
	{
		if(pf==null)
		{
			pf=new PersistanceFactory();
			return pf;
		}
		else return pf;
	}
	public Persistance getPersistance()
	{
		return new HibernatePersistance();
	}
}
