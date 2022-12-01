package model.BO;

import model.BEAN.Person;
import model.DAO.PersonDAO;

public class PersonBO {
	public static boolean isValidUser(int id, String password){
		return PersonDAO.checkLogin(id, password);
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
	
	public static boolean deletePerson(int id) {
		return PersonDAO.deletePerson(id);
	}
}
