package cs157B_hibernate;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.sql.Timestamp;

@Entity
public class Sales {
	// JPA annotation which can be used to store only Timestamp
	@Id
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;  
	private String productName;
	private int quantity;
	private double unitCost;
	private double productCost;
	/**
	 * constructor 
	 * @param date
	 * @param productName
	 * @param quantity
	 * @param unitCost
	 * @param productCost
	 */
	public Sales(Date date, String productName, int quantity, double unitCost, double productCost) {
		this.date = date;
		this.productName = productName;
		this.quantity = quantity;
		this.unitCost = unitCost;
		this.productCost = productCost;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	
	public String toString()
	{	
		return this.getDate() + " " + this.getProductName() +" " + 
			   this.getQuantity() + " " + this.getUnitCost() +" " + this.getProductCost();
	}
	/**
	 * save Sales object to database - table sales
	 */
	public void save() {
		//create a new configuartion using hibernate.cfg.xml file
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		
		// create service registry
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();
		
		//create session factory
		SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry);
		//open new session
		Session session = sessionFactory.openSession();
		//new transaction
		Transaction t = session.beginTransaction();
		//save data in to DB
		session.save(this);
		t.commit();
		session.close();
		sessionFactory.close();

	}
}
