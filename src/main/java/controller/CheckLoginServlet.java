package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.*;

import model.BEAN.Lecturer;
import model.BEAN.Person;
import model.BO.LecturerBO;
import model.BO.PersonBO;

@WebServlet("/Auth/*")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		try {
			switch (action) {
			case "/login":
				viewFormlogin(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			default:
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		try {
			switch (action) {
			case "/login":
				login(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			default:
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}

	}

	private void viewFormlogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("../login.jsp").forward(request, response);
	}

	private static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}

	@SuppressWarnings("deprecation")
	private void login(HttpServletRequest request, HttpServletResponse response) {
		try {			
			String idd = request.getParameter("id");
			int id = 0;
			if(isNumeric(idd)) id = Integer.parseInt(idd);
			else {
				request.setAttribute("error", "Tài khoản phải là số!");
				request.getRequestDispatcher("../login.jsp").forward(request, response);
			}
			String password = request.getParameter("password");
			PasswordAuthentication hashPass = new PasswordAuthentication(15);
			String passUser = PersonBO.getPassPerson(id);
			if (hashPass.authenticate(password, passUser)) {
				Person person = PersonBO.getPersonById(id);
				request.getSession().setAttribute("id", person.getId_person());
				request.getSession().setAttribute("name", person.getName());
				request.getSession().setAttribute("img", person.getImg());
				request.getSession().setAttribute("role", person.getRole());
				response.sendRedirect(request.getContextPath() + "/");
			} else {
				request.setAttribute("error", "Đăng nhập không thành công \nVui lòng nhập lại tài khoản và mật khẩu!");
				request.getRequestDispatcher("../login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
