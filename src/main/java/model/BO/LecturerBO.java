package model.BO;

import java.util.ArrayList;

import model.BEAN.Lecturer;
import model.BEAN.LecturerListView;
import model.DAO.LecturerDAO;

public class LecturerBO {

	public static String createLecturer(Lecturer Lecturer){
		String error = PersonBO.checkDuplicate(Lecturer.getPhone(), Lecturer.getEmail(), 0);
		if(!error.equals("")) return error;
		if(!LecturerDAO.createLecturer(Lecturer)) return "Something went wrong!";
		return ""; 
	}
	
	public static ArrayList<LecturerListView> getLecturerList(String username){
		return LecturerDAO.getLecturerList(username);
	}
	
	public static Lecturer getLecturerById(int id_lecturer){
		return LecturerDAO.getLecturerById(id_lecturer);
	}
	
	public static String updateLecturer(Lecturer Lecturer){
		String error = PersonBO.checkDuplicate(Lecturer.getPhone(), Lecturer.getEmail(), Lecturer.getId_person());
		if(!error.equals("")) return error;
		if(!LecturerDAO.updateLecturer(Lecturer)) return "Something went wrong!";
		return ""; 
	}
	public static LecturerListView getLecturerViewById(int id) {
		return LecturerDAO.getLecturerViewById(id);
	}
}
