package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;

/**
 * Clase que representa la ventana principal de la interfaz de usuario.
 * 
 * Esta clase se encarga de crear la ventana principal de la interfaz de usuario
 * y contiene los componentes necesarios para interactuar con el usuario.
 * 
 * @author Cristian Cortes
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    // Serial version UID for serialization compatibility
    private static final long serialVersionUID = 1L;

    // Main panel of the window
    private JPanel panelPrincipal;

    // Label prompting the user to select an option
    private JLabel seleccioneOpcion = new JLabel("Seleccione una opcion:");

    // ComboBox for the user to select options
    private JComboBox<String> opciones = new JComboBox<>();

    // Button to confirm the selected option
    private JButton confirmar = new JButton("Confirmar");

    // Button to go back to the previous menu
    private JButton volver = new JButton("Volver");

    // Panel for displaying unordered table information
    private JPanel panelTablaNoOrdenada;

    // ComboBox for options related to ordered table
    private JComboBox<String> opcionesOrdenada = new JComboBox<>();

    // Button to confirm actions related to unordered table
    private JButton confitmarNoOrdenada = new JButton("Confirmar");

    // Panel for displaying ordered table information
    private JPanel panelTablaOrdenada;

    // ComboBox for options related to unordered table
    private JComboBox<String> opcionesNoOrdenada = new JComboBox<>();

    // Button to confirm actions related to ordered table
    private JButton confitmarOrdenada = new JButton("Confirmar");

    // Text area for displaying information and inputs
    private JTextArea textArea = new JTextArea(10, 20);

    // Scroll pane to allow scrolling in the text area
    private JScrollPane scrollPane = new JScrollPane(textArea);

    // Button to confirm the word input by the user
    private JButton confirmarPalabra = new JButton("Confirmar palabra");

    /**
     * Constructor for VentanaPrincipal.
     * Initializes the components of the main window.
     */
    public VentanaPrincipal() {
        initComponents();
    }

    /**
     * Initializes the components of the main window.
     * 
     * This method adds the components to the window and sets their properties.
     * It also sets the layout of the window, adds the panels and sets their
     * preferred sizes.
     * 
     * @since 1.0
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

        textArea.setEditable(false);
        textArea.setPreferredSize(new java.awt.Dimension(400, 300));

        scrollPane.setViewportView(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

        confirmarPalabra.setPreferredSize(new java.awt.Dimension(400, 40));
        confirmarPalabra.setFont(new Font("Arial", Font.BOLD, 20));
        confirmarPalabra.setVisible(false);

        this.setTitle("Proyecto Biblia");
        this.setSize(600, 450);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    /**
     * Sets the main panel of the window as its content pane.
     * 
     * This method is used to show the main panel of the window, which contains
     * the main components of the window.
     * 
     * @since 1.0
     */
    public void generarPanelPrincipal() {
        this.setContentPane(panelPrincipal);
    }

    /**
     * Sets the content pane of the window to the no ordered panel.
     * 
     * This method is used to show the no ordered panel of the window, which
     * contains the options for the no ordered table and the "Volver"
     * button.
     * 
     * @since 1.0
     */
    public void generarPanelTablaNoOrdenada() {
        panelTablaNoOrdenada.add(volver);
        panelTablaNoOrdenada.add(scrollPane);
        panelTablaNoOrdenada.add(confirmarPalabra);
        this.setContentPane(panelTablaNoOrdenada);
    }

    /**
     * Sets the content pane of the window to the ordered panel.
     * 
     * This method is used to show the ordered panel of the window, which
     * contains the options for the ordered table and the "Volver"
     * button.
     * 
     * @since 1.0
     */
    public void generarPanelTablaOrdenada() {
        panelTablaOrdenada.add(volver);
        panelTablaOrdenada.add(scrollPane);
        panelTablaOrdenada.add(confirmarPalabra);
        this.setContentPane(panelTablaOrdenada);
    }

    /**
     * Returns the panel of the no ordered table.
     * 
     * @return The panel of the no ordered table.
     * 
     * @since 1.0
     */
    public JPanel getPanelTablaNoOrdenada() {
        return panelTablaNoOrdenada;
    }

    /**
     * Returns the panel of the ordered table.
     * 
     * @return The panel of the ordered table.
     * 
     * @since 1.0
     */
    public JPanel getPanelTablaOrdenada() {
        return panelTablaOrdenada;
    }

    /**
     * Returns the button to confirm the action to perform on the ordered table.
     * 
     * @return The button to confirm the action to perform on the ordered table.
     * 
     * @since 1.0
     */
    public JButton getConfirmarPalabra() {
        return confirmarPalabra;
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

    /**
     * Returns the JComboBox containing the options for the main menu.
     * 
     * @return the JComboBox with the options available for selection
     */
    public JComboBox<String> getOpciones() {
        return opciones;
    }

    /**
     * Returns the JComboBox containing the options for the unordered table menu.
     *
     * @return the JComboBox with the options available for the unordered table
     */
    public JComboBox<String> getOpcionesNoOrdenada() {
        return opcionesNoOrdenada;
    }

    /**
     * Returns the JScrollPane containing the text area.
     * 
     * @return The JScrollPane containing the text area.
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * Returns the JComboBox containing the options for the ordered table menu.
     * 
     * @return The JComboBox with the options available for the ordered table
     */
    public JComboBox<String> getOpcionesOrdenada() {
        return opcionesOrdenada;
    }

    /**
     * Returns the JTextArea where the results of the actions are displayed.
     * 
     * @return The JTextArea where the results of the actions are displayed.
     */
    public JTextArea getTextArea() {
        return textArea;
    }

    /**
     * Sets the JTextArea where the results of the actions are displayed.
     * 
     * @param textArea The JTextArea where the results of the actions are displayed.
     * @return The JTextArea where the results of the actions are displayed.
     */
    public JTextArea setTextArea(JTextArea textArea) {
        return this.textArea = textArea;
    }

    /**
     * Returns the JButton for confirming the action to perform on the unordered
     * table.
     * 
     * @return The JButton for confirming the action to perform on the unordered
     *         table.
     */
    public JButton getConfitmarNoOrdenada() {
        return confitmarNoOrdenada;
    }

    /**
     * Returns the JButton for confirming the action to perform on the ordered
     * table.
     * 
     * @return The JButton for confirming the action to perform on the ordered
     *         table.
     */
    public JButton getConfitmarOrdenada() {
        return confitmarOrdenada;
    }

    /**
     * Returns the JButton for going back to the main menu.
     * 
     * @return The JButton for going back to the main menu.
     */
    public JButton getVolver() {
        return volver;
    }
}
