package service;


import java.sql.ResultSet;

import DAO.addDAO;
import Entity.Student;

public class addService {

	
	private addDAO addDAO;

	public addService(DAO.addDAO addDAO) {
		this.addDAO = addDAO;
	}

	public boolean addStudent(Student addEntity) throws Exception {
    	
		boolean isAdded = false;
		
		int Res = addDAO.addStudentToDB(addEntity);
    	if (Res == 1) {
            isAdded = true;
        }
    	return isAdded;
    }

}
