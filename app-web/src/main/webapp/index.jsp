<html>
	<head>
		<title>Clase36 - Inicio java web</title>
	</head>
	<body>
		<h1>Clase36</h1>
		
		<!-- POST: formulario -> NO SE VEN LOS PARAMETROS
			 GET: pasar parametros -> VEO EN LA URL LOS PARAMETROS	
		 -->
		<form action="<%=request.getContextPath()%>/ListadoServlet"
			method="POST">
		<!-- con un boton adentro -->
			<input type="submit" value="Pedir listado POST"/>
		</form>

		<form action="<%=request.getContextPath()%>/ListadoServlet"
			method="GET">
		<!-- con un boton adentro -->
			<input type="submit" value="Pedir listado GET"/>
		</form>
		<img src="<%=request.getContextPath()%>/img/Bart_Simpson.webp"/>

	</body>
</html>