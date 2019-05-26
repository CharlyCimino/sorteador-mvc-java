package sorteador.modelo;

import java.io.IOException;

public interface IModelo {
	void cargarSorteador(String ruta) throws IOException;
	String proximoSorteado();
	void reiniciar();
}
