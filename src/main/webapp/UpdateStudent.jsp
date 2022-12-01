<%@page import="model.BEAN.StudentView"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update student</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Student/update" method="post">
		<table>
			<%
			StudentView student = (StudentView) request.getAttribute("student");
			Map<Integer, String> classes = (Map<Integer, String>) request.getAttribute("classes");
			%>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id_person"
					value="<%=student.getId_person()%>" readonly /></td>
			</tr>
			<tr>
				<td>Họ tên:</td>
				<td><input type="text" name="name"
					value="<%=student.getName()%>" /></td>
			</tr>
			<tr>
				<td>Số điện thoại:</td>
				<td><input type="text" name="phone"
					value="<%=student.getPhone()%>" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"
					value="<%=student.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>CCCD:</td>
				<td><input type="text" name="cccd"
					value="<%=student.getCCCD()%>" /></td>
			</tr>
			<tr>
				<td>Giới tính:</td>
				<td><select name="gender">
						<%
						if (!student.getGender()) {
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
					value="<%=student.getAddress()%>" /></td>
			</tr>
			<tr>
				<td>Ngày sinh:</td>
				<td><input type="date" name="dob" value="<%=student.getDob()%>" /></td>
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
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>