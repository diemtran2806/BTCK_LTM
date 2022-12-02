<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Table.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Button.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/ListPage.css">
<title>Đổi mật khẩu</title>
</head>
<body>
	<div class="navbar">
        <jsp:include page="NavigationBar.jsp"></jsp:include>
    </div>
	<div class="wrapper-content">
		<form class="search-form" method="post" action="./update">
        	<div class="flex-wrap">
        		<input class="search" type="password" id="pw1">
				<input class="search" type="password" id="pw2" name="password">
				<p id="notication"></p>
        	</div>
			<input class="btn" type="submit" name="submit" value="Update"/>
    	</form>
    </div>	
    <script>
	    const pw1 = document.getElementById("pw1");
		const pw2 = document.getElementById("pw2");
		const notic = document.getElementById("notication");
		
		pw2.addEventListener('blur', (event) => {
	    	if(pw1.value.localeCompare(pw2.value)){

	    		notic.innerHTML = "Mật khẩu không khớp!";
	    	}	
			else{
				notic.innerHTML ="";
			} 
		 });
	</script>
</body>
</html>