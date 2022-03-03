package ar.com.educacionit.generic;

public abstract class BaseFile {
	
	private String path;

	public BaseFile(String path) {
		if (path == null) {
			throw new IllegalArgumentException("Debe indicar un path de archivo");
		}
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	
}
