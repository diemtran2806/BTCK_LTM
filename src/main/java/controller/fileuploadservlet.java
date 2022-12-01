package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class fileuploadservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public fileuploadservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart = request.getPart("file");
	    String fileName = filePart.getSubmittedFileName();
	    for (Part part : request.getParts()) {
	      part.write(".\\public\\img\\" + fileName);
//	      part.write("D:\\code\\Java\\BTCK_LTM\\src\\main\\webapp\\public\\img\\" + fileName);
	    }
	    response.getWriter().print("The file uploaded sucessfully.");
		doGet(request, response);
	}

}
