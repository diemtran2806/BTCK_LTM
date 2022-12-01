package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/Class/*")
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getPathInfo();
		try {
			switch (action) {
			case "/add":
				showAddForm(request, response);
				break;
			case "/viewlist":
				viewClassList(request, response);
				break;
			 case "/update": 
				 showUpdateForm(request, response);
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
				viewClassList(request, response);
				break;
			case "/add":
				createClass(request, response);
			case "/update":
				updateClass(request, response);
			default:

				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
		
	/*
	  else if (request.getParameter("details")!=null) { //
	 * check(request, response); // id update int idfac =
	 * Integer.parseInt(request.getParameter("details")); // truyen thong tin id den
	 * trang update form ArrayList<ClassView> clv =
	 * ClassBO.getClassViewById_faculty(idfac);
	 * request.setAttribute("ClassViewById_faculty", clv);
	 * request.getRequestDispatcher("StudentList.jsp").forward(request, response); }
	 * else if (request.getParameter("list_search")!=null) { ArrayList<ClassView>
	 * classView = new ArrayList<ClassView>(); if
	 * (request.getParameter("keysearch")==null) { classView =
	 * ClassBO.getAllClassView();
	 * 
	 * } else { String key = request.getParameter("keysearch"); classView =
	 * ClassBO.getClassViewByKeySearch(key); request.setAttribute("keysearch", key);
	 * } request.setAttribute("classView", classView);
	 * request.getRequestDispatcher("ClassList.jsp").forward(request, response); }
	 */
	/*
	 * else if(request.getParameter("list_search")==null){ ArrayList<ClassView>
	 * classView = null; // ClassArray = ClassBO.getAllClass(); if
	 * (request.getParameter("keysearch")==null) { classView =
	 * ClassBO.getAllClassView();
	 * 
	 * } // chuyen ve cho form request.setAttribute("classView", classView);
	 * request.getRequestDispatcher("/ClassList.jsp").forward(request, response);
	 * //doGet(request, response); } 
	 * }
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { doPost(request, response); }
	 */
	
	private void showAddForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Faculty> faculty = new ArrayList<Faculty>();
		faculty = FacultyBO.getAllFaculty();
		request.setAttribute("FacultyInfor", faculty);
		request.getRequestDispatcher("../ClassAdd.jsp").forward(request, response);
	}
	private void createClass (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check tai khoan
		//check(request, response);
		//them vao co so du lieu

		System.out.println("hello hihi");
		Class cl = new Class();
		cl.setId_class( Integer.parseInt(request.getParameter("id_class")));
		cl.setClass_name(request.getParameter("class_name"));
		cl.setId_faculty(Integer.parseInt(request.getParameter("facultyOption")));
		Boolean rs = ClassBO.ClassAdd(cl);
		if (rs==true) {
			System.out.println("Add successfuly!");
		} else {
			System.out.println("Something went wrong!");
		}
		response.sendRedirect("./viewlist");
	}
	private void viewClassList (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ClassView> classView = null;
		if(request.getParameter("keysearch")==null){
				classView = ClassBO.getAllClassView();
				request.setAttribute("classView", classView);
				request.getRequestDispatcher("../ClassList.jsp").forward(request, response);
		}
			else { 
				String key = request.getParameter("keysearch"); 
				classView = ClassBO.getClassViewByKeySearch(key); 
				request.setAttribute("keysearch", key);
			    request.setAttribute("classView", classView);
			    request.getRequestDispatcher("../ClassList.jsp").forward(request, response); 
			}
		
	}
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String idup = request.getParameter("update"); 
		   Class cl = ClassBO.getClassByID(Integer.parseInt(idup)); 
		   ArrayList<Faculty> faculty = new ArrayList<Faculty>(); 
		  faculty = FacultyBO.getAllFaculty();
		  request.setAttribute("ClassUpdate", cl); 
		  request.setAttribute("FacultyInfor",faculty); 
		  request.getRequestDispatcher("../ClassUpdate.jsp").forward(request,response);
	}
	private void updateClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Class cl = new Class();
			cl.setId_class(Integer.parseInt(request.getParameter("oldId_class")));
			cl.setClass_name(request.getParameter("class_name"));
		  cl.setId_faculty(Integer.parseInt(request.getParameter("facultyOption")));
		  Boolean rs = ClassBO.ClassUpdate(cl); 
		  if (rs==true) {
		  System.out.println("Update Successfull!"); 
		  } else {
		  System.out.println("Something went wrong!");
		  }
		  response.sendRedirect("./viewlist");
	}
}
