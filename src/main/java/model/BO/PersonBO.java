package model.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.BEAN.Person;
import model.DAO.ConnectDatabase;
import model.DAO.PersonDAO;

public class PersonBO {
	public static boolean isValidUser(int id, String password){
		return PersonDAO.checkLogin(id, password);
	}
	
	public static String checkDuplicate(String phone, String email, int id) {
		if(PersonDAO.checkPhoneNumberDuplicate(phone, id)) return "Số điện thoại này đã được sử dụng!";
		if(PersonDAO.checkEmailDuplicate(email, id)) return "Email này đã được sử dụng!";
		return "";
	}
	
	public static String getPassPerson(int id) {
		return PersonDAO.getPassPerson(id);
	}
	
	public static String getNamePerson(int id) {
		return PersonDAO.getNamePerson(id);
	}
	
	public static String getRolePerson(int id) {
		return PersonDAO.getRolePerson(id);
	}
	
	public static Person getPersonById(int id) {
		return PersonDAO.getPersonById(id);
	}
	
	public static String updatePerson(Person person) {
		String error = checkDuplicate(person.getPhone(), person.getEmail(), person.getId_person());
		if(!error.equals("")) return error;
		if(!PersonDAO.updatePerson(person)) return "Something went wrong!";
		return "";
	}
	
	public static boolean deletePerson(int id) {
		return PersonDAO.deletePerson(id);
	}
	
	public static boolean updatePassword(int id, String password) {
		return PersonDAO.updatePassword(id,password);
	}
}
