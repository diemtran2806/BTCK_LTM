package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BEAN.Class;
import model.BEAN.ClassView;
import model.BEAN.Faculty;
import model.BO.ClassBO;
import model.BO.FacultyBO;

@WebServlet("/Faculty/*")
public class FacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FacultyServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getPathInfo();
		try {
			switch (action) {
//			case "/home":
//				response.sendRedirect("../Home.jsp");
//				break;
			case "/add":
				showAddForm(request, response);
				break;
			case "/viewlist":
				viewFacultyList(request, response);
				break;
			 case "/update": 
				 showUpdateForm(request, response);
				 break; 	
			 case "/details": 
				 showDetailsFaculty(request, response);
				 break;
			default:

				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getPathInfo();
		try {
			switch (action) {
			case "/viewlist":
				viewFacultyList(request, response);
				break;
			case "/add":
				createFaculty(request, response);
				break;
			case "/update":
				updateFaculty(request, response);
				break;
			default:

				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	request.setCharacterEncoding("UTF-8");
//		if (request.getParameter("add")!=null) {
//			//chuyen ve form them
//			response.sendRedirect("FacultyAdd.jsp");
//		} else if (request.getParameter("insert")!=null) {
//			//check tai khoan
//			//check(request, response);
//			//them vao co so du lieu
//			Faculty fac = new Faculty();
//			fac.setId_faculty(0);
//			fac.setFaculty_name(request.getParameter("faculty_name"));
//			Boolean rs = FacultyBO.FacultyAdd(fac);
//			if (rs==true) {
//				System.out.println("Add successfuly!");
//			} else {
//				System.out.println("Something went wrong!");
//			}
//			response.sendRedirect("FacultyServlet");
//		}
//		else if (request.getParameter("updateFaculty")!=null) {
//			//check(request, response);
//			Faculty fac = new Faculty();
//			fac.setId_faculty(Integer.parseInt(request.getParameter("oldId_faculty")));
//			fac.setFaculty_name(request.getParameter("faculty_name"));
//			Boolean rs = FacultyBO.FacultyUpdate(fac);
//			if (rs==true) {
//				System.out.println("Update Successfull!");
//			}
//			else {
//				System.out.println("Something went wrong!");
//			}
//			response.sendRedirect("FacultyServlet");
//		}
//		else if (request.getParameter("update")!=null) {
////			check(request, response);
//			// id update
//			String idup = request.getParameter("update"); 
//			// truyen thong tin id den trang update form
//			Faculty fac = FacultyBO.getFacultyByID(Integer.parseInt(idup));
//			request.setAttribute("FacultyUpdate", fac);
//			request.getRequestDispatcher("FacultyUpdate.jsp").forward(request, response);
//		}
//		else if (request.getParameter("list_search")!=null) {
//			ArrayList<Faculty> faculty = new ArrayList<Faculty>();
//			if (request.getParameter("keysearch")==null) {
//				faculty = FacultyBO.getAllFaculty();
//				
//			}
//			else {
//				String key = request.getParameter("keysearch");
//				faculty = FacultyBO.getFacultyByKeySearch(key);
//				request.setAttribute("keysearch", key);
//			}
//			request.setAttribute("faculty", faculty);
//			request.getRequestDispatcher("FacultyList.jsp").forward(request, response);
//		}
//		else if(request.getParameter("list_search")==null){
//			ArrayList<Faculty> faculty = null;
//			if (request.getParameter("keysearch")==null) {
//				faculty = FacultyBO.getAllFaculty();
//				
//			}
//			// chuyen ve cho form
//			request.setAttribute("faculty", faculty);
//			request.getRequestDispatcher("/FacultyList.jsp").forward(request, response);
//		//doGet(request, response);
//		}
//	}
    
    private void viewFacultyList (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Faculty> faculty = null;
		if(request.getParameter("keysearch")==null){
				faculty = FacultyBO.getAllFaculty();
				request.setAttribute("faculty", faculty);
				System.out.println("HelloVL");
				request.getRequestDispatcher("../FacultyList.jsp").forward(request, response);
				
		}
			else { 
				String key = request.getParameter("keysearch"); 
				faculty = FacultyBO.getFacultyByKeySearch(key); 
				request.setAttribute("keysearch", key);
			    request.setAttribute("faculty", faculty);
			    request.getRequestDispatcher("../FacultyList.jsp").forward(request, response); 
			}
		
	}
    private void showAddForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("../FacultyAdd.jsp").forward(request, response); 
	}
    private void createFaculty (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check tai khoan
		//check(request, response);
		//them vao co so du lieu
    	
    	Faculty fac = new Faculty();
		fac.setId_faculty(0);
		fac.setFaculty_name(request.getParameter("faculty_name"));
		Boolean rs = FacultyBO.FacultyAdd(fac);
		if (rs==true) {
			System.out.println("Add successfuly!");
		} else {
			System.out.println("Something went wrong!");
		}
		response.sendRedirect("./viewlist");
	}
    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String idup = request.getParameter("update"); 
		// truyen thong tin id den trang update form
		Faculty fac = FacultyBO.getFacultyByID(Integer.parseInt(idup));
		request.setAttribute("FacultyUpdate", fac);
		request.getRequestDispatcher("../FacultyUpdate.jsp").forward(request,response);
	}
    private void updateFaculty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Faculty fac = new Faculty();
		fac.setId_faculty(Integer.parseInt(request.getParameter("oldId_faculty")));
		fac.setFaculty_name(request.getParameter("faculty_name"));
		Boolean rs = FacultyBO.FacultyUpdate(fac);
		if (rs==true) {
			System.out.println("Update Successfull!");
		}
		else {
			System.out.println("Something went wrong!");
		}
	  response.sendRedirect("./viewlist");
}
    private void showDetailsFaculty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idfac = Integer.parseInt(request.getParameter("details"));
		System.out.println(idfac);
		ArrayList<ClassView> clv = ClassBO.getClassViewById_faculty(idfac);
		request.setAttribute("classView", clv);
		System.out.println(clv.get(1).getClass_name());
//		response.sendRedirect("../ClassList.jsp");
		request.getRequestDispatcher("../ClassList.jsp").forward(request, response); 
	}

}
