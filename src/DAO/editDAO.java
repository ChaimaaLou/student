package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entity.Student;

public class editDAO {

	
	private static Connection conn;

    public editDAO() {
    	ConnectionDB conn1 = new ConnectionDB();
    	this.conn = conn1.getConn();
		
	}
    
    public static int editStudentInDB(int id, Student addEntity) {
        int rowsAffected = 0;
        try {
            // Prepare the SQL query
            String query = "UPDATE studentadd SET cne = ?, name = ?, lname = ?, note = ?, tel = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set the values for the query parameters
            pstmt.setString(1, addEntity.getCne());
            pstmt.setString(2, addEntity.getName());
            pstmt.setString(3, addEntity.getLname());
            pstmt.setFloat(4, addEntity.getNote());
            pstmt.setInt(5, addEntity.getTel());            
            pstmt.setInt(6, id);
            // Execute the query and get the number of affected rows
            rowsAffected = pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

}
