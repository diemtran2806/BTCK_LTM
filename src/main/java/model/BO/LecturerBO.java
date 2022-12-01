package model.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.BEAN.Lecturer;
import model.BEAN.LecturerListView;
import model.DAO.ConnectDatabase;
import model.DAO.LecturerDAO;

public class LecturerBO {

	public static boolean createLecturer(Lecturer Lecturer){
		return LecturerDAO.createLecturer(Lecturer); 
	}
	
	public static ArrayList<LecturerListView> getLecturerList(String username){
		return LecturerDAO.getLecturerList(username);
	}
	
	public static Lecturer getLecturerById(int id_lecturer){
		return LecturerDAO.getLecturerById(id_lecturer);
	}
	
	public static boolean updateLecturer(Lecturer Lecturer){
		return LecturerDAO.updateLecturer(Lecturer);
	}
	
	public static boolean deleteLecturer(int id_lecturer){
		return LecturerDAO.deleteLecturer(id_lecturer);
	}
}
