
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnums"%>
<%
	// si existe alguien 
	String error = (String) request.getAttribute(ViewKeysEnums.ERROR_GENERAL.getParam());
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

	