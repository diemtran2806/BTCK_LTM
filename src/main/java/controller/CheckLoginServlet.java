package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
				login(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			case "/changepassword":
				changePasswordView(request, response);
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
			case "/changepassword":
				changePassword(request, response);
				break;
			default:
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}

	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		try {
			if (PersonBO.isValidUser(id, password)) {
				Person person = PersonBO.getPersonById(id);
				request.getSession().setAttribute("id", person.getId_person());
				request.getSession().setAttribute("name", person.getName());
				request.getSession().setAttribute("role", person.getRole());
				response.sendRedirect("../Home.jsp");
			} else {
				request.setAttribute("error", "Đăng nhập không thành công \nVui lòng nhập lại tài khoản và mật khẩu!");
				RequestDispatcher rd = request.getRequestDispatcher("../login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getSession().invalidate();
			response.sendRedirect("../Home.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
