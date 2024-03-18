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
	<jsp:include page="../common/header.jsp" ></jsp:include>
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto;" >
		<br>
		<h1>Login form</h1><br>
		<form action="<%= request.getContextPath() %>/UserController" method="post" >
			<div class="form-group" >
				User Name : <input type="text" name="loginusername" class="form-control" placeholder="User Name" required style="width: 350px;" >
			</div>
			<div class="form-group" >
				Password : <input type= "password" name="loginpassword" class="form-control" placeholder="Password" required style="width: 350px;" >
			</div>
			<br>&emsp;
			<button type="reset" class="btn btn-primary" >Reset</button>&emsp;&emsp;
			<button type="submit" class="btn btn-primary" >Submit</button>
			<input type="hidden" name="action" value="login" >
		</form>
	</div>
	<div>
			<img alt="ToDoListImage" src="<%=request.getContextPath() + "/images/todo-background.jpg"%>" style="width: 500px; height: 400px; margin-left: 600px; margin-top: -300px; ">
	</div>
	<jsp:include page="../common/footer.jsp" ></jsp:include>
</body>
</html>