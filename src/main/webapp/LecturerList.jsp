<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.LecturerListView"%>
<%@page import="model.BEAN.Faculty"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Table.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Button.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/ListPage.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/fontawesome-free-6.2.1/css/all.min.css">
<title>Insert title here</title>
</head>
<body>
	<div class="navbar">
        <jsp:include page="NavigationBar.jsp"></jsp:include>
    </div>
	<div class="wrapper-content">
	<div class="header-btn">
	<div class="wrapper-add-del">
	<button type="button" id="add" class="btn btn-add">Add</button>
	</div>
		<form class="search-form" name="search_" method="post" action="./viewlist">     
		    <input <% if (request.getAttribute("keysearch")!=null)  {%> value="<%= request.getAttribute("keysearch") %>"<% } %>
		    		class="search" type="text" name="search" placeholder="Type here..." value="">
			<button type="submit" class="btn">Search</button>
		</form>
	</div>
		<form name="delete_form" method="post" action="./delete" onsubmit="return requiredDelete()">   
				<table  class="data" width='100%'>
				  <thead>
					  <tr>
					  	<td><input type="checkbox" id="checkAll"></th>
					    <td>Mã giảng viên</th>
					    <td>Tên Giảng viên</th>
					    <td>Số điện thoại</th>
					    <td>Email</th>
					    <td>CCCD</th>
					    <td>Giới tính</th>
					    <td>Địa chỉ</th>
					    <td>Ngày sinh</th>
					    <td>Khoa</th>
					    <td>Lương</th>
					    <td>Cập nhật</th>
					  </tr>
				  </thead>
				   <tbody>
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
						<td><%= lecturerList.get(i).getLecturer_salary() %></td>
						<td><a href="./update?id=<%= lecturerList.get(i).getId_person()%>"><button type="button"><i class="update-icon fa-solid fa-pen-to-square"></i></button></a></td>
					</tr>
					<%} %>
					 </tbody>	
				</table>
			<input class="btn btn-del" name="submit" type="submit" value="Xóa">
			</form>
			<div class="modal">
				<div class="container scroll">
					<div class="modal-close">X</div>
            		<header class="modal-header"> Thêm Giảng Viên</header>
            		<div class="modal-body">
            		<div class="modal-form">
            			<form name="create_emp" method="post" action="./new" onsubmit="return required()">
        					<label for="name" class="modal-label">Tên Giảng Viên</label>
            				<br>
        					<input type="text" name="name" value="" placeholder="Nhập tên giảng viên" class="modal-input">
      						<label for="password" class="modal-label">Mật Khẩu</label>
            				<br>
      						<input type="password" name="password" placeholder="Nhập mật khẩu" class="modal-input" value="">
      						<label for="role" class="modal-label">Chức Vụ</label>
            				<br>
      						<input type="text" name="role" placeholder="Nhập chức vụ" class="modal-input" value="">
      						<label for="phone" class="modal-label">SĐT</label>
            				<br>
      						<input type="text" name="phone" placeholder="Nhập SĐT" class="modal-input" value="">
      						<label for="email" class="modal-label">Email</label>
            				<br>
      						<input type="email" name="email" placeholder="Nhập SĐT" class="modal-input" value="">
      						<label for="CCCD" class="modal-label">CCCD/CMND</label>
            				<br>
      						<input type="text" name="CCCD" placeholder="Nhập số cmnd/cccd" class="modal-input" value="">
      						<label for="gender" class="modal-label">Giới Tính</label>
            				<br>
      						<select name="gender" class = "modal-option" required>
    						<option selected value="0">Nam</option>
    						<option value="1">Nữ</option>
							</select>
      						<label for="address" class="modal-label">Địa Chỉ</label>
            				<br>
      						<input type="text" name="address" placeholder="Nhập địa chỉ" class="modal-input" value="">
      						<label for="date" class="modal-label">Ngày Sinh</label>
            				<br>
      						<input type="date" name="dob" placeholder="Nhập ngày sinh" class="modal-input" value="">
      						<label for="id_faculty" class="modal-label">Chọn Khoa</label>
            				<br>	
							<select name="id_faculty" class = "modal-option" required>
							<option  selected>Chọn Khoa</option>
							<%
							ArrayList<Faculty> facultyList = (ArrayList<Faculty>)request.getAttribute("facultyList");
							for(int i = 0; i < facultyList.size(); i++){
							%>
		    				<option  value="<%= facultyList.get(i).getId_faculty() %>"><%= facultyList.get(i).getFaculty_name() %></option>
		    				<%} %>	
							</select>
        					<label for="lecturer_salary" class="modal-label">Lương</label>
            				<br>
        					<input type="text" name="lecturer_salary" placeholder="Nhập lương" class="modal-input" value="">
        				<div class="wrapper-btn">
						<input type="submit" id="ok" name="Add" value="Add" class="btn" >
						<input type="reset" name="reset" id="res" value="RESET" class="btn">
						</div>
    		</form>
            		</div>
            		</div>
				</div>
			</div>
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
	
	const add = document.getElementById("add");
 	const modal = document.querySelector(".modal");
 	const closeBtn = document.querySelector(".modal-close");
 	function showModal() {
 		modal.classList.add("open");
 	}
 	function hideModal() {
 		modal.classList.remove("open");
 	}
 	add.addEventListener('click',showModal);
 	closeBtn.addEventListener('click', hideModal);
	    
	</script>
</body>
</html>