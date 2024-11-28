package main;

import java.io.IOException;
import java.util.Scanner;

import modelo.menus.menuTablaDesordenado;
import modelo.menus.menuTablaOrdenada;

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
     * Objeto {@code Scanner} utilizado para la captura de la entrada del usuario
     * desde la consola.
     */
    private Scanner sc;

    /**
     * Objeto que maneja el menú de operaciones para la tabla desordenada.
     */
    private menuTablaDesordenado menuDesordenado;

    /**
     * Objeto que maneja el menú de operaciones para la tabla ordenada.
     */
    private menuTablaOrdenada menuOrdenado;

    /**
     * Constructor de la clase. Inicializa el {@code Scanner} y los objetos de los
     * menús.
     * 
     * @throws IOException Si ocurre un error al inicializar las tablas de símbolos.
     */
    public ProyectBiblia() throws IOException {
        sc = new Scanner(System.in);
        menuDesordenado = new menuTablaDesordenado(sc);
        menuOrdenado = new menuTablaOrdenada(sc);
    }

    /**
     * Método principal que ejecuta el ciclo de menú del programa.
     * 
     * Muestra al usuario las opciones disponibles para elegir entre usar la
     * tabla de símbolos ordenada o desordenada. Según la elección del usuario,
     * el programa invoca el menú correspondiente y permite realizar varias
     * operaciones
     * relacionadas con las palabras en la Biblia.
     * 
     * @param args Los argumentos de línea de comandos (no utilizados en este caso).
     * @throws IOException Si ocurre un error al cargar las palabras de la Biblia.
     */
    public static void main(String[] args) throws IOException {
        ProyectBiblia main = new ProyectBiblia();
        main.menuTerminal(main);
        
    }

    public void menuTerminal(ProyectBiblia main) throws IOException {
        int opcion;
        while (true) {
            System.out.println("PROYECTO BIBLIA");
            System.out.println("¿Qué tabla de símbolos desea usar?"
                    + "\n1. Tabla de símbolos ordenada"
                    + "\n2. Tabla de símbolos desordenada"
                    + "\n3. Salir");
            opcion = main.sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    main.menuOrdenado.conTablaOrdenada();
                }
                case 2 -> {
                    main.menuDesordenado.conTablaDesordenada();
                }
                case 3 -> {
                    System.exit(0);
                }
                default -> throw new AssertionError();
            }
        }
    }
}
