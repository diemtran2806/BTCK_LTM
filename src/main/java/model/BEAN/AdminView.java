package model.BEAN;

import java.sql.Date;

public class AdminView {
	private int id_person;
	private String name;
    private String role;
    private String phone;
    private String email;
    private String CCCD;
    private boolean gender;
    private String address;
    private Date dob;
	private int admin_salary;
    public AdminView(int id_person, String name, String role, String phone, String email, String cCCD,
			boolean gender, String address, Date dob, int admin_salary) {
		this.id_person = id_person;
		this.name = name;
		this.role = role;
		this.phone = phone;
		this.email = email;
		CCCD = cCCD;
		this.gender = gender;
		this.address = address;
		this.dob = dob;
		this.admin_salary = admin_salary;
	}
	public int getId_person() {
		return id_person;
	}
	public void setId_person(int id_person) {
		this.id_person = id_person;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}
	public boolean getGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getAdmin_salary() {
		return admin_salary;
	}
	public void setAdmin_salary(int admin_salary) {
		this.admin_salary = admin_salary;
	}
}
