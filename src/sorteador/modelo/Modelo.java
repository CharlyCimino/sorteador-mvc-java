package sorteador.modelo;

import java.io.IOException;
import java.util.Collection;

public class Modelo {

    private Sorteador<String> s;
    private String ruta;

    public Modelo() {
        this.s = new Sorteador<>();
    }

    public String proximoSorteado() {
        return s.remove();
    }

    public void cargarSorteador(String ruta) throws IOException {
        this.ruta = ruta;
        LectorTexto lt = new LectorTexto(this.ruta);
        Collection<String> lineas = lt.leerLineas();
        for (String linea : lineas) {
            s.add(linea);
        }        
    }

    public void reiniciar() throws IOException {
        cargarSorteador(this.ruta);
    }
}
