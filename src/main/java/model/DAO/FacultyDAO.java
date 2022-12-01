package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BEAN.Faculty;
import model.DAO.ConnectDatabase;

public class FacultyDAO {

	public static ArrayList<Faculty> getAllFaculty() {
		ArrayList<Faculty> faculty = new ArrayList<Faculty>();
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from faculty");
			
			while (rs.next()) {
				Faculty fac = new Faculty();
				fac.setId_faculty(rs.getInt("id_faculty"));
				fac.setFaculty_name(rs.getString("Faculty_name"));
				faculty.add(fac);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return faculty;
	}
	
	public static Boolean FacultyAdd(Faculty fac) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into faculty(faculty_name) values ('"+fac.getFaculty_name()+"');");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static Faculty getFacultyByID(int idup) {
		for (Faculty fac :  getAllFaculty()) {
			if(fac.getId_faculty() == idup) {
				return fac;
			}
		}
		return null;
	}
	
	public static Boolean FacultyUpdate(Faculty fac) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("update faculty set faculty_name = '"+fac.getFaculty_name()+"'" + " WHERE id_faculty="+fac.getId_faculty()+";");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static ArrayList<Faculty> getFacultyByKeySearch(String key) {
		ArrayList<Faculty> faculty = new ArrayList<Faculty>();
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select id_faculty, faculty_name "
					+ "from faculty  "
					+ "where id_faculty like N'%"+key+"%'  or faculty_name like N'%"+key+"%';");					
			while (rs.next()) {
				Faculty fac = new Faculty();
				fac.setId_faculty(rs.getInt("id_faculty"));
				fac.setFaculty_name(rs.getString("faculty_name"));
				faculty.add(fac);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return faculty;
	}
	

}
