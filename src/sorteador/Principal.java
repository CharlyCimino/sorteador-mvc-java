package sorteador;

import javax.swing.JOptionPane;

import sorteador.modelo.IModelo;
import sorteador.modelo.modeloarchivos.ModeloArchivos;
import sorteador.vistas.IVista;
import sorteador.vistas.vistaconsola.VistaConsola;
import sorteador.vistas.vistaswing.VistaSwing;

public class Principal {

	public static void main(String[] args) {
		// Selector del modelo
		String[] modelos = {"Archivos","BBDD"};
		String modelStr = (String) JOptionPane.showInputDialog(null, "¿Qué modelo?", "Titulo", 3, null, modelos, modelos[0]);
		IModelo model = FactoryModelos.getModelo(modelStr);
		
		// Selector de la vista
		String[] vistas = {"Swing","Consola"};
		String viewStr = (String) JOptionPane.showInputDialog(null, "¿Qué vista?", "Titulo", 3, null, vistas, vistas[0]);
		IVista view = FactoryVistas.getVista(viewStr);
		
		Controlador c = new Controlador(view,model);
		c.iniciar();
	}

}
