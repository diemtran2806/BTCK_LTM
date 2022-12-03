package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.ImageIcon;

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class fileuploadservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public fileuploadservlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart = request.getPart("file");
	    String fileName = filePart.getSubmittedFileName();
		
//        URL location = fileuploadservlet.class.getProtectionDomain()
//                .getCodeSource().getLocation();
//        File file = new File(location.getFile());
//        System.out.println(file.getParent());
        
        String path = request.getServletContext().getRealPath("/");
//        System.out.println(request.getSession().getServletContext().getRealPath("/"));
	    for (Part part : request.getParts()) {
	    	part.write(path + File.separator + "public\\img\\" + fileName);
	    }
	    response.getWriter().print("The file uploaded sucessfully.");
		doGet(request, response);
	}
	
	public void DisplayImage() throws IOException
    {
        BufferedImage img=ImageIO.read(new File("f://images.jpg"));
        ImageIcon icon=new ImageIcon(img);
//        JFrame frame=new JFrame();
//        frame.setLayout(new FlowLayout());
//        frame.setSize(200,300);
//        JLabel lbl=new JLabel();
//        lbl.setIcon(icon);
//        frame.add(lbl);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}