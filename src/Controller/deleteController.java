package Controller;

import Entity.Student;
import service.deleteService;

public class deleteController {

	private deleteService dlservice;

	public deleteController(deleteService dlservice) {
		super();
		this.dlservice = dlservice;
	}
	
	
	public boolean deleteS(int id) throws Exception {
        return dlservice.DeleteS(id);
	}
}
