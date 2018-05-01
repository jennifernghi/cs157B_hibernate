package cs157B_hibernate;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class createTable {
	
	public static void create(Connection conn){
		Statement st = null;
		String drop = "drop table if exists `sales`; ";
		String query = " CREATE TABLE `sales` ( "+
					   " `date` datetime NOT NULL, "+
					   " `productName` varchar(200) NOT NULL DEFAULT 'N.a', "+
					   " `quantity` int(11) NOT NULL DEFAULT '1', "+
					   " `unitCost` double NOT NULL DEFAULT '1', "+
					   " `productCost` double NOT NULL DEFAULT '1', "+
					   " PRIMARY KEY (`date`) "+
					   " ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
		
		try {
			st = conn.createStatement();
			st.executeUpdate(drop);
			st.executeUpdate(query);
			
			System.out.println("sales table created.");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
