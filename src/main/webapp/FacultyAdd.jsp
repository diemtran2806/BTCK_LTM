<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Khoa</title>
</head>
<body>
	<h4 style="width:100%;text-align:center">Thêm Thông Tin Khoa</h4><hr>
				<form action="FacultyServlet?insert=1" method="POST" style="width:50%;margin:auto" >
					Tên Khoa: <input type="text" required style="font-weight:bold" name="faculty_name" id="faculty_name">
					<br>
					<input type="submit" id="ok" name="add_faculty" value="OK" >
					<input type="reset" name="reset" id="res" value="RESET">
				</form>
</body>
</html>