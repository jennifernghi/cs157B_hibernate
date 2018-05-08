package cs157B_hibernate;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Queries {

	public static void select1() {
		System.out.println("------------------Select Single-----------------------");
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		SQLQuery query = session.createSQLQuery("select * from sales where productName = 'toys' and quantity = 2");
		List<Object[]> rows = query.list();	
		for(Object[] row : rows)
		{
			Sales temp = new Sales((Date)row[0], row[1].toString(), (int)row[2], (double)row[3], (double)row[4]);
			System.out.println(temp.toString());
		}
		
	
		t.commit();
		session.close();
		sessionFactory.close();	
	}
	public static void select2() {
		
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		
		
		System.out.println("-----------Sales Transaction over given time period--------------------");
		SQLQuery query2 = session.createSQLQuery("select * from sales where date > '2017-12-25'");
		List<Object[]> date = query2.list();	
		for(Object[] entries : date)
		{
			Sales temp = new Sales((Date)entries[0], entries[1].toString(), (int)entries[2], (double)entries[3], (double)entries[4]);
			System.out.println(temp.toString());
		}
		
		t.commit();
		session.close();
		sessionFactory.close();
			
	}
	
	public static void select3() {
		
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		
		System.out.println("-----------how much sales of a given product item in the last month--------------------");
		String q = "select count(s) from Sales s where productname = 'apple' and date >= '2018-01-01 00:00:00' and date <= '2018-05-05 10:20:03' ";
		int count = ((Long)session.createQuery(q).uniqueResult()).intValue();
		
		System.out.println("count(*): "+count);

		t.commit();
		session.close();
		sessionFactory.close();
		
		
	}
}

