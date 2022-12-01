<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.LecturerListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Table.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/ListView.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/SearchFormBar.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form class="search_form" name="search_" method="post" action="./viewlist" onsubmit="return required()">     
		    <input class="search_box" type="text" name="search" placeholder="Type here..." value=""><br>
			<input class="search_button" type="submit" name="submit" value="search"/>
		</form>
		<form name="delete_form" method="post" action="./delete" onsubmit="return requiredDelete()">   
			<div class="feature_button">
				<a class="button" href="./new">Thêm</a>
				<input class="button" type="submit" name="submit" value="Xóa"/>  
			</div>
			<div class="table">
				<table>
				  <tr>
				  	<th><input type="checkbox" id="checkAll"></th>
				    <th>Mã giảng viên</th>
				    <th>Tên Giảng viên</th>
				    <th>Số điện thoại</th>
				    <th>Email</th>
				    <th>CCCD</th>
				    <th>Giới tính</th>
				    <th>Địa chỉ</th>
				    <th>Ngày sinh</th>
				    <th>Khoa</th>
				    <th>Cập nhật</th>
				  </tr>
				  	<%
						ArrayList<LecturerListView> lecturerList = (ArrayList<LecturerListView>)request.getAttribute("lecturerList");
						for(int i = 0; i < lecturerList.size(); i++){
					%>		
					<tr>
						<td><input type="checkbox" class="delete" name="delete" value="<%= lecturerList.get(i).getId_person() %>"></td>
						<td><%= lecturerList.get(i).getId_person() %></td>
						<td><%= lecturerList.get(i).getName() %></td>
						<td><%= lecturerList.get(i).getPhone() %></td>
						<td><%= lecturerList.get(i).getEmail() %></td>
						<td><%= lecturerList.get(i).getCCCD() %></td>
						<td><%= lecturerList.get(i).getGender() ? "Nữ" : "Nam" %></td>
						<td><%= lecturerList.get(i).getAddress() %></td>
						<td><%= lecturerList.get(i).getDob() %></td>
						<td><%= lecturerList.get(i).getFaculty_name() %></td>
						<td><a href="./update?id=<%= lecturerList.get(i).getId_person()%>">Update</a></td>
					</tr>
					<%} %>	
				</table>
			</div>
		</form>
	</div>
	<script>
	  let checkall = document.getElementById("checkAll");
	  const checkbox = document.getElementsByClassName("delete");
	  checkall.onclick = function() { 
	    if(checkall.checked){
	      for (let i = 0; i < checkbox.length; i++) {
	        checkbox[i].checked = true;
	      }
	    }else{
	      for (let i = 0; i < checkbox.length; i++) {
	        checkbox[i].checked = false;
	      }
	    }
	  };
	  
	function requiredDelete(){
		let checked = false;
		for (let i = 0; i < checkbox.length; i++) {
	        if(checkbox[i].checked){
	        	checked = true;
	        	break;
	        };
      	}
		if(checked){
			let text = "Bạn chắc chắn muốn xóa?";
		    if (confirm(text) == true) {
		      return true;
		    } else {
		      return false;
		    }
		}
		else{
			alert("Bạn chưa chọn người nào!");
			return false;
		}
	}
	    
	</script>
</body>
</html>