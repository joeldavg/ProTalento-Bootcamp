
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnums"%>
<%
	// si existe alguien 
	String error = (String) request.getAttribute(ViewKeysEnums.ERROR_GENERAL.getParam());
	String exito = (String) request.getAttribute(ViewKeysEnums.EXITO.getParam());
%>

<%
	if(error != null) {
%>		
		<div class="alert alert-danger" role="alert">
			<%=error %>
		</div>	
<%
	}
%>

<%
	if(exito != null) {
%>		
		<div class="alert alert-success" role="alert">
			<%=exito %>
		</div>	
<%
	}
%>

	