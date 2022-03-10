<html>
	<head>
		<title>Clase36 - Inicio java web</title>
	</head>
	<body>
		<h1>Clase36</h1>
		<h2>Subtitulo</h2>
		<ul>
			<li>1</li>
			<li>2</li>
			<li>3</li>
			<li>4</li>
		</ul>
		<%	// scriplet
			// es codigo java que se compila
			// y se muestra como html
			for(int i=0; i<4; i++)	{
				out.print("i = " + i + "<br>");
			}
		%>
		<!-- POST: formulario -> NO SE VEN LOS PARAMETROS
			 GET: pasar parametros -> VEO EN LA URL LOS PARAMETROS	
		 -->
		<form action="<%=request.getContextPath()%>/listado"
			method="POST">
		<!-- con un boton adentro -->
			<input type="submit" value="Pedir listado POST"/>
		</form>

		<form action="<%=request.getContextPath()%>/listado"
			method="GET">
		<!-- con un boton adentro -->
			<input type="submit" value="Pedir listado GET"/>
		</form>
		
	</body>
</html>