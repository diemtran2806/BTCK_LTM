package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.BEAN.Student;
import model.BEAN.StudentView;

public class StudentDAO {
	private static final String CREATE_STUDENT = "INSERT INTO student(id_student,id_class)\r\n" 
		+ "values(?, ?);";
//	private static final String GET_ALL_STUDENT = "SELECT * FROM student LEFT JOIN person ON student.id_student = person.id_person;";
	private static final String GET_STUDENT_BY_ID = "SELECT * FROM student LEFT JOIN person ON "
			+ "student.id_student = person.id_person where id_student=?;";
	private static final String GET_STUDENTVIEW_BY_ID = "SELECT person.id_person,name,role,phone,email,CCCD,gender"
			+ ",address,dob,class_name FROM student LEFT JOIN person ON student.id_student = person.id_person "
			+ "LEFT JOIN class on student.id_class=class.id_class where id_student=?;";
	private static final String UPDATE_STUDENT = "UPDATE student "
			+ "SET id_class=? "
			+ "WHERE id_student=?;";
	private static final String GET_ALL_STUDENT = "SELECT person.id_person,name,role,phone,email,CCCD,gender"
			+ ",address,dob,class_name FROM student LEFT JOIN person ON "
			+ "student.id_student = person.id_person LEFT JOIN class on student.id_class=class.id_class where "
			+ "student.id_student=? or name like N? or phone like ? or email like ? or "
			+ "CCCD like ? or address like N? or dob like N? or class_name like N?;";
	private static final String GET_ALL_STUDENT_CLASS = "SELECT person.id_person,name,role,phone,email,CCCD,gender"
			+ ",address,dob,class_name FROM student LEFT JOIN person ON "
			+ "student.id_student = person.id_person LEFT JOIN class on student.id_class=class.id_class where "
			+ "student.id_student=? or name like N? or phone like ? or email like ? or "
			+ "CCCD like ? or address like N? or dob like N? or class_name like N? WHERE student.id_class=?;";
	private static final String GET_ALL_CLASS = "SELECT id_class,class_name from class;";

	public static boolean createStudent(Student student) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			int id_person = PersonDAO.createPerson(student);
			if (id_person != 0) {
				PreparedStatement ps = con.prepareStatement(CREATE_STUDENT);
				ps.setInt(1, id_person);
				ps.setInt(2, student.getId_class());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static ArrayList<StudentView> getStudentList(String value){
		ArrayList<StudentView> result = new ArrayList<StudentView>();
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			ResultSet rs = null;
			PreparedStatement ps = con.prepareStatement(GET_ALL_STUDENT);
			ps.setString(1, value);
			ps.setString(2, "%" + value + "%");
			ps.setString(3, "%" + value + "%");
			ps.setString(4, "%" + value + "%");
			ps.setString(5, "%" + value + "%");
			ps.setString(6, "%" + value + "%");
			ps.setString(7, "%" + value + "%");
			ps.setString(8, "%" + value + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				result.add(new StudentView(rs.getInt("id_person"), rs.getString("name")
					,rs.getString("role"),rs.getString("phone"),rs.getString("email"),rs.getString("CCCD")
					,rs.getBoolean("gender"),rs.getString("address"),rs.getDate("dob"),rs.getString("class_name")));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public static ArrayList<StudentView> getStudentListByClass(String value, int id_class){
		ArrayList<StudentView> result = new ArrayList<StudentView>();
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			ResultSet rs = null;
			PreparedStatement ps = con.prepareStatement(GET_ALL_STUDENT_CLASS);
			ps.setString(1, value);
			ps.setString(2, "%" + value + "%");
			ps.setString(3, "%" + value + "%");
			ps.setString(4, "%" + value + "%");
			ps.setString(5, "%" + value + "%");
			ps.setString(6, "%" + value + "%");
			ps.setString(7, "%" + value + "%");
			ps.setString(8, "%" + value + "%");
			ps.setInt(9, id_class);
			rs = ps.executeQuery();
			while(rs.next()) {
				result.add(new StudentView(rs.getInt("id_person"), rs.getString("name")
					,rs.getString("role"),rs.getString("phone"),rs.getString("email"),rs.getString("CCCD")
					,rs.getBoolean("gender"),rs.getString("address"),rs.getDate("dob"),rs.getString("class_name")));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public static Student getStudentById(int id){
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			ResultSet rs = null;
			PreparedStatement ps = con.prepareStatement(GET_STUDENT_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Student(rs.getInt("id_student"), rs.getString("name"),rs.getString("password")
					,rs.getString("role"),rs.getString("phone"),rs.getString("email"),rs.getString("CCCD")
					,rs.getBoolean("gender"),rs.getString("address"),rs.getDate("dob"),rs.getInt("id_class"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static StudentView getStudentViewById(int id){
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			ResultSet rs = null;
			PreparedStatement ps = con.prepareStatement(GET_STUDENTVIEW_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new StudentView(rs.getInt("id_person"), rs.getString("name")
					,rs.getString("role"),rs.getString("phone"),rs.getString("email"),rs.getString("CCCD")
					,rs.getBoolean("gender"),rs.getString("address"),rs.getDate("dob"),rs.getString("class_name"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static boolean updateStudent(Student student) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			if (PersonDAO.updatePerson(student)) {
				PreparedStatement ps = con.prepareStatement(UPDATE_STUDENT);
				ps.setInt(1, student.getId_class());
				ps.setInt(2, student.getId_person());
				ps.executeUpdate();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Map<Integer, String> getAllClass() {
		Map<Integer, String> result = new HashMap<Integer, String>();
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			ResultSet rs = null;
			PreparedStatement ps = con.prepareStatement(GET_ALL_CLASS);
			rs = ps.executeQuery();
			while(rs.next()) {
				result.put(rs.getInt("id_class"), rs.getString("class_name"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
