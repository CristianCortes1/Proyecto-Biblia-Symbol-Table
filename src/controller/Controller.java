package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import modelo.mundo.BibliaNoOrdenada;
import modelo.mundo.BibliaOrdenada;
import view.VentanaPrincipal;

/**
 * This class represents the controller of the application, responsible for
 * controlling the flow of the program and interacting with the user.
 * 
 * @author Cristian Cortes
 */
public class Controller implements ActionListener {

    /**
     * The main window of the application.
     */
    private VentanaPrincipal ventana;

    /**
     * The instance of the unordered Bible.
     */
    private BibliaNoOrdenada bibliaNoOrdenada;

    /**
     * The instance of the ordered Bible.
     */
    private BibliaOrdenada bibliaOrdenada;

    /**
     * Flags to determine the type of operation to perform.
     */
    private boolean frecuenciaDeUnaPalabra = false, rangoDeUnaPalabra = false, palabraDeRangoN = false;

    /**
     * Constructs a new Controler.
     * 
     * @param ventana          the main application window
     * @param bibliaNoOrdenada an instance of the unordered Bible
     * @param bibliaOrdenada   an instance of the ordered Bible
     */
    public Controller(VentanaPrincipal ventana, BibliaNoOrdenada bibliaNoOrdenada, BibliaOrdenada bibliaOrdenada) {
        this.ventana = ventana;
        this.bibliaNoOrdenada = bibliaNoOrdenada;
        this.bibliaOrdenada = bibliaOrdenada;
        ventana.getConfirmar().addActionListener(this);
        ventana.getVolver().addActionListener(this);
        ventana.getConfitmarNoOrdenada().addActionListener(this);
        ventana.getConfitmarOrdenada().addActionListener(this);
        ventana.getConfirmarPalabra().addActionListener(this);

    }

    /**
     * Este método se encarga de manejar los eventos de los botones del proyecto.
     * 
     * <p>
     * Si se selecciona la opción "Biblia no ordenada" o "Biblia ordenada" en el
     * menú principal, este método se encarga de llenar la tabla de símbolos
     * correspondiente y mostrar el panel de la tabla correspondiente.
     * </p>
     * 
     * <p>
     * Si se selecciona el botón "Volver" en el panel de la tabla, este método se
     * encarga de mostrar el panel principal nuevamente.
     * </p>
     * 
     * <p>
     * Si se selecciona el botón "Confirmar" en el panel de la tabla no ordenada o
     * el panel de la tabla ordenada, este método se encarga de mostrar el
     * resultado de la opción seleccionada en el menú correspondiente.
     * </p>
     * 
     * <p>
     * Si se selecciona el botón "Confirmar palabra" en el panel de la tabla
     * ordenada, este método se encarga de mostrar el resultado de la búsqueda de
     * la palabra en el texto.
     * </p>
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ventana.getConfirmar())) {
            if (ventana.getOpciones().getSelectedItem().equals("Biblia no ordenada")) {

                try {
                    if (bibliaNoOrdenada.palabrasTotales() == 0) {
                        bibliaNoOrdenada.llenarDisorderedST();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                ventana.generarPanelTablaNoOrdenada();
                ventana.getTextArea().setText("");

            } else if (ventana.getOpciones().getSelectedItem().equals("Biblia ordenada")) {

                try {
                    if (bibliaOrdenada.palabrasTotales() == 0) {
                        bibliaOrdenada.llenarOrderedST();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                ventana.getTextArea().setText("");
                ventana.generarPanelTablaOrdenada();
            }

        } else if (e.getSource().equals(ventana.getVolver())) {

            ventana.generarPanelPrincipal();
            ventana.revalidate();

        } else if (e.getSource().equals(ventana.getConfitmarNoOrdenada())) {

            caseNoOrdenada(e);

        } else if (e.getSource().equals(ventana.getConfitmarOrdenada())) {

            caseOrdenada(e);

        } else if (e.getSource().equals(ventana.getConfirmarPalabra())) {

            confirmarPalabra();

        }
    }

    /**
     * Maneja las opciones de la ventana de la biblia no ordenada.
     * 
     * @param e evento de tipo ActionEvent
     */
    public void caseNoOrdenada(ActionEvent e) {
        switch (((String) ventana.getOpcionesNoOrdenada().getSelectedItem())) {
            case "Mostrar palabras totales":
                ventana.getTextArea().setText("Cantidad de palabras: "
                        + bibliaNoOrdenada.palabrasTotales());
                ventana.getTextArea().setRows(10);
                break;
            case "Mostrar palabras únicas":
                ventana.getTextArea().setRows(bibliaNoOrdenada.palabrasUnicas().split("\n").length);
                ventana.getTextArea().setText("Palabras únicas: "
                        + bibliaNoOrdenada.palabrasUnicas());
                break;
            case "Mostrar la palabra con más frecuencia":
                ventana.getTextArea().setText("Palabra con mayor frecuencia: "
                        + bibliaNoOrdenada.palabraMayorFrecuencia());
                ventana.getTextArea().setRows(10);
                break;
            case "Mostrar la cantidad de palabras con menos frecuencia":
                ventana.getTextArea().setText("Palabras con menos frecuencia: "
                        + bibliaNoOrdenada.palabrasUnicas());
                ventana.getTextArea().setRows(bibliaNoOrdenada.palabrasUnicas().split("\n").length);
                break;
            case "Mostrar la frecuencia de una palabra":
                ventana.getTextArea().setEditable(true);
                ventana.getTextArea().setText("Escriba la palabra: ");
                ventana.getTextArea().setRows(10);
                ventana.getConfirmarPalabra().setVisible(true);
                frecuenciaDeUnaPalabra = true;
                break;
            case "Mostrar la frecuencia de cada palabra":
                ventana.getTextArea().setText("Frecuencia de cada palabra: "
                        + bibliaNoOrdenada.palabraValor());
                ventana.getTextArea().setRows(bibliaNoOrdenada.palabraValor().split("\n").length);
                break;
            case "Mostrar palabras de la biblia sin repetir":
                ventana.getTextArea().setText("Palabras sin repetir: "
                        + bibliaNoOrdenada.mostrarPalabrasSinRepetir());
                ventana.getTextArea().setRows(bibliaNoOrdenada.mostrarPalabrasSinRepetir().split("\n").length);
                break;
        }
        ventana.getScrollPane().revalidate();
        ventana.revalidate();
    }

    /**
     * Muestra las opciones de la tabla ordenada de palabras
     * en el textArea de la interfaz gráfica.
     * 
     * @param e Evento que desencadena la acción.
     */
    public void caseOrdenada(ActionEvent e) {
        switch (((String) ventana.getOpcionesOrdenada().getSelectedItem())) {
            case "Mostrar palabras totales":
                ventana.getTextArea().setText("Cantidad de palabras: "
                        + bibliaOrdenada.palabrasTotales());
                ventana.getTextArea().setRows(10);
                break;
            case "Mostrar palabras únicas":
                ventana.getTextArea().setRows(bibliaOrdenada.palabrasUnicas().split("\n").length);
                ventana.getTextArea().setText("Palabras únicas: "
                        + bibliaOrdenada.palabrasUnicas());
                break;
            case "Mostrar la palabra con más frecuencia":
                ventana.getTextArea().setText("Palabra con mayor frecuencia: "
                        + bibliaOrdenada.palabraMayorFrecuencia());
                ventana.getTextArea().setRows(10);
                break;
            case "Mostrar la cantidad de palabras con menos frecuencia":
                ventana.getTextArea().setText("Palabras con menos frecuencia: "
                        + bibliaOrdenada.palabrasUnicas());
                ventana.getTextArea().setRows(bibliaOrdenada.palabrasUnicas().split("\n").length);
                break;
            case "Mostrar la frecuencia de una palabra":
                frecuenciaDeUnaPalabra = true;
                ventana.getTextArea().setEditable(true);
                ventana.getTextArea().setText("Escriba la palabra: ");
                ventana.getTextArea().setRows(10);
                ventana.getConfirmarPalabra().setVisible(true);
                break;
            case "Mostrar la primera palabra alfabéticamente":
                ventana.getTextArea().setText("Primera palabra: "
                        + bibliaOrdenada.primerPalabra());
                ventana.getTextArea().setRows(10);
                break;
            case "Mostrar la última palabra alfabéticamente":
                ventana.getTextArea().setText("Ultima palabra: "
                        + bibliaOrdenada.ultimaPalabra());
                ventana.getTextArea().setRows(10);
                break;
            case "Mostrar la frecuencia de cada palabra":
                ventana.getTextArea().setText("Frecuencia de cada palabra: "
                        + bibliaOrdenada.palabraValor());
                ventana.getTextArea().setRows(bibliaOrdenada.palabraValor().split("\n").length);
                break;
            case "Mostrar el rango de una palabra":
                ventana.getTextArea().setEditable(true);
                ventana.getTextArea().setText("Escriba la palabra: ");
                ventana.getTextArea().setRows(10);
                ventana.getConfirmarPalabra().setVisible(true);
                rangoDeUnaPalabra = true;
                break;
            case "Mostrar la palabra en el rango n":
                ventana.getTextArea().setEditable(true);
                ventana.getTextArea().setText("Escriba el rango: ");
                ventana.getTextArea().setRows(10);
                ventana.getConfirmarPalabra().setVisible(true);
                palabraDeRangoN = true;
                break;
            case "Mostrar palabras de la biblia sin repetir":
                ventana.getTextArea().setText("Palabras sin repetir: "
                        + bibliaOrdenada.mostrarPalabrasSinRepetir());
                ventana.getTextArea().setRows(bibliaOrdenada.mostrarPalabrasSinRepetir().split("\n").length);
                break;
        }
        ventana.getScrollPane().revalidate();
        ventana.revalidate();
    }

    /**
     * Confirma la palabra para buscar su frecuencia, rango o rango n.
     * 
     * Si frecuenciaDeUnaPalabra es true, busca la frecuencia de la palabra
     * introducida por el usuario en el TextArea. Si rangoDeUnaPalabra es true,
     * busca el rango de la palabra introducida. Si palabraDeRangoN es true, busca
     * la palabra en el rango n introducido.
     */
    public void confirmarPalabra() {
        if (frecuenciaDeUnaPalabra) {
            ventana.getTextArea().setEditable(false);
            ventana.getTextArea().setText("Frecuencia de la palabra: "
                    + bibliaOrdenada
                            .buscarFrecuenciaDeUnaPalabra(ventana.getTextArea().getText().substring(20)));
            ventana.getConfirmarPalabra().setVisible(false);
            frecuenciaDeUnaPalabra = false;
        } else if (rangoDeUnaPalabra) {
            ventana.getTextArea().setEditable(false);
            ventana.getTextArea().setText("Rango de la palabra: "
                    + bibliaOrdenada
                            .rangoPalabra(ventana.getTextArea().getText().substring(20)));
            ventana.getConfirmarPalabra().setVisible(false);
            rangoDeUnaPalabra = false;
        } else if (palabraDeRangoN) {
            ventana.getTextArea().setEditable(false);
            ventana.getTextArea().setText("Palabra en el rango: "
                    + bibliaOrdenada
                            .palabraDeRangoN(Integer.parseInt(ventana.getTextArea().getText().substring(18))));
            ventana.getConfirmarPalabra().setVisible(false);
            palabraDeRangoN = false;
        }
    }

}
