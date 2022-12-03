package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BEAN.Admin;
import model.BEAN.AdminView;
import model.BO.AdminBO;
import model.BO.PersonBO;
import utils.PasswordAuthentication;

@WebServlet("/Admin/*")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getPathInfo();
		RequestDispatcher rd;

		try {
			switch (action) {
			case "/viewlist":
				viewList(request, response);
				break;
			case "/add":
				response.sendRedirect("../CreateAdmin.jsp");
				break;
			case "/update":
				showUpdateForm(request, response);
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
		ArrayList<AdminView> adminList = null;

		try {
			switch (action) {
			case "/search":
				adminList = AdminBO.getAdminList(request.getParameter("value"));
				request.setAttribute("adminList", adminList);
				rd = request.getRequestDispatcher("/AdminList.jsp");
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
	
	private void viewList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AdminView> adminList = AdminBO.getAdminList("");
		request.setAttribute("adminList", adminList);
		RequestDispatcher rd = request.getRequestDispatcher("/AdminList.jsp");
		rd.forward(request, response);
	}
	
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminView admin = AdminBO.getAdminViewById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("admin", admin);
		RequestDispatcher rd = request.getRequestDispatcher("/UpdateAdmin.jsp");
		rd.forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String role = "admin";
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String cccd = request.getParameter("cccd");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String img = "default.png";
		String salary = request.getParameter("salary");
		
		PasswordAuthentication hashPass = new PasswordAuthentication(15);
		@SuppressWarnings("deprecation")
		String pass = hashPass.hash(password);

		try {
			String result = AdminBO.createAdmin(new Admin(0, name, pass, role, phone, email, cccd, gender.equals("1"), address,
					Date.valueOf(dob),img, Integer.parseInt(salary)));
			if (result.equals("")) {
				response.sendRedirect("./viewlist");
			} else {
				request.setAttribute("err", result);
				RequestDispatcher rd = request.getRequestDispatcher("../CreateAdmin.jsp");
				rd.forward(request, response);
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
		String salary = request.getParameter("salary");

		try {
			String result = AdminBO.updateAdmin(new Admin(Integer.parseInt(id), name, password, role, phone, email, cccd,
					gender.equals("1"), address, Date.valueOf(dob),img, Integer.parseInt(salary)));
			if (result.equals("")) {
				response.sendRedirect("./viewlist");
			} else {
				request.setAttribute("err", result);
				showUpdateForm(request, response);
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
