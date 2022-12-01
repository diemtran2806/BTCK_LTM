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
	
	public static boolean createAdmin(Admin admin) {
		return AdminDAO.createAdmin(admin);
	}
	
	public static boolean updateAdmin(Admin admin) {
		return AdminDAO.updateAdmin(admin);
	}
}
