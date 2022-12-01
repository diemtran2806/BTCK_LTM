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
</style>
</head>
<body>
	<div class="navbar">
		<jsp:include page="NavigationBar.jsp"></jsp:include>
	</div>
	<form action="<%=request.getContextPath()%>/Auth/login" method="post">
		<table>
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
</body>
</html>
