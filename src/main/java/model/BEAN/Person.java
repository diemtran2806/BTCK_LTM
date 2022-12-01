package model.BEAN;

import java.sql.Date;

public class Person {
	private int id_person;
	private String name;
    private String password;
    private String role;
    private String phone;
    private String email;
    private String CCCD;
    private boolean gender;
    private String address;
    private Date dob;
    private String img;
    
	
    public Person(int id_person, String name, String password, String role, String phone, String email, String CCCD, boolean gender, String address, Date dob, String img) {
        this.id_person = id_person;
        this.name = name;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.CCCD = CCCD;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        this.img =  img;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public void setCCCD(String CCCD) {
		this.CCCD = CCCD;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
