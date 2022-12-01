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
	
	public static boolean createStudent(Student student) {
		return StudentDAO.createStudent(student);
	}
	
	public static boolean updateStudent(Student student) {
		return StudentDAO.updateStudent(student);
	}
	
	public static Map<Integer, String> getAllClass() {
		return StudentDAO.getAllClass();
	}
}
