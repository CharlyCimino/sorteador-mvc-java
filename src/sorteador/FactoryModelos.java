package sorteador;

import sorteador.modelo.IModelo;
import sorteador.modelo.modeloarchivos.ModeloArchivos;
import sorteador.modelo.modelobbdd.ModeloBBDD;

public class FactoryModelos {
	private FactoryModelos() {}
	
	public static IModelo getModelo (String tipo) {
		switch (tipo) {
			case "Archivos":
				return new ModeloArchivos(); 
			case "BBDD":
				return new ModeloBBDD();
			default:
				return null;
		}
	}
}
