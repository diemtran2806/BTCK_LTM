<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.AdminView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Table.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Button.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/ListPage.css">

<meta charset="UTF-8">

<title>Admin List</title>
</head>
<body>
	<div class="navbar">
        <jsp:include page="NavigationBar.jsp"></jsp:include>
    </div>
    <div class="wrapper-content">
		<form class="search-form" action="<%=request.getContextPath()%>/Admin/search" method="post">
			<input type='text' name='value' placeholder='Enter Text Search' class="search">
			<button type="submit" class="btn">Search</button>
		</form>
		<form action="<%=request.getContextPath()%>/Admin/deleteMany">
			<table class="data" width='100%'>
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
					<th>Lương</th>
				</tr>
				</thead>
				 <tbody>
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
				</tbody>
			</table>
			<a href="<%=request.getContextPath()%>/Admin/add"><button type="button" class="btn btn-add">Add</button></a>
			<input class="btn" type="submit" value="Xóa">
		</form>
	
		
		
		<c:if test="${not empty error}"> ${error} </c:if>
	</div>
</body>
</html>