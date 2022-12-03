package model.BO;

import java.util.ArrayList;
import java.util.Map;

import model.BEAN.Student;
import model.BEAN.StudentView;
import model.DAO.StudentDAO;

public class StudentBO {
	public static ArrayList<StudentView> getStudentList(String value){
		return StudentDAO.getStudentList(value);
	}
	
	public static Student getStudentById(int id) {
		return StudentDAO.getStudentById(id);
	}
	
	public static StudentView getStudentViewById(int id) {
		return StudentDAO.getStudentViewById(id);
	}
	
	public static String createStudent(Student student) {
		String error = PersonBO.checkDuplicate(student.getPhone(), student.getEmail(), 0);
		if(!error.equals("")) return error;
		if(!StudentDAO.createStudent(student)) return "Something went wrong!";
		return "";
	}
	
	public static String updateStudent(Student student) {
		String error = PersonBO.checkDuplicate(student.getPhone(), student.getEmail(), student.getId_person());
		if(!error.equals("")) return error;
		if(!StudentDAO.updateStudent(student)) return "Something went wrong!";
		return "";
	}
	
	public static Map<Integer, String> getAllClass() {
		return StudentDAO.getAllClass();
	}
	public static ArrayList<StudentView> getStudentListByClass(String value, int id_class){
		return StudentDAO.getStudentListByClass(value, id_class);
	}
}
