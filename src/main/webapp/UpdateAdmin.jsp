<%@page import="model.BEAN.AdminView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update admin</title>
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
    <div class="wapper-login">
    <div class="container login size-form">
    <header class="modal-header">Cập Nhật Thông Tin Admin</header>
    <div class="modal-body">
    <div class="modal-form">
	<form action="<%=request.getContextPath()%>/Admin/update" method="post">
			<%
			AdminView admin = (AdminView) request.getAttribute("admin");
			%>
			<div class="modal-form-item">
			<div class="modal-form-element">
			<label for="id_person" class="modal-label">Mã Admin</label>
			<br>
			<input type="text" name="id_person" value="<%=admin.getId_person()%>" class="modal-input" readonly />
			 </div>
        	<div class="modal-form-element">
			<label for="name" class="modal-label">Họ Và Tên</label>
			<br>
			<input type="text" name="name" value="<%=admin.getName()%>" class="modal-input" />
			 </div>
			  </div>
			<label for="phone" class="modal-label">SĐT</label>
			<br>
			<input type="text" name="phone" value="<%=admin.getPhone()%>" class="modal-input"/>
			<label for="email" class="modal-label">Email</label>
			<br>
			<input type="text" name="email" value="<%=admin.getEmail()%>" class="modal-input"/>
			<label for="cccd" class="modal-label">CCCD</label>
			<br>
			<input type="text" name="cccd" value="<%=admin.getCCCD()%>" class="modal-input"/>
			<label for="genger" class="modal-label">Giới Tính</label>
			<br>
			<select name="gender" class ="modal-option">
						<%
						if (!admin.getGender()) {
						%>
						<option value=0 selected>Nam</option>
						<option value=1>Nữ</option>
						<%
						} else {
						%>
						<option value=0>Nam</option>
						<option value=1 selected>Nữ</option>
						<%
						}
						%>
				</select>
			<label for="address" class="modal-label">Địa Chỉ</label>
			<br>
			<input type="text" name="address" value="<%=admin.getAddress()%>" class="modal-input"/>
			<label for="date" class="modal-label">Ngày Sinh</label>
			<br>
			<input type="date" name="dob" value="<%=admin.getDob()%>" class="modal-input"/>
			<label for="salary" class="modal-label">Lương</label>
			<br>
			<input type="text" name="salary" value="<%=admin.getAdmin_salary()%>" class="modal-input" />
			<div class="wrapper-btn">
				<input type="submit" name="submit" value="Update" class="btn" >
				<input type="reset"id="reset" value="Reset" class="btn">
			 </div>
	</form>
	</div>
	</div>
	</div>
	</div>
</body>
</html>