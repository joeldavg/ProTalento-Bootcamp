package ar.com.educacionit.web.enums;

public enum LoginViewEnum {

	USERNAME("username"),
	PASSWORD("password");
	
	private String param;

	private LoginViewEnum(String param) {
		this.param = param;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
}
