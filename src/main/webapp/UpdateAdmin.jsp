<%@page import="model.BEAN.AdminView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update admin</title>
</head>
<body>
	<div class="navbar">
        <jsp:include page="NavigationBar.jsp"></jsp:include>
    </div>
	<form action="<%=request.getContextPath()%>/Admin/update" method="post">
		<table>
			<%
			AdminView admin = (AdminView) request.getAttribute("admin");
			%>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id_person"
					value="<%=admin.getId_person()%>" readonly /></td>
			</tr>
			<tr>
				<td>Họ tên:</td>
				<td><input type="text" name="name"
					value="<%=admin.getName()%>" /></td>
			</tr>
			<tr>
				<td>Số điện thoại:</td>
				<td><input type="text" name="phone"
					value="<%=admin.getPhone()%>" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"
					value="<%=admin.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>CCCD:</td>
				<td><input type="text" name="cccd"
					value="<%=admin.getCCCD()%>" /></td>
			</tr>
			<tr>
				<td>Giới tính:</td>
				<td><select name="gender">
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
				</select></td>
			</tr>
			<tr>
				<td>Địa chỉ:</td>
				<td><input type="text" name="address"
					value="<%=admin.getAddress()%>" /></td>
			</tr>
			<tr>
				<td>Ngày sinh:</td>
				<td><input type="date" name="dob" value="<%=admin.getDob()%>" /></td>
			</tr>
			<tr>
				<td>Lớp:</td>
				<td><input type="text" name="salary" value="<%=admin.getAdmin_salary()%>" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>