<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Login</title>
<style>
body {
	background-color: #f2f2f2;
}

.content_container {
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.wrapper-content {
	width: 40%;
	border-top-left-radius: 10px;
	/* box-shadow: 0 0 50px 2px rgba(1, 1, 1, 0.6); */
	box-shadow: rgba(0, 0, 0, 0.1) 0px 4px 12px;
	margin: auto;
	background-color: #f2f2f26e;
}

.btn {
	border-style: none;
	padding: 6px 12px;
	border-radius: 4px;
	background-color: #7e98b0;
	color: white;
}

.btn:hover {
	background-color: #1e256c;
}

.data th, td {
	text-align: left;
	padding: 8px;
	/* border-left: 1px solid #999; */
}

.data {
	margin: auto;
}
</style>
</head>
<body>
	<div class="navbar">
		<jsp:include page="NavigationBar.jsp"></jsp:include>
	</div>
	<div class="content_container">
		<div class="wrapper-content">
			<h2>Login</h2>
			<form action="<%=request.getContextPath()%>/Auth/login" method="post">
				<table class="data">
					<tr>
						<td><label for="id">Tài khoản:</label></td>
						<td><input type="text" name="id" required /></td>
					</tr>
					<tr>
						<td><label for="password">Mật khẩu:</label></td>
						<td><input type="password" name="password" required /></td>
					</tr>
					<tr>
						<td><input class="btn" type="submit" value="Login" /></td>
						<td><input class="btn" type="reset" value="Reset" /></td>
					</tr>
				</table>
			</form>
			<c:if test="${not empty error}"> ${error} </c:if>
		</div>
	</div>
</body>
</html>
