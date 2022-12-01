package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BEAN.Person;
import model.BO.PersonBO;

@WebServlet("/Auth/*")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
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

	private void login(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");

		try {
			if (PersonBO.isValidUser(id, password)) {
				Person person = PersonBO.getPersonById(id);
				request.getSession().setAttribute("name", person.getName());
				request.getSession().setAttribute("role", person.getRole());
				response.sendRedirect("../Home.jsp");
			} else {
				request.setAttribute("error", "Login failed! Please recheck the username and password and try again!");
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
}
