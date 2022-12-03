package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.BEAN.Student;
import model.BEAN.StudentView;
import model.BO.PersonBO;
import model.BO.StudentBO;

import utils.*;

@WebServlet("/Student/*")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getPathInfo();
//		System.out.print(Thread.currentThread().getContextClassLoader().getResource("").getPath()); 

		try {
			switch (action) {
			case "/viewlist":
				viewList(request, response);
				break;
			case "/add":
				viewFormAdd(request, response);
				break;
			case "/update":
				viewFormUpdate(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getPathInfo();
		RequestDispatcher rd;
		ArrayList<StudentView> studentList = null;

		try {
			switch (action) {
			case "/search":
				studentList = StudentBO.getStudentList(request.getParameter("value"));
				request.setAttribute("studentList", studentList);
				rd = request.getRequestDispatcher("/StudentList.jsp");
				rd.forward(request, response);
				break;
			case "/add":
				add(request, response);
				break;
			case "/update":
				update(request, response);
				break;
			case "/delete":
				if (PersonBO.deletePerson(Integer.parseInt(request.getParameter("id")))) {
					response.sendRedirect("./viewlist");
				} else {
					request.setAttribute("error", "Something went wrong!");
					response.sendRedirect("./viewlist");
				}
				break;
			case "/deleteMany":
				deleteMany(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void viewList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<StudentView> studentList = StudentBO.getStudentList("");
		request.setAttribute("studentList", studentList);
		RequestDispatcher rd = request.getRequestDispatcher("/StudentList.jsp");
		rd.forward(request, response);
	}
	
	private void viewFormAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<Integer, String> classes;
		RequestDispatcher rd;
		classes = StudentBO.getAllClass();
		request.setAttribute("classes", classes);
		rd = request.getRequestDispatcher("../CreateStudent.jsp");
		rd.forward(request, response);
	}
	
	private void viewFormUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<Integer, String> classes;
		RequestDispatcher rd;
		StudentView student = StudentBO.getStudentViewById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("student", student);
		classes = StudentBO.getAllClass();
		request.setAttribute("classes", classes);
		rd = request.getRequestDispatcher("../UpdateStudent.jsp");
		rd.forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String role = "student";
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String cccd = request.getParameter("cccd");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String img = "default.png";
		String id_role = request.getParameter("id_role");
		PasswordAuthentication hashPass = new PasswordAuthentication(15);
		@SuppressWarnings("deprecation")
		String pass = hashPass.hash(password);
		
		try {
			String result = StudentBO.createStudent(new Student(0, name, pass, role, phone, email, cccd, gender.equals("1"),
					address, Date.valueOf(dob), img, Integer.parseInt(id_role)));	
			if (!result.equals("")) {
				request.setAttribute("err", result);
				viewFormAdd(request, response);
			} else {
				response.sendRedirect("./viewlist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = "";
		String role = "student";
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String cccd = request.getParameter("cccd");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String img = request.getParameter("img");
		String id_class = request.getParameter("id_class");

		try {
			String result = StudentBO.updateStudent(new Student(Integer.parseInt(id), name, password, role, phone, email, cccd,
					gender.equals("1"), address, Date.valueOf(dob), img, Integer.parseInt(id_class)));
			if (!result.equals("")) {
				request.setAttribute("err", result);
				viewFormUpdate(request, response);
			} else {
				response.sendRedirect("./viewlist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteMany(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String delList[] = request.getParameterValues("delete");
		boolean results = true;
		// del
		for (int i = 0; i < delList.length; i++) {
			boolean result = PersonBO.deletePerson(Integer.parseInt(delList[i]));
			results = result ? results : false;
		}
		if (!results)
			request.setAttribute("error", "Something went wrong!");
		response.sendRedirect("./viewlist");
	}
}