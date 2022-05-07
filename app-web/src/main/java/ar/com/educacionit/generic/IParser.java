package ar.com.educacionit.generic;

import java.io.IOException;

public interface IParser<T> {

	public T parse() throws ParseException, IOException; // uno o varios
	
	//public Collection<T> parse();
	
}
