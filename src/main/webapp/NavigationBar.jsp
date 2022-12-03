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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/fonts/fontawesome-free-6.2.1/css/all.min.css">
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
	display: flex;
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

.avata img {
	width: 32px;
	height: 32px;
	border-radius: 50%;
	background-repeat: no-repeat;
	background-size: cover;
}
/* .user-infor {
	display: flex;
} */
.avata:hover .user-menu {
	display: block;
}

.avata {
	position: relative;
	display: flex;
	align-items: center;
}

.avata:hover {
	cursor: pointer;
}

.name-user {
	color: #fff;
	font-size: 14px;
	font-weight: 500;
	margin-left: 12px;
}

.user-menu {
	position: absolute;
	z-index: 1;
	padding: 14px 0;
	top: 130%;
	width: 160px;
	right: 0;
	background: #fff;
	list-style: none;
	/* box-shadow: 0 1px 2px #e0e0e0; */
	box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px
		6px;
	border-radius: 5px;
	display: none;
}

.user-menu::before {
	content: "";
	border-width: 20px 27px;
	border-style: solid;
	border-color: transparent transparent #fff transparent;
	position: absolute;
	top: -29px;
	right: 94px;
}

.user-menu::after {
	content: "";
	display: block;
	position: absolute;
	top: -8px;
	right: 0;
	height: 8px;
	width: 56%;
}

.user-item:nth-child(2) {
	border-bottom: 1px solid #DCDCDC;
}

.user-item a {
	text-decoration: none;
	font-size: 13px;
	padding: 6px 16px;
	display: block;
	color: #808080;
	font-weight: 450;
	display: flex;
}

.wrapper-user-item:hover {
	background: #fafafa;
	z-index: 1;
}

.wrapper-user-item {
	display: flex;
	align-items: center;
	width: 100%;
}

.icon-item {
	color: #808080;
	font-size: 12px;
	padding-left: 12px;
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
				<a href="<%=request.getContextPath()%>/Faculty/viewlist"
					class="text">Khoa</a>
			</div>
			<div class="wrapper-button">
				<a href="<%=request.getContextPath()%>/Class/viewlist" class="text">Lớp
					Sinh Hoạt</a>
			</div>
			<div class="wrapper-button">
				<a href="<%=request.getContextPath()%>/Student/viewlist"
					class="text">Sinh viên</a>
			</div>

			<div class="wrapper-button">
				<a href="<%=request.getContextPath()%>/Lecturer/viewlist"
					class="text">Giảng viên</a>
			</div>
			<%
			if (session.getAttribute("role") != null && session.getAttribute("role").equals("admin")) {
			%>
			<div class="wrapper-button">
				<a href="<%=request.getContextPath()%>/Admin/viewlist" class="text">Admin</a>
			</div>
			<%
			}
			%>
		</div>
		<div class="menu">
			<%
			if (session.getAttribute("name") == null) {
			%>
			<div class="wrapper-button">
				<a href="<%=request.getContextPath()%>/Auth/login" class="text">Đăng
					Nhập</a>
			</div>
			<%
			} else {
			%>
			<div class="avata">
				<div id="avata-img" class="avata-img">
					<img
						src="<%=request.getContextPath()%>/public/img/${img } ">
				</div>
				<div class="name-user"><%=session.getAttribute("name")%></div>

				<ul class="user-menu">
					<li class="user-item">
						<div class="wrapper-user-item">
							<i class="icon-item fa-solid fa-user"></i> <a
								href="<%=request.getContextPath()%>/Me/update">Trang Cá Nhân</a>
						</div>
					</li>
					<li class="user-item">
						<div class="wrapper-user-item">
							<i class="icon-item fa-solid fa-lock"></i> <a
								href="<%=request.getContextPath()%>/Me/changepassword">Đổi Mật Khẩu</a>
						</div>
					</li>
					<li class="user-item">
						<div class="wrapper-user-item">
							<i class="icon-item fa-solid fa-right-from-bracket"></i> <a
								href="<%=request.getContextPath()%>/Auth/logout">Đăng Xuất</a>
						</div>
					</li>
				</ul>
			</div>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>