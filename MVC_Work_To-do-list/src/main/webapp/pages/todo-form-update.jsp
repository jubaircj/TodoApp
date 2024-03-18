<%@page import="mvc.com.bean.todosBEAN"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous" >
 <style>
 	.card-body img{
 		margin-left: 270px;
 		margin-top: -460px;
 		height : 350px;
 		width : 240px;
 		border-radius: 6px;
 	}
 </style>
</head>
<body>
	<%
		todosBEAN todos = (todosBEAN) session.getAttribute("user");
	%>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato" >
			<div>
				<a class="navbar-brand" >Todo App</a>
			</div>
			
			<ul class="navbar-nav" >
				<li><a href="<%= request.getContextPath() %>/pages/todo-list.jsp" class="nav-link" >Todos</a></li>
			</ul>
			
			<ul class="navbar-nav navbar-collapse justify-content-end" >
				<li><a href="<%= request.getContextPath() %>/pages/register.jsp" class="nav-link" >Logout</a></li>
			</ul>
		</nav>
	</header>
	<div class="container col-md-5" >
		<div class="card" >
			<div class="card-body" >
				<form action="<%=request.getContextPath()%>/todosController" method="post" >
					<h2>&emsp;&emsp;Edit Todo</h2><br>
					<fieldset class="form-group" >
						<label><b>Todo Title : </b></label><br><input type="text" name="title" value="<%= todos.getTitle() %>" class="form-controll"required style="height:35px; width:260px;" >
					</fieldset>
					<fieldset class="form-group" >
						<b>Todo Description : </b><br><input type="text" name="description" value="<%= todos.getDescription() %>" class="form-controll" minlength="5" style="height:35px; width:260px;" >
					</fieldset>
					<fieldset class="form-group" >
						<b>Todo Status : </b><br><select class="form-controll" name="status" style="height:35px; width:260px;">
												<option>Select an option</option>
												<option value="Completed" <%= todos.getStatus().equals("Completed") ? "selected" : "" %> >Completed</option>
												<option value="In Progress" <%= todos.getStatus().equals("In Progress") ? "selected" : "" %> >In Progress</option>
									      </select>
					</fieldset>
					<fieldset class="form-group" >
						<b>Todo Target Date : </b><br><input type="date" name="target_date" value="<%= todos.getTarget_date() %>" class="form-controll" required style="height:35px; width:260px;" >
					</fieldset>
					
					<button type="reset" class="btn btn-success" >Reset</button>&emsp;&emsp;
					<button type="submit" class="btn btn-success" >Update</button>
					<input type="hidden" name="action" value="update" >
					<input type="hidden" name="id" value="<%= todos.getId() %>" >
					<img alt="image" src="<%=request.getContextPath() + "/images/todo-update.jpg"%>">
				</form>
			</div>
		</div>
	</div>	
	<jsp:include page="../common/footer.jsp" ></jsp:include>
	
</body>
</html>