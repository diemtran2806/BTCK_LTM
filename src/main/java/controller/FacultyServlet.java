package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BEAN.Faculty;
import model.BO.FacultyBO;

@WebServlet("/FacultyServlet")
public class FacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FacultyServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		if (request.getParameter("add")!=null) {
			//chuyen ve form them
			response.sendRedirect("FacultyAdd.jsp");
		} else if (request.getParameter("insert")!=null) {
			//check tai khoan
			//check(request, response);
			//them vao co so du lieu
			Faculty fac = new Faculty();
			fac.setId_faculty(0);
			fac.setFaculty_name(request.getParameter("faculty_name"));
			Boolean rs = FacultyBO.FacultyAdd(fac);
			if (rs==true) {
				System.out.println("Add successfuly!");
			} else {
				System.out.println("Something went wrong!");
			}
			response.sendRedirect("FacultyServlet");
		}
		else if (request.getParameter("updateFaculty")!=null) {
			//check(request, response);
			Faculty fac = new Faculty();
			fac.setId_faculty(Integer.parseInt(request.getParameter("oldId_faculty")));
			fac.setFaculty_name(request.getParameter("faculty_name"));
			Boolean rs = FacultyBO.FacultyUpdate(fac);
			if (rs==true) {
				System.out.println("Update Successfull!");
			}
			else {
				System.out.println("Something went wrong!");
			}
			response.sendRedirect("FacultyServlet");
		}
		else if (request.getParameter("update")!=null) {
//			check(request, response);
			// id update
			String idup = request.getParameter("update"); 
			// truyen thong tin id den trang update form
			Faculty fac = FacultyBO.getFacultyByID(Integer.parseInt(idup));
			request.setAttribute("FacultyUpdate", fac);
			request.getRequestDispatcher("FacultyUpdate.jsp").forward(request, response);
		}
		else if (request.getParameter("list_search")!=null) {
			ArrayList<Faculty> faculty = new ArrayList<Faculty>();
			if (request.getParameter("keysearch")==null) {
				faculty = FacultyBO.getAllFaculty();
				
			}
			else {
				String key = request.getParameter("keysearch");
				faculty = FacultyBO.getFacultyByKeySearch(key);
				request.setAttribute("keysearch", key);
			}
			request.setAttribute("faculty", faculty);
			request.getRequestDispatcher("FacultyList.jsp").forward(request, response);
		}
		else if(request.getParameter("list_search")==null){
			ArrayList<Faculty> faculty = null;
			if (request.getParameter("keysearch")==null) {
				faculty = FacultyBO.getAllFaculty();
				
			}
			// chuyen ve cho form
			request.setAttribute("faculty", faculty);
			request.getRequestDispatcher("/FacultyList.jsp").forward(request, response);
		//doGet(request, response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
