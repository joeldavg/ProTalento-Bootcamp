<!DOCTYPE html>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnums"%>
<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<html lang="es">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<jsp:include page="styles.jsp"></jsp:include>
		<script type="text/javascript">
		
				async function editar(id, titulo, precio) {
				
					const options = {
						keyboard: false
					}
					
					console.log(id)
					
					// tomo el input 
					document.getElementById('idArticulo').innerHTML = id
					document.getElementById('id_articulo_actualizar').value = id
					document.getElementById('titulo').value = titulo
					document.getElementById('precio').value = precio
					
					const myModal = new bootstrap.Modal(document.getElementById('modalActualizarArticulo'), options)
					myModal.show()
				
				
			}
		</script>
		
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
						      <th scope="col">Id</th>
						      <th scope="col">Titulo</th>
						      <th scope="col">Codigo</th>
						      <th scope="col">Precio</th>
						      <th scope="col">Stock</th>
						      <th scope="col">Id Marca</th>
						      <th scope="col">Id Categoria</th>
						      <th scope="col"></th>
						    </tr>
						  </thead>
						  <tbody>
						  	 <% Collection<Articulos> articulos = (Collection<Articulos>) session.getAttribute(ViewKeysEnums.LISTADO.getParam());%>
							 <% for(Articulos articulo : articulos) { %>
							    <tr>
							      <td><%=articulo.getId() %></td>
							      <td><%=articulo.getTitulo() %></td>
							      <td><%=articulo.getCodigo() %></td>
							      <td><%=articulo.getPrecio() %></td>
							      <td><%=articulo.getStock() %></td>
							      <td><%=articulo.getMarcasId() %></td>
							      <td><%=articulo.getCategoriasId() %></td>
							      <td>
							      	<button 
							      		onclick="guardarId(<%=articulo.getId()%>)" 
							      		type="button" 
							      		class="btn btn-danger me-2" 
							      		data-bs-toggle="modal" 
							      		data-bs-target="#exampleModal">
									  Eliminar
									</button>
									<a 
										onclick="editar('<%=articulo.getId()%>', '<%=articulo.getTitulo()%>', '<%=articulo.getPrecio()%>')" 
										class="btn btn-primary"
										role="button">
										Editar
									</a>
							      </td>
							    </tr>
						   	<% } %>
						  </tbody>
						  <tfoot>
						  	<tr>
								<td colspan="3">Total:</td>
								<td colspan="4">
									<%
										Double total = (Double) session.getAttribute(ViewKeysEnums.TOTAL.getParam());
									%>
									<%=total%>
								</td>
						  	</tr>
						  </tfoot>
						</table>
					</div>
				</div>
			</div>
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title text-danger" id="exampleModalLabel">Eliminar Articulo</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			      	¿Desea eliminar el articulo?
			      </div>
			      <div class="modal-footer">
			      	<form action="<%=request.getContextPath()%>/controllers/EliminarProductoServlet" id="eliminarForm">
				        <input name="<%=ViewKeysEnums.ID_ARTICULO_ELIMINAR.getParam()%>" type="hidden" id="<%=ViewKeysEnums.ID_ARTICULO_ELIMINAR.getParam()%>" />
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
				        <button type="submit" class="btn btn-danger">Confirmar</button>
			      	</form>
			      </div>
			    </div>
			  </div>
			</div>
			<!-- Modal para actualizar articulo-->
			<div class="modal fade" id="modalActualizarArticulo" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title text-primary" id="exampleModalLabel">Actualizar Articulo</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			      	<form method="post" action="<%=request.getContextPath()%>/controllers/EditarProductoServlet" id="eliminarForm">
						  <input name="<%=ViewKeysEnums.ID_ARTICULO_ACTUALIZAR.getParam()%>" type="hidden" id="<%=ViewKeysEnums.ID_ARTICULO_ACTUALIZAR.getParam()%>" />
						  <div class="mb-3">
						    <label for="idArticulo" class="form-label" >ID</label>
<!-- 						    <input disabled type="text" name="idArticulo" class="form-control" id="idArticulo"> -->
							<span id="idArticulo"></span>
						  </div>
						  <div class="mb-3">
						    <label for="titulo" class="form-label">Titulo</label>
						    <input type="text" name="titulo" class="form-control" id="titulo">
						  </div>
						  <div class="mb-3">
						    <label for="precio" class="form-label">Precio</label>
						    <input type="number" name="precio" class="form-control" id="precio">
						  </div>
					      <div class="modal-footer">
					     	  <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
						      <button type="submit" class="btn btn-success">Confirmar</button>
					      </div>
					</form>
			      </div>
			    </div>
			  </div>
			</div>
		</main>
	  <jsp:include page="scripts.jsp"></jsp:include>
	  <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	  <script type="text/javascript" src="<%=request.getContextPath()%>/js/listadoGeneral.js"></script>
	</body>
</html>
