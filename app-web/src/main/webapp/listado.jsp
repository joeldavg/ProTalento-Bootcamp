<%@page import="org.apache.commons.collections4.bag.SynchronizedSortedBag"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.List"%>

<html>
	<head>
	
	</head>
	<body>
		<!-- quiero capturar el listado que envio el servlet bajo el nombre LISTADO -->
	
		<% // SCRIPTLET -> PERMITE ESCRIBIR CODIGO JAVA
			// dentro de las jsp tengo un "objeto implicito" llamado request
			
			//primero
			Object listadoObject = request.getAttribute("LISTADO");
			// puedo castear de Object a List<Articulos>
			List<Articulos> listado = (List<Articulos>) listadoObject;
		%>
		
		<%
			// recorrer el listado e ir el html
			for(Articulos art : listado) {
				
		%>
			<!-- puedo poner html puro y usar el objecto art -->
			<p><%=art.getCodigo() %></p>
		<%
			}
		%>
		
	</body>
</html>