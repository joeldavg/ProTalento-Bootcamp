package javaParaNoProgramadores;

public class Laboratorio2Modulo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean variableA, variableB, variableC, res1, res2;
		
		variableA = true;
		variableB = true;
		variableC = true;
		
		System.out.println("variableA: " + variableA);
		System.out.println("variableB: " + variableB);
		System.out.println("variableC: " + variableC);
		
		res1 = (variableA && variableB) || (variableA && variableC);
		res2 = !(variableA || variableB) && variableC;
		
		System.out.println();
		System.out.println("(variableA && variableB) || (variableA && variableC) = " + res1);
		System.out.println("!(variableA || variableB) && variableC = " + res2);

	}

}
