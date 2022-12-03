<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.AdminView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Admin List</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Table.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/ListPage.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Button.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/fontawesome-free-6.2.1/css/all.min.css">
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
		<form class="search-form" action="<%=request.getContextPath()%>/Admin/search" method="post">
			<input type='text' name='value' placeholder='Enter Text Search' class="search">
			<button type="submit" class="btn">Search</button>
		</form>
		</div>
		<form action="<%=request.getContextPath()%>/Admin/deleteMany"  onsubmit="return requiredDelete()">
			<table class="data" width='100%'>
				<thead>
				<tr>
					<th><input type="checkbox" id="checkAll"></th>
					<th>MSSV</th>
					<th>Họ Tên</th>
					<th>SĐT</th>
					<th>Email</th>
					<th>CCCD</th>
					<th>Giới Tính</th>
					<th>Địa Chỉ</th>
					<th>Ngày Sinh</th>
					<th>Lương</th>
					<th>Cập Nhật</th>
					<th>Xóa</th>
				</tr>
				</thead>
				 <tbody>
				<%
				ArrayList<AdminView> adminList = (ArrayList<AdminView>) request.getAttribute("adminList");
				for (int i = 0; i < adminList.size(); i++) {
				%>
				<tr>
					<td><input type="checkbox" name="delete"
						value="<%=adminList.get(i).getId_person()%>"></td>
					<td><%=adminList.get(i).getId_person()%></td>
					<td><%=adminList.get(i).getName()%></td>
					<td><%=adminList.get(i).getPhone()%></td>
					<td><%=adminList.get(i).getEmail()%></td>
					<td><%=adminList.get(i).getCCCD()%></td>
					<td><%=adminList.get(i).getGender()%></td>
					<td><%=adminList.get(i).getAddress()%></td>
					<td><%=adminList.get(i).getDob()%></td>
					<td><%=adminList.get(i).getAdmin_salary()%></td>
					<td><a
						href="<%=request.getContextPath()%>/Admin/update?id=<%=adminList.get(i).getId_person()%>"><button type="button"><i class="update-icon fa-solid fa-pen-to-square"></i></button></a></td>
					<td><a href="<%=request.getContextPath()%>/Admin/delete?id=<%=adminList.get(i).getId_person()%>"><button type="button"><i class="update-icon fa-solid fa-trash"></i></button></a></td>

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
            		<header class="modal-header"> Thêm Admin</header>
            		<div class="modal-body">
            		<div class="modal-form">
            			<form action="<%=request.getContextPath()%>/Admin/add" method="post">
						<label for="name" class="modal-label">Tên Admin</label>
            			<br>
						<input type="text" name="name" placeholder="Nhập tên admin" class="modal-input" required/></td>
						<label for="password" class="modal-label">Mật Khẩu</label>
            			<br>
						<input type="password" name="password" placeholder="Nhập password" class="modal-input" required/></td>
						<label for="phone" class="modal-label">SĐT</label>
            			<br>
						<input type="text" name="phone" placeholder="Nhập SĐT" class="modal-input" required/>
						<label for="email" class="modal-label">Email</label>
            			<br>
						<input type="text" name="email" placeholder="Nhập email" class="modal-input" required/>
						<label for="cccd" class="modal-label">CCCD/CMND</label>
            			<br>
						<input type="text" name="cccd" placeholder="Nhập CCCD/CMND" class="modal-input" required/>
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
						<label for="salary" class="modal-label">Lương</label>
            			<br>
						<input type="text" name="salary" placeholder="Nhập lương" class="modal-input" required/>
			
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