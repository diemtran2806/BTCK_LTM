<%@page import="model.BEAN.StudentView"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update student</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
	integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
	crossorigin="anonymous" />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap"
	rel="stylesheet">
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
			<header class="modal-header">Cập Nhật Thông Tin Sinh Viên</header>
			<div class="modal-body">
				<div class="modal-form">
					<form action="<%=request.getContextPath()%>/Student/update"
						method="post">
						<%
						StudentView student = (StudentView) request.getAttribute("student");
						Map<Integer, String> classes = (Map<Integer, String>) request.getAttribute("classes");
						%>
						<div class="modal-form-item">
							<div class="modal-form-element">
								<label for="id_person" class="modal-label">MSSV</label> <br>
								<input type="text" name="id_person"
									value="<%=student.getId_person()%>" class="modal-input"
									readonly />
							</div>
							<div class="modal-form-element">
								<label for="name" class="modal-label">Tên Sinh Viên</label> <br>
								<input type="text" name="name" value="<%=student.getName()%>"
									class="modal-input" />
							</div>
						</div>
						<div class="modal-form-item">
							<div class="modal-form-element">
								<label for="phone" class="modal-label">SĐT</label> <br> <input
									type="text" name="phone" value="<%=student.getPhone()%>"
									class="modal-input" />
							</div>
							<div class="modal-form-element">
								<label for="email" class="modal-label">Email</label> <br> <input
									type="text" name="email" value="<%=student.getEmail()%>"
									class="modal-input" />
							</div>
						</div>
						<label for="email" class="modal-label">CCCD</label> <br> <input
							type="text" name="cccd" value="<%=student.getCCCD()%>"
							class="modal-input" />
						</td> <label for="gender" class="modal-label">Giới Tính</label> <br>
						<select name="gender" class="modal-option">
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
						</select> <label for="address" class="modal-label">Địa Chỉ</label> <br>
						<input type="text" name="address"
							value="<%=student.getAddress()%>" class="modal-input" />
						</td> <label for="date" class="modal-label">Ngày Sinh</label> <br>
						<input type="date" name="dob" value="<%=student.getDob()%>"
							class="modal-input" /> <label for="id_role" class="modal-label">Lớp</label>
						<br> <select name="id_role" class="modal-option">
							<%
							for (Map.Entry<Integer, String> entry : classes.entrySet()) {
							%>
							<option value=<%=entry.getKey()%>><%=entry.getValue()%></option>
							<%
							}
							%>
						</select>
						<div class="wrapper-btn">
							<input type="submit" id="ok" value="OK" class="btn"> 
							<input type="reset" id="reset" value="Reset" class="btn">
							<input type="hidden" name="img" value="<%=student.getImg()%>"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<c:if test="${not empty err}"> ${err} </c:if>
</body>
</html>