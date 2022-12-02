<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Login</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/ListPage.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Button.css">
</head>
<body>
	<div class="navbar">
		<jsp:include page="NavigationBar.jsp"></jsp:include>
	</div>
	<div class="wapper-login">
	<div class="container login">
			<header class="modal-header">Login</header>
			<div class="modal-body">
				<div class="modal-form">
					<form action="<%=request.getContextPath()%>/Auth/login" method="post">
						<label for="id" class="modal-label">Tài Khoản</label>
						<br>
						<input type="text" required style="font-weight:bold" name="id" id="id" placeholder="Nhập tên tài khoản" class="modal-input">
						<label for="password" class="modal-label">Mật Khẩu</label>
						<br>
						<input id="password" type="password" required style="font-weight:bold" name="password" id="password" placeholder="Nhập mật khẩu" class="modal-input">
						<div class="wrapper-btn">
							<input type="submit" id="ok" value="Login" class="btn" >
							<input type="reset"id="res" value="Reset" class="btn">
						</div>
					</form>
				<div id="error" class="error">
				<c:if test="${not empty error}"> ${error} </c:if>
			</div>
	</div>
	</div>
	</div>
	</div>
	<script>
		const username = document.getElementById("id");
		const error = document.getElementById("error");
		function hideError() {
			error.style.display = "none";
     	}
     	username.addEventListener('change',hideError);
	</script>
</body>
</html>
