package sorteador;

import javax.swing.JOptionPane;
import sorteador.modelo.modeloarchivos.ModeloArchivos;
import sorteador.vistas.IVista;

public class Principal {

    public static void main(String[] args) {

        ModeloArchivos model = new ModeloArchivos();

        // Selector de la vista
        String[] vistas = {"Swing", "Consola"};
        String viewStr = (String) JOptionPane.showInputDialog(null, "¿Qué tipo de vista deseás visualizar?", "Selector de vista", 3, null, vistas, vistas[0]);
        IVista view = FactoryVistas.getVista(viewStr);

        Controlador c = new Controlador(view, model);
        c.iniciar();
    }

}
