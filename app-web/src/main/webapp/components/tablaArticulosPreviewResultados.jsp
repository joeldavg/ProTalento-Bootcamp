<%@page import="ar.com.educacionit.web.enums.ViewKeysEnums"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.Collection"%>
<%
	Collection<Articulos> articulosOk = (Collection<Articulos>) request.getAttribute(ViewKeysEnums.ARTICULOS_OKS.getParam());
	Collection<Articulos> articulosFail = (Collection<Articulos>) session.getAttribute(ViewKeysEnums.ARTICULOS_FAILS.getParam());
%>

 <% if(articulosOk != null && !articulosOk.isEmpty() ) {%>
<h2 class="text-success">Articulos Procesados</h2>
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
  <% for(Articulos articulo : articulosOk) { %>
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
   	<% }%>

 <% if(articulosFail != null && !articulosFail.isEmpty() ) {%>
<h2 class="text-danger">Articulos No Procesados</h2>
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
  <% for(Articulos articulo : articulosFail) { %>
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
   	<% }%>

<div class="col">
	<div class="input-group mb-3">
		<form action="<%=request.getContextPath()%>/controllers/GenerarArchivoErrorServlet" 
			method="POST" target="_new">
			<div class="input-group mb-3">
				<select name="formato" class="form-select" aria-label="Default select example">
				  <option value="csv" selected>CSV</option>
				  <option value="xls">XSL</option>
				  <option value="pdf">PDF</option>
				</select>
				<button class="btn btn-primary">
					Generar Archivo de Errores
				</button>
			</div>
		</form>
	</div>
</div>
