package model.BO;

import java.util.ArrayList;
import java.util.List;
import model.BEAN.Class;
import model.BEAN.ClassView;
import model.DAO.ClassDAO;

public class ClassBO {
	public static ArrayList<Class> getAllClass() {
		return ClassDAO.getAllClass();
	}
	public static Boolean ClassAdd(Class cl) {
		return ClassDAO.ClassAdd(cl);
	}
	public static Class getClassByID(int idup) {
		return ClassDAO.getClassByID(idup);
	}
	public static Boolean ClassUpdate(Class cl) {
		return ClassDAO.ClassUpdate(cl);
	}
	public static ArrayList<ClassView> getAllClassView() {
		return ClassDAO.getAllClassView();
	}

	public static ArrayList<ClassView> getClassViewByKeySearch(String key) {
		return ClassDAO.getClassViewByKeySearch(key);
	}
	public static ArrayList<ClassView> getClassViewById_faculty(int idfac) {
		return ClassDAO.getClassViewById_faculty(idfac);
	}
}
