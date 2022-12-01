package model.BEAN;

import java.sql.Date;

public class Student extends Person {
	private int id_class;

	public int getId_class() {
		return id_class;
	}

	public void setId_class(int id_class) {
		this.id_class = id_class;
	}

	public Student(int id_person, String name, String password, String role, String phone, String email, String CCCD,
			boolean gender, String address, Date dob, String img, int id_class) {
		super(id_person, name, password, role, phone, email, CCCD, gender, address, dob, img);
		this.id_class = id_class;
	}
	
}
