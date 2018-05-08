package cs157B_hibernate;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import practice.Sales;

public class Queries {

	public static void queries() {
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
		
		
		
		
		System.out.println("-----------Sales Transaction over given time period--------------------");
		SQLQuery query2 = session.createSQLQuery("select * from sales where date > '2017-12-25'");
		List<Object[]> date = query2.list();	
		for(Object[] entries : date)
		{
			Sales temp = new Sales((Date)entries[0], entries[1].toString(), (int)entries[2], (double)entries[3], (double)entries[4]);
			System.out.println(temp.toString());
		}
		
		
		System.out.println("-----------how much sales of a given product item in the last month--------------------");
		String q = "select count(*) from sales where productname = 'apple' and date >= '2018-03-03' and date <= '2018-04-03' ";
		SQLQuery query3 = session.createSQLQuery(q);
		List<Object[]> rows2 = query3.list();	
		for(Object[] entries : rows2)
		{
			Sales temp = new Sales((Date)entries[0], entries[1].toString(), (int)entries[2], (double)entries[3], (double)entries[4]);
			System.out.println(temp.toString());
		}

		
		
		
		t.commit();
		session.close();
		sessionFactory.close();
		
		
	}
}

