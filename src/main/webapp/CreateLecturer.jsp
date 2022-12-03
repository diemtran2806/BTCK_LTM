<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.Faculty"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="create_emp" method="post" action="./new" onsubmit="return required()">
        <label for="name">Tên Giảng viên</label>
        <input type="text" name="name" value="" required><br>
        <label for="password">Mật khẩu</label>
        <input id="pw1" type="password" name="password" value="" required><br>
        <label for="password">Nhập lại mật khẩu</label>
        <input id="pw2" type="password" name="passwordConfirm" required /><br>
        <label for="role">Chức vụ</label>
        <input type="text" name="role" value="" required><br>
        <label for="phone">Số điện thoại</label>
        <input type="text" name="phone" value="" required><br>
        <label for="email">email</label>
        <input type="email" name="email" value="" required><br>
        <label for="CCCD">CCCD/CMND</label>
        <input type="text" name="CCCD" value="" required><br>
        <label for="gender">Giới tính</label>
        <select name="gender" required>
		    <option selected value="0">Nam</option>
		    <option value="1">Nữ</option>
		</select>
        <label for="address">Địa chỉ</label>
        <input type="text" name="address" value="" required><br>
        <label for="dob">Ngày sinh</label>
        <input type="date" name="dob" value="" required><br>
        <label for="id_faculty">Khoa</label>	
		<select name="id_faculty" required>
			<option  selected>Chọn Khoa</option>
			<%
				ArrayList<Faculty> facultyList = (ArrayList<Faculty>)request.getAttribute("facultyList");
				for(int i = 0; i < facultyList.size(); i++){
			%>
		    <option  value="<%= facultyList.get(i).getId_faculty() %>"><%= facultyList.get(i).getFaculty_name() %></option>
		    <%} %>	
		</select><br>
        <label for="lecturer_salary">Lương</label>
        <input type="text" name="lecturer_salary" value="" required><br>
        <input id="add" type="submit" name="submit" value="Thêm"/>
    </form>
    <p id="notication"></p>
	<c:if test="${not empty err}"> ${err} </c:if>
	<script>
	    const pw1 = document.getElementById("pw1");
		const pw2 = document.getElementById("pw2");
		const notic = document.getElementById("notication");
		const btnAdd = document.getElementById("add");
		
		pw2.addEventListener('blur', (event) => {
	    	if(pw1.value.localeCompare(pw2.value)){
	    		notic.innerHTML = "Mật khẩu không khớp!";
	    		btnAdd.disabled = true;
	    	}	
			else{
				notic.innerHTML ="";
				btnAdd.disabled = false;
			} 
		 });
	</script>
</body>
</html>