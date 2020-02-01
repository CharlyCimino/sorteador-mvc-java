package sorteador.vista.vistaswing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import sorteador.vistas.IVista;

public final class VistaSwing extends JFrameTemplate implements IVista {

    private JPanel jPanelPrincipal;
    private JPanel jPanelSorteado;
    private JPanel jPanelBoton;
    private JMenu jMenuPrincipal;
    private JMenuBar jMenuBarDatos;
    private JMenuItem jMenuItemCargar;
    private JMenuItem jMenuItemReiniciar;
    private JButton jButtonSortear;
    private JLabel jLabelSorteado;

    public VistaSwing() {
        super("Sorteador");
        instanciarComponentes();
        setearComponentes();
        agregarContenido();
    }

    private void establecerTextos() {
        this.jMenuItemCargar.setText("Cargar");
        this.jMenuItemReiniciar.setText("Reiniciar");
        this.jMenuPrincipal.setText("Datos");
        this.jButtonSortear.setText("Sortear");
        this.jLabelSorteado.setText("");
    }

    private void agregarComponentesAPaneles() {
        this.jPanelSorteado.add(this.jLabelSorteado);
        this.jPanelBoton.add(this.jButtonSortear);
        this.jPanelPrincipal.add(this.jPanelSorteado);
        this.jPanelPrincipal.add(this.jPanelBoton);
    }

    private void establecerLayouts() {
        this.jPanelPrincipal.setLayout(new BoxLayout(jPanelPrincipal, BoxLayout.Y_AXIS));
    }

    private void establecerDimensiones() {
        this.jPanelSorteado.setPreferredSize(new Dimension(500, 40));
        this.jPanelBoton.setPreferredSize(new Dimension(500, 60));
    }

    private void establecerFuentes() {
        Font fontPrincipal = new Font("Lato", Font.BOLD, 24);
        Font fontMenues = new Font("Lato", Font.PLAIN, 16);
        this.jLabelSorteado.setFont(fontPrincipal);
        this.jButtonSortear.setFont(fontPrincipal);
        this.jMenuItemCargar.setFont(fontMenues);
        this.jMenuItemReiniciar.setFont(fontMenues);
        this.jMenuPrincipal.setFont(fontMenues);
    }

    private void prepararMenu() {
        this.jMenuPrincipal.add(jMenuItemCargar);
        this.jMenuPrincipal.add(jMenuItemReiniciar);
        this.jMenuBarDatos.add(jMenuPrincipal);
        this.setJMenuBar(jMenuBarDatos); // Heredado de JFrame
    }

    // Sobreescritura de métodos de JFrameTemplate
    @Override
    protected void instanciarComponentes() {
        this.jPanelPrincipal = new JPanel();
        this.jPanelSorteado = new JPanel();
        this.jPanelBoton = new JPanel();
        this.jMenuPrincipal = new JMenu();
        this.jMenuBarDatos = new JMenuBar();
        this.jMenuItemCargar = new JMenuItem();
        this.jMenuItemReiniciar = new JMenuItem();
        this.jButtonSortear = new JButton();
        this.jLabelSorteado = new JLabel();
    }

    @Override
    protected void setearComponentes() {
        establecerTextos();
        establecerFuentes();
        establecerDimensiones();
        establecerLayouts();
        agregarComponentesAPaneles();
        prepararMenu();
    }

    @Override
    protected void agregarContenido() {
        this.getContentPane().add(jPanelPrincipal);
        this.pack();
    }

    // Sobreescritura de métodos de IVista
    @Override
    public void mostrarSorteado(String sorteado) {
        this.jLabelSorteado.setText(sorteado);
    }

    @Override
    public void mostrarInfo(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);

    }

    @Override
    public String getRuta() {
        String ruta = ""; // Ruta inicial vacía
        // JFileChooser es un componente que permite trabajar con el árbol de archivos del sistema operativo
        JFileChooser explorador = new JFileChooser();
        explorador.setFileFilter(new FileNameExtensionFilter("Archivos de texto", "txt")); // Filtra por archivos de texto
        explorador.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Muestra archivos y carpetas
        int resultado = explorador.showOpenDialog(this); // Abre la ventana en modo "Abrir"
        if (resultado != JFileChooser.CANCEL_OPTION) { // Si NO toca el botón de cancelar
            // Me quedo con la ruta absoluta del archivo seleccionado por el usuario
            ruta = explorador.getSelectedFile().getAbsolutePath();
        }
        return ruta; // Devuelvo la ruta (OJO, pudo haber quedado vacía si es que tocó en cancelar)
    }

    @Override
    public void iniciar() {
        this.setVisible(true);
    }

    @Override
    public void addSortearListener(ActionListener al) {
        this.jButtonSortear.addActionListener(al);
    }

    @Override
    public void addReiniciarListener(ActionListener al) {
        this.jMenuItemReiniciar.addActionListener(al);
    }

    @Override
    public void addCargarListener(ActionListener al) {
        this.jMenuItemCargar.addActionListener(al);
    }
}
