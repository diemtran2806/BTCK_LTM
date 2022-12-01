package model.BO;

import java.util.ArrayList;
import java.util.List;
import model.BEAN.Faculty;
import model.DAO.FacultyDAO;

public class FacultyBO {
	public static ArrayList<Faculty> getAllFaculty() {
		return FacultyDAO.getAllFaculty();
	}
	public static Boolean FacultyAdd(Faculty fac) {
		return FacultyDAO.FacultyAdd(fac);
	}
	public static Faculty getFacultyByID(int idup) {
		return FacultyDAO.getFacultyByID(idup);
	}
	public static Boolean FacultyUpdate(Faculty fac) {
		return FacultyDAO.FacultyUpdate(fac);
	}
	public static ArrayList<Faculty> getFacultyByKeySearch(String key) {
		return FacultyDAO.getFacultyByKeySearch(key);
	}
}
