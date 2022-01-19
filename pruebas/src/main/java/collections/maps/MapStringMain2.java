package collections.maps;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapStringMain2 {

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
		
		//Obtengo map
		
		String diaStr = dias.get(9);
		
		System.out.println(dias);
		
		//obtener todas las claves de un mapa
		
		Set<Integer> keySet = dias.keySet();
		
		for (Integer key : keySet) {
			String value = dias.get(key);
			System.out.println(key +"-"+value);
		}
		
		//recorrer solo los valores
		Collection<String> values = dias.values();
		
		for (String value : values) {
			System.out.println(value + "-" + dias.containsValue(value));
		}
		
		//EntrySet
		
		Set<Map.Entry<Integer, String>> entrySet = dias.entrySet();
		for (Map.Entry<Integer, String> entry : entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println(entry);
		}
		
	}

}
