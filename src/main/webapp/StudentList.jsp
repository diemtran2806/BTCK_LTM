<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.StudentView"%>
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
	<title>List Student</title>
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
	</div>
	<form class="search-form" action="<%=request.getContextPath()%>/Student/search"
		method="post">
		<input class="search" type="text" name="value" placeholder="Type here..." value="">
		<button type="submit" class="btn">Search</button>
	</form>
	</div>
	<form action="<%=request.getContextPath()%>/Student/deleteMany" onsubmit="return requiredDelete()">
		<table  class="data" width='100%'>
			<thead>
			<tr>
				<th><input type="checkbox" id="checkAll"></th>
				<th>MSSV</th>
				<th>Họ tên</th>
				<th>Số điện thoại</th>
				<th>Email</th>
				<th>CCCD</th>
				<th>Giới tính</th>
				<th>Địa chỉ</th>
				<th>Ngày sinh</th>
				<th>Lớp</th>
				<th>Cập nhật</th>
				<th>Xóa</th>
			</tr>
			</thead>
			<tbody>
			<%
			ArrayList<StudentView> studentList = (ArrayList<StudentView>) request.getAttribute("studentList");
			for (int i = 0; i < studentList.size(); i++) {
			%>
			<tr>
				<td><input type="checkbox" name="delete"
					value="<%=studentList.get(i).getId_person()%>"></td>
				<td><%=studentList.get(i).getId_person()%></td>
				<td><%=studentList.get(i).getName()%></td>
				<td><%=studentList.get(i).getPhone()%></td>
				<td><%=studentList.get(i).getEmail()%></td>
				<td><%=studentList.get(i).getCCCD()%></td>
				<td><%=studentList.get(i).getGender()%></td>
				<td><%=studentList.get(i).getAddress()%></td>
				<td><%=studentList.get(i).getDob()%></td>
				<td><%=studentList.get(i).getClass_name()%></td>
				<td><a href="<%=request.getContextPath()%>/Student/update?id=<%=studentList.get(i).getId_person()%>"><button type="button"><i class="update-icon fa-solid fa-pen-to-square"></i></button></a></td>
				<td><a href="<%=request.getContextPath()%>/Student/delete?id=<%=studentList.get(i).getId_person()%>"><button type="button"><i class="update-icon fa-solid fa-trash"></i></button></a></td>
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
		<input class="btn btn-del" type="submit" value="Xóa">
	</form>
	<c:if test="${not empty error}"> ${error} </c:if>
	<div class="modal">
		<div class="container scroll">
			<div class="modal-close">X</div>
            	<header class="modal-header"> Thêm Sinh Viên</header>
            	<div class="modal-body">
            	<div class="modal-form">
            	<form action="<%=request.getContextPath()%>/Student/add" method="post">
				<label for="name" class="modal-label">Tên Học Sinh</label>
            	<br>
				<input type="text" name="name" placeholder="Nhập tên học sinh" class="modal-input" required/>
				<label for="password" class="modal-label">Mật Khẩu</label>
            	<br>
				<input type="password" name="password" placeholder="Nhập mật khẩu" class="modal-input" required/>
				<label for="phone" class="modal-label">SĐT</label>
            	<br>
				<input type="text" name="phone" placeholder="Nhập SĐT" class="modal-input" required/>
				<label for="email" class="modal-label">Email</label>
            	<br>
				<input type="text" name="email" placeholder="Nhập email" class="modal-input" required/>
				<label for="cccd" class="modal-label">CCCD</label>
            	<br>
				<input type="text" name="cccd" placeholder="Nhập email" class="modal-input" required/>
				<label for="gender" class="modal-label">Giới Tính</label>
            	<br>
				<select name="gender" class = "modal-option">
						<option value=0 selected>Nam</option>
						<option value=1>Nữ</option>
				</select>
				<label for="address" class="modal-label">Địa Chỉ</label>
            	<br>
				<input type="text" name="address" placeholder="Nhập địa chỉ" class="modal-input" required/>
				<label for="date" class="modal-label">Ngày Sinh</label>
            	<br>
				<input type="date" name="dob" placeholder="Chọn ngày sinh" class="modal-input" required/>
				<label for="id_role" class="modal-label">Lớp</label>
            	<br>
				<input type="text" name="id_role" placeholder="Chọn lớp" class="modal-input" required/>
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
