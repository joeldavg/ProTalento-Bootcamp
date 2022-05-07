<!-- HTML5 -->
<!DOCTYPE html>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnums"%>
<html lang="es">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	
	<body>
	  <header>
	  	<jsp:include page="navbar.jsp"></jsp:include>
	  </header>
	
	  <main>
	   	<div class="container">
	   		<jsp:include page="mensajeria.jsp"></jsp:include>
	   		<div class="row d-flex justify-content-center">
	   			<h1>Preview de Archivo a procesar</h1>
	   			<%
	   				Collection<Articulos> articulos = (Collection<Articulos>) request.getAttribute(ViewKeysEnums.UPLOAD_PREVIEW_KEY.getParam());
	   				out.print(articulos);
	   			%>
	   			
	   		</div>
	  	</div>
	  </main>
	 
	  <jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>
