package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private Connection conn;
	
	public ConnectionDB() {
		try {
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm", "root", "");
	        }
		catch (SQLException e) {
	            e.printStackTrace();
	        }    
	 }

	public Connection getConn() {
		return conn;
	}

}
