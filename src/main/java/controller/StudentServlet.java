package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BEAN.Student;
import model.BEAN.StudentView;
import model.BO.PersonBO;
import model.BO.StudentBO;

@WebServlet("/Student/*")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getPathInfo();
//		System.out.println(action);

		try {
			switch (action) {
			case "/viewlist":
				ArrayList<StudentView> studentList = StudentBO.getStudentList("");
				request.setAttribute("studentList", studentList);
				String path = request.getServletContext().getRealPath("/");
				FileInputStream fin = new FileInputStream(path + File.separator + "public\\img\\");
				request.setAttribute("img", fin);
				RequestDispatcher rd = request.getRequestDispatcher("/StudentList.jsp");
				rd.forward(request, response);
				break;
			case "/add":
				response.sendRedirect("../CreateStudent.jsp");
				break;
			case "/update":
				StudentView student = StudentBO.getStudentViewById(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("student", student);
				Map<Integer, String> classes = StudentBO.getAllClass();
				request.setAttribute("classes", classes);
				rd = request.getRequestDispatcher("../UpdateStudent.jsp");
				rd.forward(request, response);
				break;
			default:
				doPost(request, response);
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
//		System.out.println(action);

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
			default:
				doGet(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void displayImg(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException {
		response.setContentType("image/jpeg");
		ServletOutputStream out;
		out = response.getOutputStream();
		
		String path = request.getServletContext().getRealPath("/");
		FileInputStream fin = new FileInputStream(path + File.separator + "public\\img\\" + fileName);

		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int ch = 0;
		;
		while ((ch = bin.read()) != -1) {
			bout.write(ch);
		}

		bin.close();
		fin.close();
		bout.close();
		out.close();
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String role = "student";
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String cccd = request.getParameter("cccd");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String img = request.getParameter("img");
		String id_role = request.getParameter("id_role");
		ArrayList<StudentView> studentList = null;

		try {
			if (StudentBO.createStudent(new Student(0, name, password, role, phone, email, cccd, gender.equals("1"),
					address, Date.valueOf(dob), img, Integer.parseInt(id_role)))) {
				response.sendRedirect("./viewlist");
			} else {
				request.setAttribute("error", "Something went wrong!");
				response.sendRedirect("./viewlist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id_person");
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
		String id_role = request.getParameter("id_role");
		ArrayList<StudentView> studentList = null;

		try {
			if (StudentBO.updateStudent(new Student(Integer.parseInt(id), name, password, role, phone, email, cccd,
					gender.equals("1"), address, Date.valueOf(dob), img, Integer.parseInt(id_role)))) {
				response.sendRedirect("./viewlist");
			} else {
				request.setAttribute("error", "Something went wrong!");
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