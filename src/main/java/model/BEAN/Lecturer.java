package model.BEAN;

import java.math.BigDecimal;
import java.sql.Date;

public class Lecturer extends Person {
	private int id_faculty;
    private int lecturer_salary;
    
    public Lecturer(int id_lecture, String name, String password, String role, String phone, String email, String CCCD, boolean gender, String address, Date dob, int id_faculty, int lecturer_salary) {
		super(id_lecture, name, password, role, phone, email, CCCD, gender, address, dob);
		this.id_faculty = id_faculty;
		this.lecturer_salary = lecturer_salary;
	}
	public int getId_faculty() {
		return id_faculty;
	}
	public void setId_faculty(int id_faculty) {
		this.id_faculty = id_faculty;
	}
	public int getLecturer_salary() {
		return lecturer_salary;
	}
	public void setLecturer_salary(int lecturer_salary) {
		this.lecturer_salary = lecturer_salary;
	}
	
}

