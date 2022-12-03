<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.Faculty"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách thông tin khoa</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
	integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
	crossorigin="anonymous" />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/public/css/Table.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/public/css/Button.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/public/css/ListPage.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/fonts/fontawesome-free-6.2.1/css/all.min.css">
</head>
<body>
	<div class="navbar">
		<jsp:include page="NavigationBar.jsp"></jsp:include>
	</div>
	<div class="wrapper-content">
		<div class="header-btn">
			<div class="wrapper-add-del">
				<%
				if (session.getAttribute("role") != null && session.getAttribute("role").equals("admin")) {
				%>
				<button id="add" class="btn btn-add">Add</button>
				<%
				}
				%>
			</div>
			<form action="./viewlist" method="POST" class="search-form">
				<input <%if (request.getAttribute("keysearch") != null) {%>
					value="<%=request.getAttribute("keysearch")%>" <%}%> type='text'
					name='keysearch' placeholder='Enter Text Search' class="search">
				<button type="submit" class="btn">Search</button>
			</form>
		</div>
		<table width='100%'>
			<thead>
				<tr>
					<td>Mã Khoa
					</th>
					<td>Tên Khoa
					</th>
					<%
					if (session.getAttribute("role") != null && session.getAttribute("role").equals("admin")) {
					%>
					<td>Cập Nhật <%
					}
					%>
					<td>Chi Tiết
					</th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<Faculty> faculty = (ArrayList<Faculty>) request.getAttribute("faculty");
				if (faculty.size() == 0) {
				%>
				<h2>Không có kết quả nào!</h2>
				<%
				} else {
				for (int i = 0; i < faculty.size(); i++) {
				%>
				<tr>
					<td><%=faculty.get(i).getId_faculty()%></td>
					<td><%=faculty.get(i).getFaculty_name()%></td>
					<%
					if (session.getAttribute("role") != null && session.getAttribute("role").equals("admin")) {
					%>
					<td><a
						href="./update?update=<%=faculty.get(i).getId_faculty()%>"><button
								type="button">
								<i class="update-icon fa-solid fa-pen-to-square"></i>
							</button></a> <%
 }
 %>
					<td><a
						href="./details?details=<%=faculty.get(i).getId_faculty()%>"><button
								type="button">
								<i class="update-icon fa-solid fa-circle-info"></i>
							</button></a>
				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
		<div class="modal">
			<div class="container">
				<div class="modal-close">X</div>
				<header class="modal-header"> Thêm Khoa </header>
				<div class="modal-body">
					<label for="nameFaculty" class="modal-label"> Tên Khoa </label>
					<div class="modal-form">
						<form action="./add" method="POST"" >
							<input id="nameFaculty" type="text" required
								style="font-weight: bold" name="faculty_name" id="faculty_name"
								placeholder="Nhập tên khoa" class="modal-input"> <br>
							<div class="wrapper-btn">
								<input type="submit" id="ok" name="add_faculty" value="OK"
									class="btn"> <input type="reset" name="reset" id="res"
									value="RESET" class="btn">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		const add = document.getElementById("add");
		const modal = document.querySelector(".modal");
		const closeBtn = document.querySelector(".modal-close");
		function showModal() {
			modal.classList.add("open");
		}
		function hideModal() {
			modal.classList.remove("open");
		}
		add.addEventListener('click', showModal);
		closeBtn.addEventListener('click', hideModal);
	</script>
</body>
</html>