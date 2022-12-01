package model.BEAN;

import java.sql.Date;

public class Admin extends Person {
	private int admin_salary;
	public Admin(int id_admin, String name, String password, String role, String phone, String email, String CCCD,
			boolean gender, String address, Date dob, String img, int admin_salary) {
		super(id_admin, name, password, role, phone, email, CCCD, gender, address, dob, img);
		this.admin_salary = admin_salary;
	}
	public int getAdmin_salary() {
		return admin_salary;
	}
	public void setAdmin_salary(int admin_salary) {
		this.admin_salary = admin_salary;
	}
}
