package Entity;

public class Student {

	private String cne;
	private String name;
	private String lname;
	private float note;
	private int tel;
	
	public Student(String cne, String name, String lname, float note,int tel) {
		super();
		this.cne = cne;
		this.name = name;
		this.lname = lname;
		this.note = note;
		this.tel = tel;
	}

	public String getCne() {
		return cne;
	}
	
	public String getName() {
		return name;
	}

	public String getLname() {
		return lname;
	}

	public float getNote() {
		return note;
	}

	public int getTel() {
		return tel;
	}

	

	

}
