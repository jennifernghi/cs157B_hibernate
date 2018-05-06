package cs157B_hibernate;

import java.sql.*;

public class demo {

	public static void main(String[] args) {
		//make connection 
		Connection conn = MakeConnection.getconnection();
		
		//create table sales
		createTable.create(conn);
		
		
		/*
		 * Create a Java object (“sales transaction” record/object 
		 * -including <Date, ProductName, Quantity, UnitCost, TotalCost>) 
		 * with a method to save() the sales transaction record object in 
		 * the RDBMS “Sales” Table through Hibernate. 
		 * For simplicity assume date is your primary key.
		 * DONE!!!!!!!!!!!!!!
		 */
		
		Insert.insertData();
		
		
		/*
		 * Store in the “Sales” table multiple instances of the 
		 * “sales transaction” objects where each “sales transaction” 
		 * object representing a different “sale transaction.”
		 */
		
		
		/*
		 * Create another Java object with a method to query the “Sales” 
		 * RDBMS table including:
		 * i. Retrieve a single “sales transaction” as a Java object and 
		 * print the transaction attributes from the Java object.
		 * ii. Retrieve sales transactions for a given product over given 
		 * time interval.
		 * iii. Perform aggregate operation on the sales transaction objects, e.g., how much sales of a given product item in the last month?
		 */
		
		
		Queries.queries();
		
	}

}
