<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="fileuploadservlet"
		enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" value="Upload" />
	</form>	
</body>
</html>