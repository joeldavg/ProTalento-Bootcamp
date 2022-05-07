package ar.com.educacionit.generic;

import javax.servlet.http.Part;

public abstract class BaseFile {
	
	protected String filePath;
	
	protected Part filePart;

	public BaseFile(String filePath) {
		if (filePath == null) {
			throw new IllegalArgumentException("Debe indicar un path de archivo");
		}
		this.filePath = filePath;
	}

	
	public BaseFile(Part filePart) {
		if (filePart == null) {
			throw new IllegalArgumentException("Debe ingresar un Part valido");
		}
		this.filePart = filePart;
	}

	public String getFilePath() {
		return filePath;
	}


	public Part getFilePart() {
		return filePart;
	}
	
}
