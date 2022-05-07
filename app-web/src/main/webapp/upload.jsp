<!-- HTML5 -->
<!DOCTYPE html>
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
	   			<h1>Cargar Archivo</h1>
	   			<div class="col-6">
	   				<form action="<%=request.getContextPath()%>/UploadFileServlet" method="post" enctype="multipart/formdata">
			   			<div class="mb-3">
						  <label for="formFile" class="form-label">Cargar Archivo</label>
						  <input class="form-control" name="<%=ViewKeysEnums.UPLOAD_FILE.getParam()%>" type="file" id="formFile">
						</div>
						<button type="submit" class="btn btn-primary">Cargar Archivo</button>
	   				</form>
	   			</div>
	   		</div>
	  	</div>
	  </main>
	 
	  <jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>
