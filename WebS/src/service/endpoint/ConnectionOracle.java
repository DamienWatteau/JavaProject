package service.endpoint;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionOracle {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl" ;
	private static String jdbc = "oracle.jdbc.driver.OracleDriver";
	private static String user = "system";
	private static String passwd = "123";
	
	private static Connection connect;
	
	public static Connection getIntance() {
		if(connect == null){
	        try {
	        	Class.forName("oracle.jdbc.driver.OracleDriver");  
	        	connect=DriverManager.getConnection(url, user, passwd);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }        
        return connect; 
	}   
}
