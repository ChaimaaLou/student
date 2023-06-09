package Controller;

import Entity.Student;
import service.addService;
import service.editService;

public class updateController {

	
	private editService editservice;

	public updateController(editService editservice) {
		super();
		this.editservice = editservice;
	}
	
	public boolean updateS(int id,String cne, String name, String lname, float note, int tel) throws Exception {
		Student addentity = new Student(cne, name, lname, note, tel);
        return editservice.updateS(id, addentity);
	}
    
}
