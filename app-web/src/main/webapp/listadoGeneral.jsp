<!DOCTYPE html>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnums"%>
<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
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
				<div class="row">
					<div class="col-sm-12 col-md-4 col-lg-3">
						<form>
						  <div class="mb-3">
						    <label for="exampleInputEmail1" class="form-label">Email address</label>
						    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
						  </div>
						  <div class="mb-3">
						    <label for="exampleInputPassword1" class="form-label">Password</label>
						    <input type="password" class="form-control" id="exampleInputPassword1">
						  </div>
						  <button type="submit" class="btn btn-primary">Filtrar</button>
						</form>
					</div>
					<div class="col">
			 			<jsp:include page="mensajeria.jsp"></jsp:include>
			 			<h2 class="text-primary">Listado de Articulos</h2>
			 			<table class="table table-striped table-hover">
						  <thead>
						    <tr>
						      <th scope="col">Titulo</th>
						      <th scope="col">Codigo</th>
						      <th scope="col">Precio</th>
						      <th scope="col">Stock</th>
						      <th scope="col">Id Marca</th>
						      <th scope="col">Id Categoria</th>
						    </tr>
						  </thead>
						  <tbody>
						  	 <% Collection<Articulos> articulos = (Collection<Articulos>) request.getAttribute(ViewKeysEnums.LISTADO.getParam());%>
							 <% for(Articulos articulo : articulos) { %>
							    <tr>
							      <td><%=articulo.getTitulo() %></td>
							      <td><%=articulo.getCodigo() %></td>
							      <td><%=articulo.getPrecio() %></td>
							      <td><%=articulo.getStock() %></td>
							      <td><%=articulo.getMarcasId() %></td>
							      <td><%=articulo.getCategoriasId() %></td>
							    </tr>
						   	<% } %>
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</main>
	  <jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>
