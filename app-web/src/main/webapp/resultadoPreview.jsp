<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
	
		<main>
		 	<div class="container">
				<div class="row d-flex justify-content-center">
		 			<jsp:include page="mensajeria.jsp"></jsp:include>
					<jsp:include page="./components/tablaArticulosPreviewResultados.jsp"></jsp:include>
		 		</div>
			</div>
		</main>
	  <jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>
