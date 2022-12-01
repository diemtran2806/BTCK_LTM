<%@page import="model.BEAN.Faculty"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật thông tin khoa</title>
</head>
<body>
				<% 
				Faculty fac = (Faculty)request.getAttribute("FacultyUpdate");
				%>
				<form action="FacultyServlet?updateFaculty=1" method="POST" style="width:50%;margin:auto" >
					<input type="text" hidden required style="font-weight:bold" name="oldId_faculty" id="oldId_faculty" value="<%= fac.getId_faculty() %>" >
                    <label for="id_class">Mã khoa</label>
					<input type="text" disabled required style="font-weight:bold" name="id_faculty" id="id_faculty" value="<%= fac.getId_faculty() %>" >
					
                    <label for="class_name">Tên lớp</label>
					<input type="text" required style="font-weight:bold" name="faculty_name" id="faculty_name" value="<%= fac.getFaculty_name() %>" >
					
                    <br>
					
                    <input type="submit" id="ok" value="OK" >
					<input type="reset" name="reset" id="res" value="RESET">
				</form>
</body>
</html>