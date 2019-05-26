package sorteador.vistas.vistaswing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @version 1.1
 * @author caemci
 */
public abstract class JFrameTemplate extends JFrame {

	private JPanel jPanelContenido;
	private JPanel jPanelFooter;
	private static int padding = 5;

	public JFrameTemplate(String titulo) {
		super(titulo); // Invoca al constructor de la superclase con el título de la ventana
		this.jPanelContenido = new JPanel();
		this.jPanelFooter = new JPanelFooter();
		this.iniciar();
	}

	private void iniciar() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // La aplicación por defecto se cierra al tocar la cruz
		this.cargarImagenes(); // Personaliza el ícono de la ventana
		this.setResizable(false); // Impide que la ventana cambie de dimensiones
		this.setLocationRelativeTo(null); // Aparecerá en el centro de la pantalla
		this.establecerLayout();
	}
	
	private void establecerLayout() {
		super.getContentPane().setLayout(new BorderLayout()); // Establece la disposición de la ventana
		super.getContentPane().add(jPanelContenido, BorderLayout.CENTER); // El contenido se inserta en el medio
		super.getContentPane().add(jPanelFooter, BorderLayout.PAGE_END); // El footer (pie) se inserta debajo
		this.jPanelContenido.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
		this.pack();
	}

	private void cargarImagenes() {
		String pck = getClass().getPackage().getName().replace(".", "/");
		this.setIconImage( getImagen(pck + "/recursos/caemci-logo-square.png") ); // Establece el ícono de la ventana
	}

	private Image getImagen(String ruta) {
		Image img = null;
		try {
			img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/" + ruta));
		} catch (Exception e) {
			System.out.println("No se pudo cargar recurso " + ruta + ": " + e.getMessage());
		}
		return img;
	}

	@Override
	public final JComponent getContentPane() {
		return jPanelContenido;
	}

	protected abstract void agregarContenido();

	protected abstract void instanciarComponentes();

	protected abstract void setearComponentes();

	private class JPanelFooter extends JPanel {
		private JLabel jLabelAutor;
		private JLabel jLabelLink;

		public JPanelFooter() {
			jLabelAutor = new JLabel();
			jLabelLink = new JLabel();
			prepararAutor();
			prepararLink();
			establecerLayout();
			setearComponentes();
			this.setPreferredSize(new Dimension(40, 40));
		}

		private void establecerLayout() {
			this.setLayout(new BorderLayout());
			this.add(jLabelAutor, BorderLayout.WEST);
			this.add(jLabelLink, BorderLayout.EAST);
			this.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
		}

		private void prepararAutor() {
			String pck = getClass().getPackage().getName().replace(".", "/");
			jLabelAutor.setIcon( new ImageIcon( getImagen(pck + "/recursos/caemci-logo-wide.png") )); // Establece el ícono de la ventana);
			jLabelAutor.setText("Realizado por ");
			jLabelAutor.setHorizontalTextPosition(SwingConstants.LEFT);
			jLabelAutor.setVerticalTextPosition(SwingConstants.CENTER);
		}

		private void prepararLink() {
			jLabelLink.setText("https://github.com/caemci");
		}
		
		private void setearComponentes() {
			for (Component comp : this.getComponents()) {
				JLabel jl = (JLabel) comp;
				jl.setAlignmentX(Component.CENTER_ALIGNMENT);
				jl.setAlignmentY(Component.CENTER_ALIGNMENT);
				jl.setFont(new Font("Lato", 1, 18));
			}
		}

	}
}
