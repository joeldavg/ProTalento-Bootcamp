<%@page import="ar.com.educacionit.web.enums.ViewKeysEnums"%>
<%@page import="ar.com.educacionit.domain.Users"%> 
<% 
	//objetos implicitos que tiene las jsp 
	Users user = (Users) session.getAttribute(ViewKeysEnums.USER.getParam());
%>
<!DOCTYPE html>
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
		   			<h1>Username: <%=user.getUsername()%> </h1>
					<h2>Nombre: <%=user.getSocio().getNombre()%> </h2>
					<h3>Apellido: <%=user.getSocio().getApellido()%> </h3>
					
					<a href="<%=request.getContextPath()%>/controllers/BuscarProductosServlet">Ver Listado</a>
	   			</div>
	   		</div>
	  	</div>
	  </main>
	 
	  <jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>
