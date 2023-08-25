package sorteador;

import sorteador.vista.IVista;
import sorteador.vista.vistaconsola.VistaConsola;
import sorteador.vista.vistaswing.VistaSwing;

public class FactoryVistas {

    private FactoryVistas() {
    }

    public static IVista getVista(String tipo) {
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
