<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.Class"%>
<%@page import="model.BEAN.Faculty"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật thông tin lớp sinh hoạt</title>
</head>
<body>
				<% 
				Class clup = (Class)request.getAttribute("ClassUpdate");
				ArrayList<Faculty> faculty = (ArrayList<Faculty>)request.getAttribute("FacultyInfor");
				%>
				<form action="./update" method="POST" style="width:50%;margin:auto" >
					<input type="text" hidden required style="font-weight:bold" name="oldId_class" id="oldId_class" value="<%= clup.getId_class() %>" >
                    <label for="id_class">Mã lớp học</label>
					<input type="text" disabled required style="font-weight:bold" name="id_class" id="id_class" value="<%= clup.getId_class() %>" >
					
                    <label for="class_name">Tên lớp</label>
					<input type="text" required style="font-weight:bold" name="class_name" id="class_name" value="<%= clup.getClass_name() %>" >
					
                    <%-- <label for="id_faculty">Mã Khoa</label>
					<input type="text" required style="font-weight:bold" name="id_faculty" id="id_faculty" value="<%= clup.getId_faculty() %>"> --%>
					<select name="facultyOption" id="facultyOption">
					<%
					for (int i=0; i<faculty.size(); i++) {
	                    %>
	                    <option value="<%= faculty.get(i).getId_faculty() %>"><%= faculty.get(i).getFaculty_name() %></option>
	                   	<% 
	                   	}
	                   	%>
	                    </select>
                    <br>
					
                    <input type="submit" id="ok" value="OK" >
					<input type="reset" name="reset" id="res" value="RESET">
				</form>
</body>
</html>