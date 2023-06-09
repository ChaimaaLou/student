package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteDAO {

	private Connection conn;
	
	public deleteDAO() {
    	ConnectionDB conn1 = new ConnectionDB();
    	this.conn = conn1.getConn();
		
	}
	public int dlStudentById(int id) {
		
		int rowsAffected = 0;
        try {
            // Prepare the SQL query
            String query = "DELETE FROM studentadd WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set the values for the query parameters
            pstmt.setInt(1, id);
            // Execute the query and get the number of affected rows
            rowsAffected = pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
	}

}
