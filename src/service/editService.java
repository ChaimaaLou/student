package service;

import DAO.editDAO;
import Entity.Student;

public class editService {

	
	private editDAO EditDAO;

	public editService(editDAO editDAO) {
		EditDAO = editDAO;
	}
	
	public boolean updateS(int id , Student addEntity) throws Exception {
    	
		boolean isUPdated = false;
		
		int Res = editDAO.editStudentInDB(id, addEntity);
    	if (Res == 1) {
    		isUPdated = true;
        }
    	return isUPdated;
    }

}
