<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="mvc.com.bean.todosBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management Application</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous" >
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato" >
			<div>
				<a class="navbar-brand" >Todo App</a>
			</div>
			
			<ul class="navbar-nav" >
				<li><a href="<%= request.getContextPath() %>/pages/todo-list.jsp" class="nav-link" >Todos</a></li>
			</ul>
			
			<ul class="navbar-nav navbar-collapse justify-content-end" >
				<li><a href="<%= request.getContextPath() %>/pages/login.jsp" class="nav-link" >Logout</a></li>
			</ul>
		</nav>
	</header>
	
	<div class="row" >
		<div class="container" >
				<div>
					<div class="container text-left" style="margin-top: 5px" >
						<a href="<%= request.getContextPath() %>/pages/todo-form-insert.jsp" class="btn btn-success" >Add Todo</a>
					</div>
					<div style="margin-top: -36px" >
						<h2 class="text-center" >List of Todos</h2>
					</div>
					<div class="container text-left" style="margin-top: -48px; margin-left: 980px;" >
						<a href="<%= request.getContextPath() %>/pages/login-users.jsp" class="btn btn-success" >View Users</a>
					</div>
				</div>
				<hr>
				<table class="table table-bordered" style="width: 100%;" >
					<thead>
						<tr>
							<th>Title</th>
							<th>Description</th>
							<th>Todo Status</th>
							<th>Target Date</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
					        ArrayList<todosBEAN> todosList = (ArrayList<todosBEAN>) session.getAttribute("user");
        					if (todosList != null && !todosList.isEmpty()) {
            					for (todosBEAN rs : todosList) {
    					%>
					    <tr>
        					<td><%= rs.getTitle() %></td>
        					<td><%= rs.getDescription() %></td>
        					<td><%= rs.getStatus() %></td>
        					<td><%= rs.getTarget_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) %></td>
        					<td>
        						<form action="<%= request.getContextPath() %>/todosController" method="post" >
        							<button type="submit" class="btn btn-success" >Update</button>
        							<input type="hidden" name="id" value="<%= rs.getId() %>" >
        							<input type="hidden" name="action" value="edit" >	
        						</form>
        						<form action="<%= request.getContextPath() %>/todosController" method="post" style="margin-left: 85px; margin-top: -38px;" >
        							<button type="submit" class="btn btn-warning" style="width: 78px;" >Delete</button>
        							<input type="hidden" name="id" value="<%= rs.getId() %>" >
        							<input type="hidden" name="action" value="delete" >	
        						</form>
        					</td>
    					</tr>
					    <%
 					           	}
       						} else {
   						%>
					    <tr>
        					<td colspan="5">No todos found.</td>
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