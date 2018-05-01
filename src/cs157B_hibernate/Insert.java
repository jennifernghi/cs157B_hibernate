package cs157B_hibernate;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Insert {

	public static void insertData() {
		try {
			Scanner scanner = new Scanner(new File("src/cs157B_hibernate/sales_data.txt"));
			while(scanner.hasNextLine()){
				String[] next = scanner.nextLine().split("\\s+");
				
				try {
					
					Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(next[0] + " " +next[1]);
					
					
					String productName = next[2];
					
					int quantity = Integer.parseInt(next[3]);
					
					double unitCost = Double.parseDouble(next[4]);
					
					double productCost = quantity * unitCost;
					
					Sales s = new Sales(date, productName, quantity, unitCost, productCost);
					s.save();
					
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
