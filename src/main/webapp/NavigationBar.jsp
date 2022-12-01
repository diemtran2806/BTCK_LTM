<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Navigation Bar</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
	integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
	crossorigin="anonymous" />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap"
	rel="stylesheet">
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: "Poppins", sans-serif;
}

.wrapper {
	display: flex;
	width: 100%;
	height: 42px;
	background-color: #283c4e;
	justify-content: space-between;
	align-items: center;
}

.text {
	text-decoration: none;
	color: #fff;
	line-height: 32px;
	width: 100%;
	height: 100%;
	display: block;
}

.wrapper-button {
	align-items: center;
	text-align: center;
	width: 122px;
	height: 32px;
	color: white;
	text-decoration: none;
	font-weight: 400;
	font-size: 14px;
	margin-right: 6px;
}

.wrapper-button:hover a {
	color: black;
	background-color: rgb(243, 247, 253);
	border-radius: 4px;
}

.menu {
	display: flex;
	margin: 0 32px 0 32px;
}
</style>
</head>
<body>
	<div class="wrapper">
		<div class="menu">
			<div class="wrapper-button">
				<a href="<%=request.getContextPath()%>/" class="text">Trang Chủ</a>
			</div>
			<div class="wrapper-button">
				<a href="FacultyServlet" class="text">Khoa</a>
			</div>
			<div class="wrapper-button">
				<a href="<%=request.getContextPath()%>/Class/viewlist" class="text">Lớp Sinh Hoạt</a>
			</div>
			<div class="wrapper-button">
				<a href="<%=request.getContextPath()%>/Student/viewlist" class="text">Sinh viên</a>
			</div>
			<div class="wrapper-button">
				<a href="<%=request.getContextPath()%>/Admin/viewlist" class="text">Admin</a>
			</div>
			<div class="wrapper-button">
				<a href="<%=request.getContextPath()%>/Lecturer/viewlist" class="text">Admin</a>
			</div>
		</div>
		<div class="menu">
			<div class="wrapper-button">
				<%
				if (session.getAttribute("name") == null) {
				%>
				<a href="<%=request.getContextPath()%>/login.jsp" class="text">Log in</a>
				<%
				} else {
				%>
				<a href="<%=request.getContextPath()%>/Auth/logout" class="text">Log out</a>
<!-- 				<p> -->
<!-- 					Welcome -->
<%-- 					<%=session.getAttribute("name")%> --%>
<!-- 					!!! -->
<!-- 				</p> -->
				<%
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>