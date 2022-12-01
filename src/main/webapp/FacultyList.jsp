<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.Faculty"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách thông tin khoa</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
	<style>
		body {
  		font-family: "Poppins", sans-serif;	
  		}
  		table {
  			/* border-collapse: collapse; */
  			width: 95%;
  			font-size: 14px;
  			margin: auto;
  			background-color: #fff;
  			margin-top: 24px;
		}
		thead {
			background-color: #283c4e;
			color: #fff;
			font-weight: 500;
		}
		.data th, td {
  			text-align: left;
  			padding: 8px;
  			/* border-left: 1px solid #999; */
		}
		tr:nth-child(even){background-color: #f2f2f2}
		tr:hover {
			background-color: #d6d9ff;
		}
		th {
  			background-color: #04AA6D;
  			color: white;
		}
		h4 {
			text-align: center;
			color: #283c4e;
			margin: 8px 0 8px 0;
			display:none;
		}
		button, input {
			outline: none;
    		border: none;
		}
		.btn {
			background-color: #255783;
			color: #fff;
			padding: 10px 24px 10px 24px;
			border-radius: 4px;
		}
		.btn:hover {
			opacity: 0.8;
			cursor: pointer;
		}
		.search {
			padding: 6px;
			border: 1px solid #255783;
			border-radius: 4px;
			margin-right: 12px;
		}
		.search-form {
			margin-top: 24px;
    		text-align: right;
    		margin-right: 32px;
    		padding-top: 24px
		}
		.wrapper-content {
			width:95%;
			border-top-left-radius: 10px;
			/* box-shadow: 0 0 50px 2px rgba(1, 1, 1, 0.6); */
			box-shadow: rgba(0, 0, 0, 0.1) 0px 4px 12px;
			margin: auto;
			background-color: #f2f2f26e;
		}
		.btn-add {
			/* margin-left:32px;
			margin-top: 12px; */
			margin: 12px 12px 12px 32px;
		}
	}
	</style>
</head>
<body>
	<div class="navbar">
        <jsp:include page="NavigationBar.jsp"></jsp:include>
    </div>
    <div class="wrapper-content">
	<form action="./viewlist" method="POST" class="search-form">
		<input <% if (request.getAttribute("keysearch")!=null)  {%> value="<%= request.getAttribute("keysearch") %>"<% } %>
					type='text' name='keysearch' placeholder='Enter Text Search' class="search">
		<button type="submit" class="btn">Search</button>
	</form>
            <h4>Thông Tin Khoa</h4>
            <table width='100%'>
                <thead>
                    <tr>
                        <td>ID Faculty</th>
                        <td>Faculty Name</th>
                        <td>Update</th>
                        <td>Details</th>
                    </tr>
                </thead>
                <tbody>
                	<%
	                    ArrayList<Faculty> faculty = (ArrayList<Faculty>)request.getAttribute("faculty");
	                    for (int i=0; i<faculty.size(); i++) {
	                    %>
	                    <tr>
	                    	<td><%= faculty.get(i).getId_faculty() %></td>
	                    	<td><%= faculty.get(i).getFaculty_name() %></td>
	                    	<td><a href="./update?update=<%=faculty.get(i).getId_faculty() %>"><button type="button" class="btn">Update</button></a>
	                    	<td><a href="./details?details=<%=faculty.get(i).getId_faculty() %>"><button type="button" class="btn">Chi tiết</button></a>
	                   	</tr>
	                   	<% 
	                   	}
	                   	%>
                </tbody>
            </table>
            <a href="./add"><button class="btn btn-add">Add</button></a>
     </div>
</body>
</html>