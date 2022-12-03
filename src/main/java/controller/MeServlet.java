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

import model.BEAN.AdminView;
import model.BEAN.Faculty;
import model.BEAN.Lecturer;
import model.BEAN.LecturerListView;
import model.BEAN.Person;
import model.BEAN.StudentView;
import model.BO.AdminBO;
import model.BO.FacultyBO;
import model.BO.LecturerBO;
import model.BO.PersonBO;
import model.BO.StudentBO;

@WebServlet("/Me/*")
@MultipartConfig
(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10, // 10 MB
maxRequestSize = 1024 * 1024 * 200 // 200 MB
)
public class MeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getPathInfo();
		try {
			switch (action) {
			case "/update":
				viewFormProfile(request, response);
				break;
			case "/changepassword":
				changePasswordView(request, response);
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
		try {
			switch (action) {
			case "/update":
				update(request, response);
				break;
			case "/upload":
				upload(request, response);
				break;
			case "/changepassword":
				changePassword(request, response);
				break;
			}
		} catch (

		Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void viewFormProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentView student = StudentBO.getStudentViewById((int) request.getSession().getAttribute("id"));
		request.setAttribute("student", student);
		
		LecturerListView lecturer = LecturerBO.getLecturerViewById((int) request.getSession().getAttribute("id"));
		request.setAttribute("lecturer", lecturer);
		
		AdminView admin = AdminBO.getAdminViewById((int) request.getSession().getAttribute("id"));
		request.setAttribute("admin", admin);
		Map<Integer, String> classes = StudentBO.getAllClass();
		request.setAttribute("classes", classes);
		
		ArrayList<Faculty> facultyList  = FacultyBO.getAllFaculty();
		request.setAttribute("facultyList", facultyList);
		
		Lecturer Lecturer = LecturerBO.getLecturerById((int) request.getSession().getAttribute("id"));
		request.setAttribute("Lecturer", Lecturer);
		
		RequestDispatcher rd = request.getRequestDispatcher("/PersonalInfor.jsp");
		rd.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = "";
		String role = (String) request.getSession(false).getAttribute("role");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String cccd = request.getParameter("cccd");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String img = request.getParameter("img");

		try {
			String result = PersonBO.updatePerson(new Person(Integer.parseInt(id), name, password, role, phone, email,
					cccd, gender.equals("1"), address, Date.valueOf(dob), img));
			if (!result.equals("")) {
				request.setAttribute("err", result);
			}else {
				request.getSession().setAttribute("name", name);
				request.getSession().setAttribute("img", img);
			}
			viewFormProfile(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void upload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		String path = request.getServletContext().getRealPath("/public/img");
		String realPath = path.split(".metadata")[0] + request.getContextPath().split("/")[1]
				+ "\\src\\main\\webapp\\public\\img";
		if (!Files.exists(Paths.get(path))) {
			Files.createDirectories(Paths.get(path));
		}
		if (!Files.exists(Paths.get(realPath))) {
			Files.createDirectories(Paths.get(realPath));
		}
//        System.out.println(realPath + File.separator + fileName);
//        System.out.println(path + File.separator + fileName);
//        
//        System.out.print(Thread.currentThread().getContextClassLoader().getResource("").getPath()); 
		for (Part part : request.getParts()) {
			part.write(realPath + File.separator + fileName);
			part.write(path + File.separator + fileName);
		}
		request.setAttribute("img", fileName);
		viewFormProfile(request, response);
	}
	
	private void changePasswordView(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = 55;//get secson id thèn nớ zô đây
			request.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("../ChangePassword.jsp");
			rd.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void changePassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String password = request.getParameter("password");
			boolean result = PersonBO.updatePassword(id,password);
			if(result) {
				RequestDispatcher rd = request.getRequestDispatcher("/");
				rd.forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
