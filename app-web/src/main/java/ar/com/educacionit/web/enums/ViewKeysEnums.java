package ar.com.educacionit.web.enums;

public enum ViewKeysEnums {

	USERNAME("username"),
	PASSWORD("password"),
	ERROR_GENERAL("error"),
	USUARIO_PASSWORD_INVALIDO("usuario/password incorrectos"), 
	USER("user"),
	UPLOAD_FILE("uploadfile"),
	UPLOAD_PREVIEW_KEY("upload_preview_key"), 
	ARTICULOS_FAILS("articulos_fails"), 
	ARTICULOS_OKS("articulos_oks"), 
	FORMATO("formato"),
	LISTADO("listado"), 
	CLAVE_BUSQUEDA("clave_busqueda");
	
	private String param;

	private ViewKeysEnums(String param) {
		this.param = param;
	}

	public String getParam() {
		return param;
	}

}
