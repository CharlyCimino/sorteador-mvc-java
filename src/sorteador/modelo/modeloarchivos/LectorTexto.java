package sorteador.modelo.modeloarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorTexto {
	private FileReader archivoLectura;
	private BufferedReader bufferDeEntrada;

	public LectorTexto(String path) throws FileNotFoundException {
		prepararLectura(path);
	}

	private void prepararLectura(String ruta) throws FileNotFoundException {
		this.archivoLectura = new FileReader(new File(ruta));
		bufferDeEntrada = new BufferedReader(this.archivoLectura);
	}

	private String leerLinea() throws IOException {
		String linea = bufferDeEntrada.readLine();
		return linea;
	}
	
	public ArrayList<String> leerLineas() throws IOException {
		ArrayList<String> lines = new ArrayList<String>();
		String cadena = leerLinea();
		while (cadena != null) {
			lines.add(cadena);
			cadena = leerLinea();
		}
		cerrarArchivo();
		return lines;
	}

	private void cerrarArchivo() throws IOException {
		archivoLectura.close();
	}
}