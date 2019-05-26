package sorteador.vistas;

import java.awt.event.ActionListener;

public interface IVista {
	void mostrarSorteado(String sorteado);
	void mostrarInfo(String mensaje);
	void mostrarError(String mensaje);
	String getRuta(); // Obtener ruta del archivo de datos
	void iniciar(); // Inicia la vista
	void addSortearListener(ActionListener al);
	void addReiniciarListener(ActionListener al);
	void addCargarListener(ActionListener al);
}
