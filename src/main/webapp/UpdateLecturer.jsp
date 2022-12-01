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
</head>
<body>
	<%
		Lecturer Lecturer = (Lecturer) request.getAttribute("Lecturer");
	%>
	<form name="create_emp" method="post" action="./update" onsubmit="return required()">
		<label for="id">Mã Giảng Viên</label>
        <input type="text" name="id" value="<%= Lecturer.getId_person() %>" readonly><br>
        <label for="name">Tên Giảng viên</label>
        <input type="text" name="name" value="<%= Lecturer.getName() %>"><br>
        <label for="role">Chức vụ</label>
        <input type="text" name="role" value="<%= Lecturer.getRole() %>"><br>
        <label for="phone">Số điện thoại</label>
        <input type="text" name="phone" value="<%= Lecturer.getPhone() %>"><br>
        <label for="email">email</label>
        <input type="email" name="email" value="<%= Lecturer.getEmail() %>"><br>
        <label for="CCCD">CCCD/CMND</label>
        <input type="text" name="CCCD" value="<%= Lecturer.getCCCD() %>"><br>
        <label for="gender">Giới tính</label>
        <select name="gender" required>
            <option value="0" <%= Lecturer.getGender() ? "" : "selected='selected'" %> >Nam</option>
            <option value="1" <%= Lecturer.getGender() ? "selected='selected'" : "" %> >Nữ</option>
		</select>
        <label for="address">Địa chỉ</label>
        <input type="text" name="address" value="<%= Lecturer.getAddress() %>"><br>
        <label for="dob">Ngày sinh</label>
        <input type="date" name="dob" value="<%= Lecturer.getDob() %>"><br>
        <label for="id_faculty">Khoa</label>	
		<select name="id_faculty" required>
			<%
				ArrayList<Faculty> facultyList = (ArrayList<Faculty>)request.getAttribute("facultyList");
				for(int i = 0; i < facultyList.size(); i++){
			%>
		    <option  value="<%= facultyList.get(i).getId_faculty() %>" <%= Lecturer.getId_faculty()==facultyList.get(i).getId_faculty() ? "selected='selected'" : "" %>><%= facultyList.get(i).getFaculty_name() %></option>
		    <%} %>	
		</select><br>
        <label for="lecturer_salary">Lương</label>
        <input type="text" name="lecturer_salary" value="<%= Lecturer.getLecturer_salary() %>"><br>
        <input type="submit" name="submit" value="Update"/>
    </form>
</body>
</html>
