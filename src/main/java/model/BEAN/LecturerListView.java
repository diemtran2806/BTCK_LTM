package model.BEAN;

import java.sql.Date;

public class LecturerListView  extends Person {
	private String faculty_name;
	private int lecturer_salary;
	public LecturerListView(int id_person, String name, String password, String role, String phone, String email,
			String CCCD, boolean gender, String address, Date dob, String img, String faculty_name, int lecturer_salary) {
		super(id_person, name, password, role, phone, email, CCCD, gender, address, dob, img);
		this.setFaculty_name(faculty_name);
		this.setLecturer_salary(lecturer_salary);
	}
	public String getFaculty_name() {
		return faculty_name;
	}
	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}
	public int getLecturer_salary() {
		return lecturer_salary;
	}
	public void setLecturer_salary(int lecturer_salary) {
		this.lecturer_salary = lecturer_salary;
	}
}
