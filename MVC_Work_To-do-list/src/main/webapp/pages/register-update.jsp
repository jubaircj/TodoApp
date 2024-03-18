<%@page import="mvc.com.bean.UserBEAN"%>
<%@page import="org.apache.catalina.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.form-group{
		font-size: 20px;
	}
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" >
</head>
<body>
	<%
		UserBEAN users = (UserBEAN) session.getAttribute("user");
	%>
	<jsp:include page="../common/header.jsp" ></jsp:include>
	<div class="container" >
		<br><h2>&emsp;&emsp;&emsp;Update Registration form</h2>
		<div class="col-md-6 col-md-offset-3" >
			<form action="<%=request.getContextPath()%>/UserController" method="post" >
				<div class="form-group" >
					First Name : <input type="text" class="form-control" name="firstname" placeholder="First Name" value="<%= users.getFirst_name() %>" >
				</div>
				<div class="form-group" >
					Last Name : <input type="text" class="form-control" name="lastname" placeholder="Last Name" value="<%= users.getLast_name() %>" >
				</div>
				<div class="form-group" >
					User Name : <input type="text" class="form-control" name="username" placeholder="User Name" value="<%= users.getUsername() %>" required >
				</div>
				<div class="form-group" >
					Password : <input type="password" class="form-control" name="password" placeholder="Password" value="<%= users.getPassword() %>" required minlength="6" >
				</div>
				&emsp;
				<button type="reset" class="btn btn-primary" >Reset</button>&emsp;&emsp;
				<button type="submit" class="btn btn-primary" >Submit</button>
				<input type="hidden" name="action" value="update" >
				<input type="hidden" name="id" value="<%= users.getId() %>" >
			</form>
		</div>
		<div>
			<img alt="ToDoListImage" src="<%=request.getContextPath() + "/images/register-update.jpg"%>" style="width: 500px; height: 420px; margin-left: 635px; margin-top: -420px; border-radius: 7px; ">
		</div>
	</div>
	<jsp:include page="../common/footer.jsp" ></jsp:include>
</body>
</html>