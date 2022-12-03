<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new admin</title>
</head>
<body>
	<div class="navbar">
        <jsp:include page="NavigationBar.jsp"></jsp:include>
    </div>
    
	<form action="<%=request.getContextPath()%>/Admin/add" method="post">
		<table>
			<tr>
				<td>Họ tên:</td>
				<td><input type="text" name="name" required/></td>
			</tr>
			<tr>
				<td>Mật khẩu:</td>
				<td><input type="password" name="password" required/></td>
			</tr>
			<tr>
				<td>Số điện thoại:</td>
				<td><input type="text" name="phone" required/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" required/></td>
			</tr>
			<tr>
				<td>CCCD:</td>
				<td><input type="text" name="cccd" required/></td>
			</tr>
			<tr>
				<td>Giới tính:</td>
				<td>
					<select name="gender">
						<option value=0 selected>Nam</option>
						<option value=1>Nữ</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Địa chỉ:</td>
				<td><input type="text" name="address" required/></td>
			</tr>
			<tr>
				<td>Ngày sinh:</td>
				<td><input type="date" name="dob" required/></td>
			</tr>
			<tr>
				<td>Lương:</td>
				<td><input type="text" name="salary" required/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>