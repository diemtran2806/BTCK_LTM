package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import model.BEAN.StudentView;
import model.BO.StudentBO;
import model.BEAN.LecturerListView;
import model.BO.LecturerBO;
import model.BEAN.AdminView;
import model.BEAN.Faculty;
import model.BEAN.Lecturer;
import model.BO.AdminBO;
import model.BO.FacultyBO;


/**
 * Servlet implementation class PersonalInforServlet
 */
@WebServlet("/PersonalInformation")
public class PersonalInforServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PersonalInforServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentView student = StudentBO.getStudentViewById((int) request.getSession().getAttribute("id"));
		System.out.println(request.getSession().getAttribute("id").toString() + "neeeeeeeee" + student.getName());
		request.setAttribute("student", student);
		
		LecturerListView lecturer = LecturerBO.getLecturerViewById((int) request.getSession().getAttribute("id"));
		request.setAttribute("lecturer", lecturer);
		
		AdminView admin = AdminBO.getAdminViewById((int) request.getSession().getAttribute("id"));
		request.setAttribute("admin", admin);
		Map<Integer, String> classes = StudentBO.getAllClass();
		request.setAttribute("classes", classes);
		ArrayList<Faculty> facultyList = null;
		facultyList = FacultyBO.getAllFaculty();
		request.setAttribute("facultyList", facultyList);
		
		Lecturer Lecturer = LecturerBO.getLecturerById((int) request.getSession().getAttribute("id"));
		request.setAttribute("Lecturer", Lecturer);
		
		RequestDispatcher rd = request.getRequestDispatcher("/PersonalInfor.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
