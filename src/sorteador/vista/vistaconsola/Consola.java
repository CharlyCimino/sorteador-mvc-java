package sorteador.vista.vistaconsola;

import java.util.Scanner;

public final class Consola {
	private static Scanner sc = new Scanner(System.in);
	
	private Consola () {} // Evita que se creen instancias de Consola
	
	/**
     * Devuelve un caracter leído desde la consola. Si se inserta más de un caracter, se devuelve el primero
     * @param mensaje El mensaje con indicaciones al usuario a mostrar en la consola
     * @return letra El caracter leído
     */
	public static char leerCaracter(String mensaje) { 
		String cad = leerCadena(mensaje);
		return cad.charAt(0);
	}
	
	/**
     * Devuelve una cadena leída desde la consola.
     * @param mensaje El mensaje con indicaciones al usuario a mostrar en la consola
     * @return cadena La cadena leída
     */
	public static String leerCadena(String mensaje) {
		String comp = mensaje.isEmpty() ? "> " : " > ";
		System.out.print(mensaje + comp);
		String cad = sc.nextLine();
		while (cad.isEmpty()) {
			System.out.print("ERROR. " + mensaje + comp);
			cad = sc.nextLine();
		}
		return cad;
	}
}
