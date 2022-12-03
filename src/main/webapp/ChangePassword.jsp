<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/ListPage.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Button.css">
	<title>Đổi mật khẩu</title>
</head>
<body>
	<div class="navbar">
        <jsp:include page="NavigationBar.jsp"></jsp:include>
    </div>
	<div class="wapper-login">
		<div class="container login">
		<header class="modal-header">Change password</header>
		<div class="modal-body">
		<div class="modal-form">
			<form class="search-form" method="post" action="./changepassword">
					<input type="text" name="id" value="<%= request.getAttribute("id")%>" hidden>
	        		<input type="password" id="pw1"  placeholder="Nhập mật khẩu" class="modal-input">
	        		<br>
					<input type="password" id="pw2" name="password" placeholder="Nhập lại mật khẩu" class="modal-input">
					<br>
					<p id="notication"></p>
					<div class="wrapper-btn">
						<input id="update" class="btn" type="submit" name="submit" value="Update"/>
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
	    const pw1 = document.getElementById("pw1");
		const pw2 = document.getElementById("pw2");
		const notic = document.getElementById("notication");
		const btnUpdate = document.getElementById("update");
		
		pw2.addEventListener('blur', (event) => {
	    	if(pw1.value.localeCompare(pw2.value)){
	    		notic.innerHTML = "Mật khẩu không khớp!";
	    		btnUpdate.disabled = true;
	    	}	
			else{
				notic.innerHTML ="";
				btnUpdate.disabled = false;
			} 
		 });
	</script>
</body>
</html>