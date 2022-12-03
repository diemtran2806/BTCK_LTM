package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

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
import model.BO.PersonBO;
import utils.PasswordAuthentication;

@WebServlet("/Lecturer/*")
public class LecturerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LecturerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

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
				request.getRequestDispatcher("").forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

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
		String role = "lecturer";
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String CCCD = request.getParameter("CCCD");
		System.out.println(request.getParameter("gender"));
		boolean gender = ("1".equals(request.getParameter("gender")));
		System.out.println(gender);
		String address = request.getParameter("address");
		Date dob = Date.valueOf(request.getParameter("dob"));
		String img = "default.png";

		int id_lecturer = 0;
		int id_faculty = Integer.parseInt(request.getParameter("id_faculty"));
		int lecturer_salary = Integer.parseInt(request.getParameter("lecturer_salary"));

		PasswordAuthentication hashPass = new PasswordAuthentication(15);
		@SuppressWarnings("deprecation")
		String pass = hashPass.hash(password);

		Lecturer lecturer = new Lecturer(id_lecturer, name, pass, role, phone, email, CCCD, gender, address, dob, img,
				id_faculty, lecturer_salary);
		String result = LecturerBO.createLecturer(lecturer);
		if (result.equals("")) {
			response.sendRedirect("./viewlist");
			System.out.println(result);
		} else {
			request.setAttribute("err", result);
			createLecturerView(request, response);
			System.out.println(result);
		}
	}

	private void viewLecturerList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			ArrayList<LecturerListView> lecturerList = null;
			ArrayList<Faculty> facultyList = null;
			facultyList = FacultyBO.getAllFaculty();
			request.setAttribute("facultyList", facultyList);
			request.setCharacterEncoding("UTF-8");
			if(request.getParameter("search")!=null) {
				request.setAttribute("keysearch", request.getParameter("search"));
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
		String role = "lecturer";
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String CCCD = request.getParameter("CCCD");
		boolean gender = ("1".equals(request.getParameter("gender")));
		String address = request.getParameter("address");
		Date dob = Date.valueOf(request.getParameter("dob"));
		String img = request.getParameter("img");
		int id_faculty = Integer.parseInt(request.getParameter("id_faculty"));
		int lecturer_salary = Integer.parseInt(request.getParameter("lecturer_salary"));

		String result = LecturerBO.updateLecturer(new Lecturer(id_persion, name, password, role, phone, email, CCCD,
				gender, address, dob, img, id_faculty, lecturer_salary));
		if (!result.equals("")) {
			request.setAttribute("err", result);
			updateLecturerView(request, response);
		} else {
			response.sendRedirect("./viewlist");
		}
	}

	private void deleteLecturer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String delList[] = request.getParameterValues("delete");
		boolean results = true;
		// del
		for (int i = 0; i < delList.length; i++) {
			boolean result = PersonBO.deletePerson(Integer.parseInt(delList[i]));
			results = result ? results : false;
		}
		response.sendRedirect("./viewlist");
	}
}
