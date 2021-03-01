package bankDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class bankMain {
	
	ArrayList <bank> bankArr = new ArrayList<>();	

	
	public Connection getConnection() throws Exception{
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/bank";
			String usernamne = "root";
			String password = "Bank12345";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,usernamne,password);
			
			String sql = "SELECT * FROM bank_table";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			
			
			while(result.next()) {
				String name = result.getString("Customer");
				double total = result.getDouble("Total loan");
				double interest = result.getDouble("Interest");
				double Years = result.getDouble("Years");
				
				System.out.println(name);
				System.out.println(total);
				
				bank b = new bank(name,total,interest,Years);
				
							
				bankArr.add(b);
			}
			
			
			
			return conn;
					
		} catch(Exception e) {
			System.out.println(e);
		}
			
		return null;
	}
	
	public ArrayList<bank> getArr(){
		return bankArr;
	}
	

}
