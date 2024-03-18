<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mvc.com.bean.UserBEAN"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management Application</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous" >
 <style type="text/css" >
 	.btn-danger{
 		width : 75px;
 		margin-left: 80px;
 		margin-top: -63px;
 		height: 35px;
 	}
 	.btn-info{
 		width : 75px;
 		height: 35px;
 	}
 	.navbar-head{
 		text-align: center;
 		width: 1125px;
 	}
 </style>
</head>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato" >
			<div>
				<a class="navbar-brand" >Todo App</a>
			</div>
			<div class="navbar-head" >
					<h3 class="text-center" >List of Users</h3>
			</div>			
			<ul class="navbar-nav navbar-collapse justify-content-end" >
				<li><a href="<%= request.getContextPath() %>/pages/login.jsp" class="nav-link" >Logout</a></li>
			</ul>
		</nav>
	</header>
	
	<div class="row" >x
		<div class="container" >
		<br>
				<table class="table table-bordered" style="width: 100%; background-color: #f5f5f5;" >
					<thead>
						<tr>
							<th>Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>User name</th>
							<th>Password</th>
							<th style="width:220px;" >Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<UserBEAN> userList = (ArrayList<UserBEAN>) session.getAttribute("user");
							for(UserBEAN rs : userList){
						%>
					    <tr>
        					<td><%= rs.getId() %></td>
        					<td><%= rs.getFirst_name() %></td>
        					<td><%= rs.getLast_name() %></td>
        					<td><%= rs.getUsername() %></td>
        					<td><%= rs.getPassword() %></td>
        					<td>
        						<form action="<%= request.getContextPath() %>/UserController" method="post" >
        							<button type="submit" class="btn btn-info" >update</button>
        							<input type="hidden" name="id" value="<%= rs.getId() %>" >
        							<input type="hidden" name="action" value="edit" >
        						</form>
        						<form action="<%= request.getContextPath() %>/UserController" method="post" style="height:1px; width:100px; " >
        							<button type="submit" class="btn btn-danger" style="width:75px;" >delete</button>
        							<input type="hidden" name="id" value="<%= rs.getId() %>" >
        							<input type="hidden" name="action" value="delete" >
        						</form>
        					</td>
    					</tr>
    					<%
							}
        				%>
					</tbody>
				</table>
		</div>
	</div>
	<div>
		<p></p>
	</div>
	<jsp:include page="../common/footer.jsp" ></jsp:include>
</body>
</html>