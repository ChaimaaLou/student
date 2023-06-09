package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.User;

public class AuthDAO {
	
	
    private Connection conn;

    public AuthDAO() {
    	ConnectionDB conn1 = new ConnectionDB();
    	this.conn = conn1.getConn();
		
	}


	public ResultSet getUserByobj(User authEntity)  {
	        try {
	            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setString(1, authEntity.getUsername());
	            preparedStatement.setString(2, authEntity.getPassword());
	            ResultSet resultset = preparedStatement.executeQuery();
	            return resultset;
	           
	            
	        } 
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
			return null;
	        
	        
    }
    
}
