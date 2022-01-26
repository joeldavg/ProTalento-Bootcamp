package collections.maps;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MapEntryMain {

	public static void main(String[] args) {
		
		Map<Integer, String> dias = new HashMap<>();
		
		//agreagar elementos put(k, v) -> put(Integer, String)
		
		dias.put(1,  "Lunes");
		dias.put(2,  "Martes");
		dias.put(3,  "Miercoles");
		dias.put(4,  "Jueves");
		dias.put(5,  "Viernes");
		dias.put(6,  "Sabado");
		dias.put(7,  "Domingo");
		
		dias.keySet();
		dias.values();
		
		Set<Entry<Integer, String>> entries = dias.entrySet();
		
		/*for (Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}*/

		Iterator<Entry<Integer, String>> itEntries = entries.iterator();
		Entry<Integer, String > entry = null;
		while (itEntries.hasNext()) {
			entry = itEntries.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println(entry);
		System.out.println(itEntries.hasNext());
		itEntries = entries.iterator();
		System.out.println(itEntries.hasNext());
		
	}

}
