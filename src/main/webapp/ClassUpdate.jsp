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
<link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/ListPage.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Button.css">
</head>
<body>
				<% 
				Class clup = (Class)request.getAttribute("ClassUpdate");
				ArrayList<Faculty> faculty = (ArrayList<Faculty>)request.getAttribute("FacultyInfor");
				%>
	<div class="navbar">
		<jsp:include page="NavigationBar.jsp"></jsp:include>
	</div>
	<div class="wapper-login size-wrapper">
		<div class="container login">
		<header class="modal-header">Cập Nhật Thông Tin Lớp</header>
			<div class="modal-body">
				<div class="modal-form">
				<form action="../Class/update" method="POST">
					<input type="text" hidden required style="font-weight:bold" name="oldId_class" id="oldId_class" value="<%= clup.getId_class() %>" >
                    <label for="id_class" class="modal-label">Mã Lớp</label>
					<br>
					<input type="text" disabled required name="id_class" id="id_class" value="<%= clup.getId_class() %>" class="modal-input" >
					
                    <label for="class_name" class="modal-label">Tên Lớp</label>
					<br>
					<input type="text" required name="class_name" id="class_name" value="<%= clup.getClass_name() %>" class="modal-input">
					
                   	<label for="facultyOption" class="modal-label">Tên Khoa</label>
					<br>
					<select name="facultyOption" id="facultyOption" class = "modal-option">
					<%
					for (int i=0; i<faculty.size(); i++) {
	                    %>
	                    <option value="<%= faculty.get(i).getId_faculty() %>"><%= faculty.get(i).getFaculty_name() %></option>
	                   	<% 
	                   	}
	                   	%>
	                    </select>
                    <br>
					
                    <!-- <input type="submit" id="ok" value="OK" >
					<input type="reset" name="reset" id="res" value="RESET"> -->
					 <div class="wrapper-btn">
						<input type="submit" id="ok" value="OK" class="btn" >
						<input type="reset"id="reset" value="Reset" class="btn">
			 		</div>
				</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>