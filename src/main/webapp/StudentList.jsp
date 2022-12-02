<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.StudentView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Table.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Button.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/ListPage.css">
	<title>List Student</title>
</head>
<body>
	<div class="navbar">
        <jsp:include page="NavigationBar.jsp"></jsp:include>
    </div>
    <div class="wrapper-content">
	<form class="search-form" action="<%=request.getContextPath()%>/Student/search"
		method="post">
		<input class="search" type="text" name="value" placeholder="Type here..." value="">
		<button type="submit" class="btn">Search</button>
	</form>
	<form action="<%=request.getContextPath()%>/Student/deleteMany">
		<table  class="data" width='100%'>
			<thead>
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
			</thead>
			<tbody>
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
			</tbody>
		</table>
		<input class="btn" type="submit" value="Xóa">
		<a href="<%=request.getContextPath()%>/Student/add"><button type="button" class="btn btn-add">Add</button></a>
	</form>

	
	
	<c:if test="${not empty error}"> ${error} </c:if>
	</div>
</body>
</html>
