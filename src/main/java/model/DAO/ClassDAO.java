package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BEAN.Class;
import model.BEAN.ClassView;
import model.DAO.ConnectDatabase;

public class ClassDAO {

	public static ArrayList<Class> getAllClass() {
		ArrayList<Class> list = new ArrayList<Class>();
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from class");
			
			while (rs.next()) {
				Class cl = new Class();
				cl.setId_class(rs.getInt("id_class"));
				cl.setClass_name(rs.getString("class_name"));
				cl.setId_faculty(rs.getInt("id_faculty"));
				list.add(cl);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Boolean ClassAdd(Class cl) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into class values ("+cl.getId_class()+",'"+cl.getClass_name()+"',"
			+cl.getId_faculty()+")");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static Class getClassByID(int idup) {
		for (Class cl :  getAllClass()) {
			if(cl.getId_class() == idup) {
				return cl;
			}
		}
		return null;
	}
	
	public static Boolean ClassUpdate(Class cl) {
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("update class set class_name = '"+cl.getClass_name()+"', id_faculty = "+cl.getId_faculty()+ " WHERE id_class="+cl.getId_class()+";");
//			stmt.executeUpdate("update class values ("+cl.getId_class()+",'"+cl.getClass_name()+"',"
//			+cl.getId_faculty()+")");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static ArrayList<ClassView> getAllClassView() {
		ArrayList<ClassView> classView = new ArrayList<ClassView>();
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select id_class, class_name, class.id_faculty, faculty_name "
					+ "from class  "
					+ "inner join faculty  "
					+ "on class.id_faculty = faculty.id_faculty;");
			while (rs.next()) {
				ClassView clv = new ClassView();
				clv.setId_class(rs.getInt("id_class"));
				clv.setClass_name(rs.getString("class_name"));
				clv.setId_faculty(rs.getInt("id_faculty"));
				clv.setFaculty_name(rs.getString("faculty_name"));
				classView.add(clv);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classView;
	}
	
	public static ArrayList<ClassView> getClassViewByKeySearch(String key) {
		ArrayList<ClassView> classView = new ArrayList<ClassView>();
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select id_class, class_name, class.id_faculty, faculty_name "
					+ "from class  "
					+ "inner join faculty  "
					+ "on class.id_faculty = faculty.id_faculty  "
					+ "where id_class like N'%"+key+"%'  or class_name like N'%"+key+"%'  "
					+ "or class.id_faculty like N'%"+key+"%'  or faculty_name like N'%"+key+"%';");
					
			while (rs.next()) {
				ClassView clv = new ClassView();
				clv.setId_class(rs.getInt("id_class"));
				clv.setClass_name(rs.getString("class_name"));
				clv.setId_faculty(rs.getInt("id_faculty"));
				clv.setFaculty_name(rs.getString("faculty_name"));
				classView.add(clv);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classView;
	}
	
	public static ArrayList<ClassView> getClassViewById_faculty(int idfac) {
		ArrayList<ClassView> classView = new ArrayList<ClassView>();
		try {
			Connection con = ConnectDatabase.getMySQLConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select id_class, class_name, class.id_faculty, faculty_name "
					+ "from class  "
					+ "inner join faculty  "
					+ "on class.id_faculty = faculty.id_faculty  where class.id_faculty = " + idfac);
			//ResultSet rs = stmt.executeQuery("select * from class where id_faculty = " + idfac);
			
			while (rs.next()) {
				ClassView clv = new ClassView();
				clv.setId_class(rs.getInt("id_class"));
				clv.setClass_name(rs.getString("class_name"));
				clv.setId_faculty(rs.getInt("id_faculty"));
				clv.setFaculty_name(rs.getString("faculty_name"));
				classView.add(clv);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classView;
	}

}
