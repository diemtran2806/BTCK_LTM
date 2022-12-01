<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.StudentView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Student</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Student/search"
		method="post">
		<table>
			<tr>
				<td>Value:</td>
				<td><input type="text" name="value" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form>
	<form action="<%=request.getContextPath()%>/Student/deleteMany">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Họ tên</th>
				<th>Số điện thoại</th>
				<th>Email</th>
				<th>CCCD</th>
				<th>Giới tính</th>
				<th>Địa chỉ</th>
				<th>Ngày sinh</th>
				<th>Lớp</th>
			</tr>
			<%
			ArrayList<StudentView> studentList = (ArrayList<StudentView>) request.getAttribute("studentList");
			for (int i = 0; i < studentList.size(); i++) {
			%>
			<tr>
				<td><%=studentList.get(i).getId_person()%></td>
				<td><%=studentList.get(i).getName()%></td>
				<td><%=studentList.get(i).getPhone()%></td>
				<td><%=studentList.get(i).getEmail()%></td>
				<td><%=studentList.get(i).getCCCD()%></td>
				<td><%=studentList.get(i).getGender()%></td>
				<td><%=studentList.get(i).getAddress()%></td>
				<td><%=studentList.get(i).getDob()%></td>
				<td><%=studentList.get(i).getClass_name()%></td>
				<td><a
					href="<%=request.getContextPath()%>/Student/update?id=<%=studentList.get(i).getId_person()%>"><button type="button">Update</button></a></td>
				<td><a
					href="<%=request.getContextPath()%>/Student/delete?id=<%=studentList.get(i).getId_person()%>"><button type="button">Delete</button></a></td>
				<td><input type="checkbox" name="delete"
					value="<%=studentList.get(i).getId_person()%>"></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td class="btn" colspan="12"><input type="submit"
					value="Xóa"></td>
			</tr>
		</table>
	</form>

	<a href="<%=request.getContextPath()%>/Student/add">Add</a>
	
	<c:if test="${not empty error}"> ${error} </c:if>
</body>
</html>
