<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.Faculty"%>
<%@page import="model.BEAN.LecturerListView"%>
<%@page import="model.BEAN.Lecturer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		Lecturer Lecturer = (Lecturer) request.getAttribute("Lecturer");
	%>
	<div class="wapper-login">
	<div class="container login size-form">
	<header class="modal-header">Cập Nhật Thông Tin Giảng Viên</header>
	<div class="modal-body">
	<div class="modal-form">
	<form name="create_emp" method="post" action="../Lecturer/update" onsubmit="return required()">
		<div class="modal-form-item">
		<div class="modal-form-element">
		<label for="id" class="modal-label">MSSV</label>
		<br>
        <input type="text" name="id" value="<%= Lecturer.getId_person() %>" class="modal-input" readonly>
        </div>
        <div class="modal-form-element">
        <label for="name" class="modal-label">Tên Giảng Viên</label>
		<br>
        <input type="text" name="name" value="<%= Lecturer.getName() %>" class="modal-input">
        </div>
        </div>
        <label for="role" class="modal-label">Chức vụ</label>
        <br>
        <input type="text" name="role" value="<%= Lecturer.getRole() %>" class="modal-input">
        <label for="phone" class="modal-label">Số điện thoại</label>
        <br>
        <input type="text" name="phone" value="<%= Lecturer.getPhone() %>" class="modal-input">
        <label for="email" class="modal-label">email</label>
        <br>
        <input type="email" name="email" value="<%= Lecturer.getEmail() %>"  class="modal-input">
        <label for="CCCD" class="modal-label">CCCD/CMND</label>
        <br>
        <input type="text" name="CCCD" value="<%= Lecturer.getCCCD() %>" class="modal-input">
        <label for="gender" class="modal-label">Giới tính</label>
        <br>
        <select name="gender" class ="modal-option" required>
            <option value="0" <%= Lecturer.getGender() ? "" : "selected='selected'" %> >Nam</option>
            <option value="1" <%= Lecturer.getGender() ? "selected='selected'" : "" %> >Nữ</option>
		</select>
        <label for="address" class="modal-label">Địa chỉ</label>
        <br>
        <input type="text" name="address" value="<%= Lecturer.getAddress() %>" class="modal-input">
        <label for="dob" class="modal-label">Ngày sinh</label>
        <br>
        <input type="date" name="dob" value="<%= Lecturer.getDob() %>" class="modal-input">
        <label for="id_faculty"  class="modal-label">Khoa</label>	
        <br>
		<select name="id_faculty" class ="modal-option" required>
			<%
				ArrayList<Faculty> facultyList = (ArrayList<Faculty>)request.getAttribute("facultyList");
				for(int i = 0; i < facultyList.size(); i++){
			%>
		    <option  value="<%= facultyList.get(i).getId_faculty() %>" <%= Lecturer.getId_faculty()==facultyList.get(i).getId_faculty() ? "selected='selected'" : "" %>><%= facultyList.get(i).getFaculty_name() %></option>
		    <%} %>	
		</select>
        <label for="lecturer_salary" class="modal-label">Lương</label>
        <br>
        <input type="text" name="lecturer_salary" value="<%= Lecturer.getLecturer_salary() %>" class="modal-input">
        <!-- <input type="submit" name="submit" value="Update"/> -->
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
