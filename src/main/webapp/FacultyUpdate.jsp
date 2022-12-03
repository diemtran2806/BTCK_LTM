<%@page import="model.BEAN.Faculty"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật thông tin khoa</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/ListPage.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Button.css">
</head>
<body>
	<div class="navbar">
		<jsp:include page="NavigationBar.jsp"></jsp:include>
	</div>
		<% 
			Faculty fac = (Faculty)request.getAttribute("FacultyUpdate");
		%>
	<div class="wapper-login size-wrapper">
		<div class="container login">
		<header class="modal-header">Cập Nhật Thông Tin Khoa</header>
		<div class="modal-body">
		<div class="modal-form">
		<form action="../Faculty/update" method="POST" >
			<input type="text" hidden required style="font-weight:bold" name="oldId_faculty" id="oldId_faculty" value="<%= fac.getId_faculty() %>" >
            <label for="id_faculty" class="modal-label">Mã Khoa</label>
			<br>
			<input type="text" disabled required name="id_faculty" id="id_faculty" value="<%= fac.getId_faculty() %>" class="modal-input">
					
             <label for="faculty_name" class="modal-label">Tên Khoa</label>
			<input type="text" required name="faculty_name" id="faculty_name" value="<%= fac.getFaculty_name() %>" class="modal-input" >
             <br>
					
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