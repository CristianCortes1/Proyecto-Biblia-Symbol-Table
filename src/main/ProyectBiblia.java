package main;

import java.io.IOException;

import controller.Controller;
import modelo.mundo.BibliaNoOrdenada;
import modelo.mundo.BibliaOrdenada;
import view.*;
/**
 * @author Cristian Cortes
 * @author David Chacon
 * @author Juan Coronado
 * @author Miguel Ardila
 */

/**
 * La clase {@code ProyectBiblia} es la clase principal del proyecto que permite
 * al usuario interactuar con una Biblia representada a través de dos tipos de
 * tablas
 * de símbolos: una ordenada y una desordenada. A través de un menú interactivo,
 * el usuario puede elegir qué tipo de tabla utilizar y realizar diversas
 * operaciones
 * relacionadas con las palabras del texto.
 * 
 * La clase contiene un ciclo principal que presenta las opciones disponibles y
 * redirige al usuario al menú correspondiente, ya sea para la tabla ordenada
 * o la desordenada.
 */
public class ProyectBiblia {

    /**
     * Constructor for the ProyectBiblia class.
     * Initializes the main components for the project.
     */
    public ProyectBiblia() {
    }

    /**
     * The main method to start the application.
     * Sets up the main window and initializes the controllers for the ordered and unordered Bibles.
     *
     * @param args Command line arguments
     * @throws IOException If an input or output exception occurred
     */
    public static void main(String[] args) throws IOException {
        // Initialize the main window
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        
        // Create instances of the unordered and ordered Bible
        BibliaNoOrdenada bibliaNoOrdenada = new BibliaNoOrdenada();
        BibliaOrdenada bibliaOrdenada = new BibliaOrdenada();
        
        new Controller(ventanaPrincipal, bibliaNoOrdenada, bibliaOrdenada);
    }

}
