package sorteador.vista.vistaconsola;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sorteador.vista.IVista;

public class VistaConsola implements IVista {
	
	private String ruta;
	private ActionListener alSortear;
	private ActionListener alReiniciar;
	private ActionListener alCargar;
	private ActionEvent evtSortear;
	private ActionEvent evtReiniciar;
	private ActionEvent evtCargar;
	
	@Override
	public void mostrarSorteado(String sorteado) {
		System.out.println("Salió: " + sorteado);
	}

	@Override
	public void mostrarError(String mensaje) {
		System.out.println("***ERROR: " + mensaje + "***");
	}
	
	@Override
	public void mostrarInfo(String mensaje) {
		System.out.println("***INFO: " + mensaje + "***");
	}

	@Override
	public String getRuta() {
		return this.ruta;
	}

	@Override
	public void iniciar() {
		char opc;
		System.out.println("Bienvenid@ al sorteador");
		this.ruta = Consola.leerCadena("Ruta al archivo de datos");
		cargar();
		do { // Este ciclo controla el fin del programa
			do { // Este ciclo valida que sea una opcion correcta
				System.out.println("[1] Sortear");
				System.out.println("[2] Reiniciar");
				System.out.println("[3] Terminar");
				opc = Consola.leerCaracter("");
			} while(opc != '1' && opc != '2' && opc != '3');
			if (opc == '1') { sortear(); }
			else if (opc == '2') { reiniciar(); }
		} while(opc != '3');	
	}		
	
	private void cargar () {
		this.alCargar.actionPerformed(evtCargar);
	}
	
	private void sortear () {
		this.alSortear.actionPerformed(evtSortear);
	}
	
	private void reiniciar () {
		this.alReiniciar.actionPerformed(evtReiniciar);
	}
	
	@Override
	public void addSortearListener(ActionListener al) {
		this.alSortear = al;
		this.evtSortear = new ActionEvent(this, 0, "Sortear");
	}
	
	@Override
	public void addReiniciarListener(ActionListener al) {
		this.alReiniciar = al;
		this.evtReiniciar = new ActionEvent(this, 1, "Reiniciar");
	}

	@Override
	public void addCargarListener(ActionListener al) {
		this.alCargar = al;
		this.evtCargar = new ActionEvent(this, 2, "Cargar");
	}
}
