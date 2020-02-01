package sorteador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sorteador.modelo.modeloarchivos.ModeloArchivos;
import sorteador.vistas.IVista;

public class Controlador {

    private IVista v;
    private ModeloArchivos m;

    public Controlador(IVista v, ModeloArchivos m) {
        this.v = v;
        this.m = m;
    }

    public void iniciar() {
        // Posible ruta: C:\Users\caemci\Desktop\equipos.txt
        cargarListenersEnVista(); // Carga listeners en la vista
        v.iniciar(); // Inicia la vista
    }

    private void cargarListenersEnVista() {
        v.addSortearListener(new SortearListener()); // Agrega listener para evento 'Sortear'
        v.addReiniciarListener(new ReiniciarListener()); // Agrega listener para evento 'Reiniciar'
        v.addCargarListener(new CargarListener()); // Agrega listener para evento 'Cargar'
    }

    private void cargarSorteador() {
        try {
            // Carga el sorteador con los datos extraídos de la ruta obtenida a través de la vista
            m.cargarSorteador(v.getRuta());
        } catch (Exception e) {
            v.mostrarError(e.getMessage());
        }
    }

    private void sortear() {
        try {
            // Muestra la cadena sorteada obtenida a través del modelo
            v.mostrarSorteado(m.proximoSorteado());
        } catch (Exception e) {
            v.mostrarError(e.getMessage());
        }
    }

    private void reiniciar() {
        try {
            m.reiniciar(); // Vuelve a cargar el sorteador con los elementos originales
            v.mostrarInfo("Se ha reiniciado el sorteo"); // Muestra info al usuario
        } catch (Exception e) {
            v.mostrarError(e.getMessage());
        }
    }

    /////////////////////////////// LISTENERS //////////////////////////////////////////
    private class SortearListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            sortear();
        }
    }

    private class ReiniciarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            reiniciar();
        }
    }

    private class CargarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cargarSorteador();
        }
    }
}
