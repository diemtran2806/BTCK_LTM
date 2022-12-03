package model.BO;

import java.util.ArrayList;

import model.BEAN.Admin;
import model.BEAN.AdminView;
import model.DAO.AdminDAO;

public class AdminBO {
	public static ArrayList<AdminView> getAdminList(String value){
		return AdminDAO.getAdminList(value);
	}
	
	public static Admin getAdminById(int id) {
		return AdminDAO.getAdminById(id);
	}
	
	public static AdminView getAdminViewById(int id) {
		return AdminDAO.getAdminViewById(id);
	}
	
	public static String createAdmin(Admin admin) {
		String error = PersonBO.checkDuplicate(admin.getPhone(), admin.getEmail(), 0);
		if(!error.equals("")) return error;
		if(!AdminDAO.createAdmin(admin)) return "Something went wrong!";
		return "";
	}
	
	public static String updateAdmin(Admin admin) {
		String error = PersonBO.checkDuplicate(admin.getPhone(), admin.getEmail(), admin.getId_person());
		if(!error.equals("")) return error;
		if(!AdminDAO.updateAdmin(admin)) return "Something went wrong!";
		return "";
	}
}
