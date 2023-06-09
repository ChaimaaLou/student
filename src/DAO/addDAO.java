package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entity.Student;

public class addDAO {

	
	private Connection conn;

    public addDAO() {
    	ConnectionDB conn1 = new ConnectionDB();
    	this.conn = conn1.getConn();
		
	}
    
    public int addStudentToDB(Student addentity) {
    	
        int rowsAffected = 0;
        try {
            String query = "INSERT INTO studentadd (cne, name, lname, note, tel) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, addentity.getCne());
            pstmt.setString(2, addentity.getName());
            pstmt.setString(3, addentity.getLname());
            pstmt.setFloat(4, addentity.getNote());
            pstmt.setInt(5, addentity.getTel());
            rowsAffected = pstmt.executeUpdate();
            
            pstmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }
}
