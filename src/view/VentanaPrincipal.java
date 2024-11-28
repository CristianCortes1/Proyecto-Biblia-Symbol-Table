package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;


public class VentanaPrincipal extends javax.swing.JFrame {

    private JPanel panelPrincipal;
    private JLabel seleccioneOpcion = new JLabel("Seleccione una opcion:");
    private JComboBox<String> opciones = new JComboBox<>();
    private JButton confirmar = new JButton("Confirmar");
    private JButton volver = new JButton("Volver");

    private JPanel panelTablaNoOrdenada;
    private JComboBox<String> opcionesOrdenada = new JComboBox<>();
    private JButton confitmarNoOrdenada = new JButton("Confirmar");

    private JPanel panelTablaOrdenada;
    private JComboBox<String> opcionesNoOrdenada = new JComboBox<>();
    private JButton confitmarOrdenada = new JButton("Confirmar");

    private JTextArea textArea = new JTextArea();

    /**
     * Constructor for VentanaPrincipal.
     * Initializes the components of the main window.
     */
    public VentanaPrincipal() {
        initComponents();
    }

    /**
     * Initializes the components of the main window.
     * Sets up the main panel with a grid layout and adds the title label.
     * Configures the window size, content pane, close operation, and visibility.
     */
    private void initComponents() {
        this.setLayout(new GridLayout(1, 2));

        panelPrincipal = new JPanel();

        panelPrincipal.setLayout(new FlowLayout());
        seleccioneOpcion.setFont(new Font("Arial", Font.BOLD, 20));
        panelPrincipal.setBackground(Color.LIGHT_GRAY);
        panelPrincipal.add(seleccioneOpcion);

        opciones.addItem("Biblia no ordenada");
        opciones.addItem("Biblia ordenada");
        opciones.setFont(new Font("Arial", Font.BOLD, 20));
        panelPrincipal.add(opciones);

        confirmar.setPreferredSize(new java.awt.Dimension(300, 50));
        confirmar.setFont(new Font("Arial", Font.BOLD, 20));
        panelPrincipal.add(confirmar);

        generarPanelPrincipal();

        panelTablaNoOrdenada = new JPanel();
        panelTablaNoOrdenada.setBackground(Color.LIGHT_GRAY);
        panelTablaNoOrdenada.setLayout(new FlowLayout());
        panelTablaNoOrdenada.setSize(600, 400);

        opcionesNoOrdenada.addItem("Mostrar palabras totales");
        opcionesNoOrdenada.addItem("Mostrar palabras únicas");
        opcionesNoOrdenada.addItem("Mostrar la palabra con más frecuencia");
        opcionesNoOrdenada.addItem("Mostrar la cantidad de palabras con menos frecuencia");
        opcionesNoOrdenada.addItem("Mostrar la frecuencia de una palabra");
        opcionesNoOrdenada.addItem("Mostrar la frecuencia de cada palabra");
        opcionesNoOrdenada.addItem("Mostrar palabras de la biblia sin repetir");
        panelTablaNoOrdenada.add(opcionesNoOrdenada);

        panelTablaNoOrdenada.add(confitmarNoOrdenada);

        panelTablaOrdenada = new JPanel();
        panelTablaOrdenada.setBackground(Color.LIGHT_GRAY);
        panelTablaOrdenada.setLayout(new FlowLayout());
        panelTablaOrdenada.setSize(600, 400);

        opcionesOrdenada.addItem("Mostrar palabras totales");
        opcionesOrdenada.addItem("Mostrar palabras únicas");
        opcionesOrdenada.addItem("Mostrar la palabra con más frecuencia");
        opcionesOrdenada.addItem("Mostrar la cantidad de palabras con menos frecuencia");
        opcionesOrdenada.addItem("Mostrar la frecuencia de una palabra");
        opcionesOrdenada.addItem("Mostrar la primera palabra alfabéticamente");
        opcionesOrdenada.addItem("Mostrar la última palabra alfabéticamente");
        opcionesOrdenada.addItem("Mostrar la frecuencia de cada palabra");
        opcionesOrdenada.addItem("Mostrar el rango de una palabra");
        opcionesOrdenada.addItem("Mostrar la palabra en el rango n");
        opcionesOrdenada.addItem("Mostrar palabras de la biblia sin repetir");
        panelTablaOrdenada.add(opcionesOrdenada);

        panelTablaOrdenada.add(confitmarOrdenada);

        this.setTitle("Proyecto Biblia");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void generarPanelPrincipal() {

        this.setContentPane(panelPrincipal);
    }

    public void generarPanelTablaNoOrdenada() {

        panelTablaNoOrdenada.add(volver);
        textArea.setEditable(false);
        textArea.setAutoscrolls(true);
        textArea.getScrollableBlockIncrement(new java.awt.Rectangle(0, 0, 0, 0), 1, 1);
        panelTablaNoOrdenada.add(textArea);
        this.setContentPane(panelTablaNoOrdenada);
    }

    public void generarPanelTablaOrdenada() {

        panelTablaOrdenada.add(volver);
        // textArea.setPreferredSize(new java.awt.Dimension(400, 300));
        textArea.setEditable(false);
        panelTablaOrdenada.add(textArea);
        this.setContentPane(panelTablaOrdenada);
    }

    /**
     * Returns the main panel of the window, which contains the components.
     * 
     * @return the main panel of the window
     */
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    /**
     * Returns the confirm button.
     * 
     * @return the confirm button
     */
    public JButton getConfirmar() {
        return confirmar;
    }

    public JComboBox<String> getOpciones() {
        return opciones;
    }

    public JComboBox<String> getOpcionesNoOrdenada() {
        return opcionesNoOrdenada;
    }

    public JComboBox<String> getOpcionesOrdenada() {
        return opcionesOrdenada;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JButton getConfitmarNoOrdenada() {
        return confitmarNoOrdenada;
    }

    public JButton getConfitmarOrdenada() {
        return confitmarOrdenada;
    }

    public JButton getVolver() {
        return volver;
    }
}
