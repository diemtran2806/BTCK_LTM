<%@page import="model.BEAN.LecturerListView"%>
<%@page import="java.io.Console"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.AdminView"%>
<%@page import="model.BEAN.StudentView"%>
<%@page import="model.BEAN.Faculty"%>
<%@page import="model.BEAN.Lecturer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/public/css/Table.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/public/css/ListPage.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/public/css/Button.css">
</head>
<body>
	<div class="navbar">
		<jsp:include page="NavigationBar.jsp"></jsp:include>
	</div>

	<div class="wapper-login">
		<div class="container login size-form">
			<header class="modal-header">Thông Tin Cá Nhân</header>
			<div class="modal-body">
				<div class="modal-form">
					<form method="post" action="./upload" enctype="multipart/form-data">
						<input type="file" name="file" /> <input type="submit"
							value="Upload" />
					</form>
					<img alt="default" width="60" height="60"
						src="<%=request.getContextPath()%>/public/img/${img }">
					<form action="<%=request.getContextPath()%>/Me/update" method="post">
						<%
						String role = (String) session.getAttribute("role");

						AdminView adminView = (AdminView) request.getAttribute("admin");

						LecturerListView lecturerView = (LecturerListView) request.getAttribute("lecturer");

						StudentView student = (StudentView) request.getAttribute("student");

						Map<Integer, String> classes = (Map<Integer, String>) request.getAttribute("classes");
						Lecturer lecturer = (Lecturer) request.getAttribute("Lecturer");
						%>
						<div class="modal-form-item">
							<div class="modal-form-element">
								<label for="id" class="modal-label">Mã số</label> <br>
								<input type="text" name="id"
									value="<%=role.equals("admin") ? adminView.getId_person()
		: (role.equals("student") ? student.getId_person() : lecturerView.getId_person())%>"
									class="modal-input" readonly />
							</div>
							<div class="modal-form-element">
								<label for="name" class="modal-label">Tên</label> <br> <input
									type="text" name="name"
									value="<%=role.equals("admin") ? adminView.getName()
		: (role.equals("student") ? student.getName() : lecturerView.getName())%>"
									class="modal-input" />
							</div>
						</div>
						<div class="modal-form-item">
							<div class="modal-form-element">
								<label for="phone" class="modal-label">SĐT</label> <br> <input
									type="text" name="phone"
									value="<%=role.equals("admin") ? adminView.getPhone()
		: (role.equals("student") ? student.getPhone() : lecturerView.getPhone())%>"
									class="modal-input" />
							</div>
							<div class="modal-form-element">
								<label for="email" class="modal-label">Email</label> <br> <input
									type="text" name="email"
									value="<%=role.equals("admin") ? adminView.getEmail()
		: (role.equals("student") ? student.getEmail() : lecturerView.getEmail())%>"
									class="modal-input" />
							</div>
						</div>
						<label for="email" class="modal-label">CCCD</label> <br> <input
							type="text" name="cccd"
							value="<%=role.equals("admin") ? adminView.getCCCD()
		: (role.equals("student") ? student.getCCCD() : lecturerView.getCCCD())%>"
							class="modal-input" />
						</td> <label for="gender" class="modal-label">Giới Tính</label> <br>
						<select name="gender" class="modal-option">
							<%
							if (!(role.equals("admin") ? adminView.getGender()
									: (role.equals("student") ? student.getGender() : lecturerView.getGender()))) {
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
						</select> <label for="address" class="modal-label">Địa Chỉ</label> <br>
						<input type="text" name="address"
							value="<%=role.equals("admin") ? adminView.getAddress()
		: (role.equals("student") ? student.getAddress() : lecturerView.getAddress())%>"
							class="modal-input" />
						</td> <label for="date" class="modal-label">Ngày Sinh</label> <br>
						<input type="date" name="dob"
							value="<%=role.equals("admin") ? adminView.getDob()
		: (role.equals("student") ? student.getDob() : lecturerView.getDob())%>"
							class="modal-input" />
						<%
						if (role.equals("student")) {
						%>
						<label for="id_role" class="modal-label">Lớp</label> <br> <select
							name="id_role" class="modal-option">
							<%
							for (Map.Entry<Integer, String> entry : classes.entrySet()) {
							%>
							<option value=<%=entry.getKey()%>><%=entry.getValue()%></option>
							<%
							}
							%>
						</select>
						<%
						} else if (role.equals("lecturer")) {
						%>
						<label for="id_faculty" class="modal-label">Khoa</label> <br>
						<select name="id_faculty" class="modal-option" required>
							<%
							ArrayList<Faculty> facultyList = (ArrayList<Faculty>) request.getAttribute("facultyList");
							for (int i = 0; i < facultyList.size(); i++) {
							%>
							<option value="<%=facultyList.get(i).getId_faculty()%>"
								<%=lecturer.getId_faculty() == facultyList.get(i).getId_faculty() ? "selected='selected'" : ""%>><%=facultyList.get(i).getFaculty_name()%></option>
							<%
							}
							%>
						</select> <label for="lecturer_salary" class="modal-label">Lương</label> <br>
						<input type="text" name="lecturer_salary"
							value="<%=role.equals("admin") ? adminView.getAdmin_salary() : lecturerView.getLecturer_salary()%>"
							class="modal-input">
						<%
						}
						%>
						<div class="wrapper-btn">
							<input type="submit" id="ok" value="OK" class="btn"> 
							<input type="reset" id="reset" value="Reset" class="btn">
							<input type="hidden" name="img" value="${img }"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${not empty err}"> ${err} </c:if>
</body>
</html>