package sorteador.modelo.modeloarchivos;

import java.io.IOException;

import sorteador.modelo.IModelo;
import sorteador.modelo.Sorteador;

public class ModeloArchivos implements IModelo {

	private Sorteador<String> s;
	
	public ModeloArchivos() {
		this.s = new Sorteador<>();
	}

	@Override
	public String proximoSorteado() {
		return s.proximoSorteado();
	}

	@Override
	public void cargarSorteador(String ruta) throws IOException {
		LectorTexto lt = new LectorTexto(ruta);
		s.insertar( lt.leerLineas() );
	}

	@Override
	public void reiniciar()  {
		this.s.reiniciar();
	}
	
}
