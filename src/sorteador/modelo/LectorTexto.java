package sorteador.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

public class LectorTexto {

    private FileReader fr;
    private BufferedReader br;

    /**
     * Construye un lector de archivos de texto.
     *
     * @param ruta La ruta hacia el archivo de texto.
     * @throws FileNotFoundException Si no se encuentra el archivo.
     */
    public LectorTexto(String ruta) throws FileNotFoundException {
        this.fr = new FileReader(new File(ruta));
        this.br = new BufferedReader(this.fr);
    }

    /**
     * Retorna una coleccción de cadenas, una por cada salto de línea, obtenidas del archivo de texto.
     *
     * @return Una coleccción de cadenas, obtenidas del archivo de texto.
     * @throws IOException Si ocurre un error en el proceso de lectura.
     */
    public Collection<String> leerLineas() throws IOException {
        Collection<String> lines = new LinkedList<>();
        String cadena = leerLinea();
        while (cadena != null) {
            lines.add(cadena);
            cadena = leerLinea();
        }
        cerrarArchivo();
        return lines;
    }

    /**
     * Retorna la siguiente cadena del archivo de texto.
     *
     * @return Una coleccción de cadenas, obtenidas del archivo de texto.
     * @throws IOException Si ocurre un error en el proceso de lectura.
     */
    public String leerLinea() throws IOException {
        return this.br.readLine();
    }

    private void cerrarArchivo() throws IOException {
        this.fr.close();
    }
}
