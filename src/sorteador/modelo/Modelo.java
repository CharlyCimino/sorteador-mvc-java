package sorteador.modelo;

import java.io.IOException;
import sorteador.modelo.Sorteador;

public class Modelo {

    private Sorteador<String> s;

    public Modelo() {
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
