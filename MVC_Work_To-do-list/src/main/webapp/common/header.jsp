<header>
	<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato" >
		<div>
			<a class="navbar-brand" >Todo App</a>
		</div>
		
		<ul class="navbar-nav navbar-collapse justify-content-end" >
			<li><a href="<%= request.getContextPath() %>/pages/login.jsp" class="nav-link" style="color : white" >Login</a></li>
			<li><a href="<%= request.getContextPath() %>/pages/register.jsp" class="nav-link" style="color : white" >Sign up</a></li>
		</ul>
	</nav>
</header>