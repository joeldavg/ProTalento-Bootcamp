<%@page import="ar.com.educacionit.web.enums.ViewKeysEnums"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.Collection"%>
<%
	Collection<Articulos> articulos = (Collection<Articulos>) session.getAttribute(ViewKeysEnums.UPLOAD_PREVIEW_KEY.getParam());
%>
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
  <% if(articulos != null || articulos.isEmpty() ) { 
	  for(Articulos articulo : articulos) { %>
	    <tr>
	      <td><%=articulo.getTitulo() %></td>
	      <td><%=articulo.getCodigo() %></td>
	      <td><%=articulo.getPrecio() %></td>
	      <td><%=articulo.getStock() %></td>
	      <td><%=articulo.getMarcasId() %></td>
	      <td><%=articulo.getCategoriasId() %></td>
	    </tr>
   	<% } 
	}%>
  </tbody>
</table>