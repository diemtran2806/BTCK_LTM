<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://www.w3schools.com/lib/w3.js"></script>
<style>
	.navbar {
		margin: 12px 0 12px 0;
	}
	.img {
		height: 100vh;
		width:100%;
		/*  background-image: url(./HomeImg2.png); */
		 background-repeat: no-repeat;
    	background-size: cover;
	}
</style>
</head>
<body>
	<div class="navbar">
        <jsp:include page="NavigationBar.jsp"></jsp:include>
    </div>
    <img class="slides img" src="HomeImg.png">
    <img class="slides img" src="HomeImg1.png">
	<img class="slides img" src="HomeImg3.png">
	<script>
		w3.slideshow(".slides", 5000);
	</script>
</body>
</html>