package collections;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MainCollection3 {
	
	public static void main(String[] args) {
		
		LinkedList<String> nombres = new LinkedList<String>();
		
		nombres.add("edwin");
		nombres.add("luisa");
		nombres.add("carlos");
		nombres.add("juan");
		
		
		ListIterator<String> li = nombres.listIterator();
		
		while (li.hasNext()) {
			String current = li.next();
			System.out.println(current);
		}
		
		System.out.println();
		while (li.hasPrevious()) {
			String current = li.previous();
			System.out.println(current);
		}
		
		
	}
}
