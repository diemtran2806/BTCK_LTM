package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BEAN.Faculty;
import model.BEAN.Lecturer;
import model.BEAN.LecturerListView;
import model.BO.FacultyBO;
import model.BO.LecturerBO;
import model.DAO.LecturerDAO;

/**
 * Servlet implementation class LecturerServlet
 */
@WebServlet("/Lecturer/*")
public class LecturerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println(action);
		try {
			switch (action) {
			case "/new":
				createLecturerView(request, response);
				break;
			case "/viewlist":
				viewLecturerList(request, response);
				break;
			case "/update":
				updateLecturerView(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getPathInfo();
			System.out.println(action);
				try {
					switch (action) {
					case "/new":
						createLecturer(request, response);
						break;
					case "/viewlist":
						viewLecturerList(request, response);
						break;
					case "/update":
						updateLecturer(request, response);
						break;
					case "/delete":
						deleteLecturer(request, response);
						break;
					default:
		
						break;
					}
				} catch (SQLException ex) {
					throw new ServletException(ex);
				}
	}
	
	private void createLecturerView(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			ArrayList<Faculty> facultyList = null;
			facultyList = FacultyBO.getAllFaculty();
			request.setAttribute("facultyList", facultyList);
			RequestDispatcher rd = request.getRequestDispatcher("../CreateLecturer.jsp");
			rd.forward(request, response);
	}
	
	private void createLecturer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
				request.setCharacterEncoding("UTF-8");
			    String name = request.getParameter("name");
			    String password = request.getParameter("password");
			    String role = "GV";
			    String phone = request.getParameter("phone");
			    String email = request.getParameter("email");
			    String CCCD = request.getParameter("CCCD");
			    System.out.println(request.getParameter("gender"));
			    boolean gender = ("1".equals(request.getParameter("gender")));
			    System.out.println(gender);
			    String address = request.getParameter("address");
			   
			    String str=request.getParameter("dob");  
			    Date dob=Date.valueOf(str);//converting string into sql date  
			    String img = request.getParameter("img");
			    
			    int id_lecturer = 0;
			    int id_faculty = Integer.parseInt(request.getParameter("id_faculty"));
			    int lecturer_salary = Integer.parseInt(request.getParameter("lecturer_salary"));
			    
				Lecturer lecturer = new Lecturer(id_lecturer,name,password,role,phone,email,CCCD,gender,address,dob,img,id_faculty,lecturer_salary);
				boolean result = LecturerBO.createLecturer(lecturer);
				response.sendRedirect("./viewlist");
				if(result) {
					System.out.println(result);
				}else {
					System.out.println(result);
				}
	}
	
	private void viewLecturerList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			ArrayList<LecturerListView> lecturerList = null;
			request.setCharacterEncoding("UTF-8");
			if(request.getParameter("search")!=null) {
				lecturerList = LecturerBO.getLecturerList(request.getParameter("search"));
			}else {
				lecturerList = LecturerBO.getLecturerList("");
			}
			request.setAttribute("lecturerList", lecturerList);
			RequestDispatcher rd = request.getRequestDispatcher("/LecturerList.jsp");
			rd.forward(request, response);
	}

	private void updateLecturerView(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			int id_lecturer = Integer.parseInt(request.getParameter("id"));
			Lecturer Lecturer = LecturerBO.getLecturerById(id_lecturer);
					System.out.println(Lecturer.getName());
			request.setAttribute("Lecturer", Lecturer);
			ArrayList<Faculty> facultyList = null;
			facultyList = FacultyBO.getAllFaculty();
			request.setAttribute("facultyList", facultyList);
			RequestDispatcher rd = request.getRequestDispatcher("/UpdateLecturer.jsp");
			rd.forward(request, response);
	}
	
	private void updateLecturer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
				request.setCharacterEncoding("UTF-8");
				int id_persion = Integer.parseInt(request.getParameter("id"));
			    String name = request.getParameter("name");
			    String password = request.getParameter("password");
			    String role = "GV";
			    String phone = request.getParameter("phone");
			    String email = request.getParameter("email");
			    String CCCD = request.getParameter("CCCD");
			    boolean gender = ("1".equals(request.getParameter("gender")));
			    String address = request.getParameter("address");
			   
			    String str=request.getParameter("dob");  
			    Date dob=Date.valueOf(str);//converting string into sql date  
			    String img = request.getParameter("img");
			    int id_faculty = Integer.parseInt(request.getParameter("id_faculty"));
			    int lecturer_salary = Integer.parseInt(request.getParameter("lecturer_salary"));
			    
				Lecturer lecturer = new Lecturer(id_persion,name,password,role,phone,email,CCCD,gender,address,dob,img,id_faculty,lecturer_salary);
				boolean result = LecturerBO.updateLecturer(lecturer);
				response.sendRedirect("./viewlist");
//				if(result) {
//					System.out.println(result);
//				}else {
//					System.out.println(result);
//				}
	}
	
	private void deleteLecturer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String delList[]=request.getParameterValues("delete");         
		boolean results = true;
		//del
        for(int i=0;i<delList.length;i++)
        {
        	boolean result = LecturerBO.deleteLecturer(Integer.parseInt(delList[i]));
        	results=result?results:false;
        }		
        response.sendRedirect("./viewlist");
	}
}
