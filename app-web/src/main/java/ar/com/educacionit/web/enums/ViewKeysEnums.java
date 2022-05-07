package ar.com.educacionit.web.enums;

public enum ViewKeysEnums {

	USERNAME("username"),
	PASSWORD("password"),
	ERROR_GENERAL("error"),
	USUARIO_PASSWORD_INVALIDO("usuario/password incorrectos"), 
	USER("user"),
	UPLOAD_FILE("uploadfile");
	
	private String param;

	private ViewKeysEnums(String param) {
		this.param = param;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
}
