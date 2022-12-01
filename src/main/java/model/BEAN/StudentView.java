package model.BEAN;

import java.sql.Date;

public class StudentView {
	private int id_person;
	private String name;
    private String role;
	private String phone;
    private String email;
    private String CCCD;
    private boolean gender;
    private String address;
    private Date dob;
    private String class_name;
    private String img;
    public int getId_person() {
		return id_person;
	}
	public void setId_person(int id_person) {
		this.id_person = id_person;
	}
	public StudentView(int id_person, String name, String role, String phone, String email, String cCCD, boolean gender,
			String address, Date dob, String img, String class_name) {
		this.id_person = id_person;
		this.name = name;
		this.role = role;
		this.phone = phone;
		this.email = email;
		CCCD = cCCD;
		this.gender = gender;
		this.address = address;
		this.dob = dob;
		this.class_name = class_name;
		this.img = img;
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
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}
