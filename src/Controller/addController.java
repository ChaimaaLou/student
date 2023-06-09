package Controller;

import Entity.Student;
import service.addService;

public class addController {

	private addService addservice;
    
    public addController(addService addservice) {
        this.addservice = addservice;
    }

	public boolean addStudent(String cne, String name, String lname, float note, int tel) throws Exception {
		Student addentity = new Student(cne, name, lname, note,tel);
        return addservice.addStudent(addentity);
	}
    
    
}
