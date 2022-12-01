<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.Faculty"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm lớp học phần</title>
</head>
<body>
			<% 
				ArrayList<Faculty> faculty = (ArrayList<Faculty>)request.getAttribute("FacultyInfor");
				%>
	 <h4 style="width:100%;text-align:center;color:#007bff">Chèn Thông tin Nhân Viên</h4><hr>
				<form action="./add" method="POST" style="width:50%;margin:auto" >
					Mã Lớp Sinh Hoạt: <input type="text" required style="font-weight:bold" name="id_class" id="id_class" class="form-control" >
					<br>
					Tên Lớp Sinh Hoạt: <input type="text" required style="font-weight:bold" name="class_name" id="class_name" class="form-control" >
					<br>
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
					<input type="submit" id="ok" name="add_class" value="OK" >
					<input type="reset" name="reset" id="res"value="RESET">
				</form>
</body>
</html>