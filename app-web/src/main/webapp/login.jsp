<!-- HTML5 -->
<!DOCTYPE html>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnums"%>
<html lang="es">
	<head>
		<!-- CSS ONLY -->
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	
	<body>
	  	<jsp:include page="navbar.jsp"></jsp:include>
	
	  <main>
	   	<div class="container">
	   		<!-- Mostrar mensajeria	 -->
	   		<jsp:include page="mensajeria.jsp"></jsp:include>
	   		<div class="row d-flex justify-content-center">
	   			<div class="col-6">
		   			<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
					  <div class="mb-3">
					    <label for="exampleInputEmail1" class="form-label">Username</label>
					    <input type="text" name="<%=ViewKeysEnums.USERNAME.getParam()%>" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
					  </div>
					  <div class="mb-3">
					    <label for="exampleInputPassword1" class="form-label">Password</label>
					    <input type="password" name="<%=ViewKeysEnums.PASSWORD.getParam()%>" class="form-control" id="exampleInputPassword1">
					  </div>
					  <button type="submit" class="btn btn-primary">Login</button>
					</form>
	   			</div>
	   		</div>
	  	</div>
	  </main>
	 
	  <jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>
