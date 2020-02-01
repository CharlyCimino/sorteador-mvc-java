package sorteador.modelo.modeloarchivos;

import java.io.IOException;
import sorteador.modelo.Sorteador;

public class ModeloArchivos {

    private Sorteador<String> s;

    public ModeloArchivos() {
        this.s = new Sorteador<>();
    }

    public String proximoSorteado() {
        return s.proximoSorteado();
    }

    public void cargarSorteador(String ruta) throws IOException {
        LectorTexto lt = new LectorTexto(ruta);
        s.insertar(lt.leerLineas());
    }

    public void reiniciar() {
        this.s.reiniciar();
    }
}
