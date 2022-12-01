<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.AdminView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin List</title>
</head>
<body>
	<div class="navbar">
        <jsp:include page="NavigationBar.jsp"></jsp:include>
    </div>
	<form action="<%=request.getContextPath()%>/Admin/search" method="post">
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
	<form action="<%=request.getContextPath()%>/Admin/deleteMany">
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
				<th>Lương</th>
			</tr>
			<%
			ArrayList<AdminView> adminList = (ArrayList<AdminView>) request.getAttribute("adminList");
			for (int i = 0; i < adminList.size(); i++) {
			%>
			<tr>
				<td><%=adminList.get(i).getId_person()%></td>
				<td><%=adminList.get(i).getName()%></td>
				<td><%=adminList.get(i).getPhone()%></td>
				<td><%=adminList.get(i).getEmail()%></td>
				<td><%=adminList.get(i).getCCCD()%></td>
				<td><%=adminList.get(i).getGender()%></td>
				<td><%=adminList.get(i).getAddress()%></td>
				<td><%=adminList.get(i).getDob()%></td>
				<td><%=adminList.get(i).getAdmin_salary()%></td>
				<td><a
					href="<%=request.getContextPath()%>/Admin/update?id=<%=adminList.get(i).getId_person()%>"><button type="button">Update</button></a></td>
				<td><a
					href="<%=request.getContextPath()%>/Admin/delete?id=<%=adminList.get(i).getId_person()%>"><button type="button">Delete</button></a></td>
				<td><input type="checkbox" name="delete"
					value="<%=adminList.get(i).getId_person()%>"></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td class="btn" colspan="12"><input type="submit" value="Xóa"></td>
			</tr>
		</table>
	</form>

	<a href="<%=request.getContextPath()%>/Admin/add">Add</a>
	
	<c:if test="${not empty error}"> ${error} </c:if>
</body>
</html>