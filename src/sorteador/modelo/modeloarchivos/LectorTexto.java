package sorteador.modelo.modeloarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorTexto {
	private FileReader fr;
	private BufferedReader br;

	public LectorTexto(String ruta) throws FileNotFoundException {
		this.fr = new FileReader(new File(ruta));
		this.br = new BufferedReader(this.fr);
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

	private String leerLinea() throws IOException {
		return this.br.readLine();
	}
	
	private void cerrarArchivo() throws IOException {
		this.fr.close();
	}
}