package cs157B_hibernate;

import java.io.File;
import java.io.FileNotFoundException;
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

public class Queries {

	public static void queries() {
		System.out.println("------------------Select-----------------------");
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		SQLQuery query = session.createSQLQuery("select * from sales");
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
}

