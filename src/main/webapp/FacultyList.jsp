<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.Faculty"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách thông tin khoa</title>
</head>
<body>
	<a href="FacultyServlet?add=1"><button>Add</button></a>
	<form action="?list_search=1" method="POST">
		<input <% if (request.getAttribute("keysearch")!=null)  {%> value="<%= request.getAttribute("keysearch") %>"<% } %>
					type='text' name='keysearch' placeholder='Enter Text Search'>
		<button type="submit">Search</button>
	</form>
	<br><hr>

            <h4>Thông Tin Khoa</h4>
            <table width='100%'>
                <thead>
                    <tr>
                        <td>Mã Khoa</th>
                        <td>Tên Khoa</th>
                        <td>Chi Tiết</th>
                    </tr>
                </thead>
                <tbody>
                	<%
	                    ArrayList<Faculty> faculty = (ArrayList<Faculty>)request.getAttribute("faculty");
	                    for (int i=0; i<faculty.size(); i++) {
	                    %>
	                    <tr>
	                    	<td><%= faculty.get(i).getId_faculty() %></td>
	                    	<td><%= faculty.get(i).getFaculty_name() %></td>
	                    	<td><a href="ClassServlet?details=<%=faculty.get(i).getId_faculty() %>"><button>Chi Tiết</button></a>
	                    	<td><a href="FacultyServlet?update=<%=faculty.get(i).getId_faculty() %>"><button>Update</button></a>
	                   	</tr>
	                   	<% 
	                   	}
	                   	%>
                </tbody>
            </table>
</body>
</html>