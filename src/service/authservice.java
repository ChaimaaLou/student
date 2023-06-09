package service;


import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.AuthDAO;
import Entity.User;

public class authservice {

	
		private AuthDAO authDAO;

		public authservice(AuthDAO authDAO) {
	        this.authDAO = authDAO;
	    }

	    

	    public boolean authenticate(User authEntity) throws Exception {
	    	
	    	boolean isAuthenticated = false;
	    	
	    	ResultSet Rs = authDAO.getUserByobj(authEntity);
	    	if (Rs.next()) {
                isAuthenticated = true;
            }
	    	return isAuthenticated;
	    	
	    	
	    }
	}
