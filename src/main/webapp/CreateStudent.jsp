<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new student</title>
</head>
<body>
	<div class="navbar">
		<jsp:include page="NavigationBar.jsp"></jsp:include>
	</div>
	<form action="<%=request.getContextPath()%>/Student/add" method="post">
		<%
		Map<Integer, String> classes = (Map<Integer, String>) request.getAttribute("classes");
		%>
		<table>
			<tr>
				<td>Họ tên:</td>
				<td><input type="text" name="name" required /></td>
			</tr>
			<tr>
				<td>Mật khẩu:</td>
				<td><input type="password" id="pw1" name="password" required /></td>
			</tr>
			<tr>
				<td>Nhập lại mật khẩu:</td>
				<td><input type="password" id="pw2" name="passwordConfirm" required /></td>
			</tr>
			<tr>
				<td>Số điện thoại:</td>
				<td><input type="text" name="phone" required /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" required /></td>
			</tr>
			<tr>
				<td>CCCD:</td>
				<td><input type="text" name="cccd" required /></td>
			</tr>
			<tr>
				<td>Giới tính:</td>
				<td><select name="gender">
						<option value=0 selected>Nam</option>
						<option value=1>Nữ</option>
				</select></td>
			</tr>
			<tr>
				<td>Địa chỉ:</td>
				<td><input type="text" name="address" required /></td>
			</tr>
			<tr>
				<td>Ngày sinh:</td>
				<td><input type="date" name="dob" required /></td>
			</tr>
			<tr>
				<td>Lớp:</td>
				<td><select name="id_role">
						<%
						for (Map.Entry<Integer, String> entry : classes.entrySet()) {
						%>
						<option value=<%=entry.getKey()%>><%=entry.getValue()%></option>
						<%
						}
						%>
				</select></td>				
				<td><input type="hidden" name="img" value="${img }"/></td>
			</tr>
			<tr>
				<td><input id="add" type="submit" value="Add" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
			</form>
		</table>
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