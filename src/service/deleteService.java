package service;

import DAO.deleteDAO;
import DAO.editDAO;
import Entity.Student;

public class deleteService {

	private deleteDAO dlDAO;

	public deleteService(deleteDAO dlDAO) {
		this.dlDAO = dlDAO;
	}
	
	public boolean DeleteS(int id) throws Exception {
    	
		boolean isDelete = false;
		
		int Res = dlDAO.dlStudentById(id);
    	if (Res == 1) {
    		isDelete = true;
        }
    	return isDelete;
    }
}
