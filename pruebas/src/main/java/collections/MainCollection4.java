package collections;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class MainCollection4 {
	
	public static void main(String[] args) {
		
		Set<Cliente> clientes = new HashSet<Cliente>();
		
		clientes.add(new Cliente("joel", "12345"));
		clientes.add(new Cliente("joel", "1234"));
		
		System.out.println(clientes);
	}
}
