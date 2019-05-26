package sorteador;

import sorteador.vistas.IVista;
import sorteador.vistas.vistaconsola.VistaConsola;
import sorteador.vistas.vistaswing.VistaSwing;

public class FactoryVistas {
	private FactoryVistas() {}
	
	public static IVista getVista (String tipo) {
		switch (tipo) {
			case "Swing":
				return new VistaSwing(); 
			case "Consola":
				return new VistaConsola();
			default:
				return null;
		}
	}
}
