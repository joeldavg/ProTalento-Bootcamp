package ar.com.educacionit.generic;

public interface IParser<T> {

	public T parse() throws ParseException; // uno o varios
	
	//public Collection<T> parse();
	
}
