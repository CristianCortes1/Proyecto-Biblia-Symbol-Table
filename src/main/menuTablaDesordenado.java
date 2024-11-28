package main;

import java.io.IOException;
import java.util.Scanner;
import mundoOrdenado.BibliaDesordenada;

/**
 * @author Cristian Cortes
 * @author David Chacon
 * @author Juan Coronado
 * @author Miguel Ardila
 */

/**
 * Esta clase implementa un menú interactivo para gestionar y consultar
 * estadísticas
 * de una Biblia organizada en una tabla desordenada. El menú permite al usuario
 * realizar
 * diversas operaciones, como obtener el número total de palabras, las palabras
 * únicas,
 * la frecuencia de palabras, entre otras opciones.
 * 
 * El usuario puede interactuar con la Biblia desordenada a través de diversas
 * consultas,
 * como obtener la palabra con mayor frecuencia, o mostrar la frecuencia de una
 * palabra específica.
 */
public class menuTablaDesordenado {

    /**
     * Objeto que representa la Biblia usando una tabla desordenada.
     */
    private BibliaDesordenada biblia;

    /**
     * Objeto Scanner para la captura de entrada del usuario.
     */
    private Scanner sc;

    /**
     * Indica si la tabla desordenada ha sido llenada con los datos del texto.
     */
    private boolean llenado = false;

    /**
     * Constructor de la clase. Inicializa la Biblia y el Scanner para la entrada de
     * datos.
     * 
     * @param sc Scanner para la entrada del usuario.
     * @throws IOException Si ocurre un error al cargar las palabras desde el
     *                     archivo.
     */
    public menuTablaDesordenado(Scanner sc) throws IOException {
        biblia = new BibliaDesordenada();
        this.sc = sc;
    }

    /**
     * Muestra la cantidad total de palabras que contiene el texto de la Biblia.
     */
    public void mostrarPalabrasTotales() {
        System.out.println("Las Palabras totales de la Biblia son: " + biblia.palabrasTotales());
    }

    /**
     * Muestra todas las palabras únicas presentes en el texto de la Biblia.
     */
    public void mostrarPalabrasUnicas() {
        System.out.println("Las palabras unicas son: " + biblia.palabrasUnicas());
    }

    /**
     * Muestra la palabra que tiene la mayor frecuencia de aparición, junto con el
     * número de veces
     * que aparece en el texto.
     */
    public void mostrarLaMayorFrecuencia() {
        System.out.println("La palabra con mayor frecuencia es: " + biblia.palabraMayorFrecuencia()
                + " y se repite: " + biblia.mayorFrecuencia() + " veces");
    }

    /**
     * Muestra cuántas palabras tienen la menor frecuencia en el texto.
     */
    public void mostrarLaMenorFrecuencia() {
        System.out.println("Las palabras con menor frecuencia son: " + biblia.palabrasUnicasContador());
    }

    /**
     * Solicita al usuario una palabra y muestra cuántas veces aparece en el texto
     * de la Biblia.
     */
    public void mostrarFrecuenciaDeUnaPalabra() {
        System.out.println("Escriba la palabra a buscar: ");
        String palabra = sc.next();
        if (biblia.buscarFrecuenciaDeUnaPalabra(palabra) != null) {
            System.out.println("La palabra: " + palabra
                    + " se encontró: " + biblia.buscarFrecuenciaDeUnaPalabra(palabra) + " veces");
        } else {
            System.out.println("No se encontró la palabra");
        }
    }

    /**
     * Muestra la frecuencia de cada palabra en el texto.
     */
    public void mostrarPalabraValor() {
        System.out.print("La frecuencia de cada palabra es:\n" + biblia.palabraValor());
    }

    /**
     * Muestra todas las palabras almacenadas en la Biblia sin repeticiones.
     * Utiliza la estructura de datos ordenada para obtener y mostrar las palabras
     * únicas.
     */
    public void mostrarPalabrasSinRepetir() {
        System.out.println("Las palabras sin repetir son: " + biblia.mostrarPalabrasSinRepetir());
    }

    /**
     * Muestra el menú de operaciones disponibles que el usuario puede elegir.
     * Incluye opciones para mostrar estadísticas y realizar búsquedas de palabras
     * según diferentes criterios (frecuencia, palabras únicas, etc.).
     * 
     * @throws IOException
     */
    public void conTablaDesordenada() throws IOException {

        if (!llenado) {
            biblia.llenarDisorderedST();
            llenado = true;
        }
        int opcion;
        boolean volver = false;
        while (!volver) {
            System.out.println("¿Qué desea hacer:"
                    + "\n1. Mostrar cantidad de palabras totales."
                    + "\n2. Mostrar las palabras únicas."
                    + "\n3. Mostrar la palabra con más frecuencia."
                    + "\n4. Mostrar la cantidad de palabras con menos frecuencia."
                    + "\n5. Mostrar la frecuencia de una palabra."
                    + "\n6. Mostrar la frecuencia de cada palabra."
                    + "\n7. Mostrar palabras de la biblia sin repetir."
                    + "\n8. Volver."
                    + "\n9. Salir.");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    mostrarPalabrasTotales();
                }
                case 2 -> {
                    mostrarPalabrasUnicas();
                }
                case 3 -> {
                    mostrarLaMayorFrecuencia();
                }
                case 4 -> {
                    mostrarLaMenorFrecuencia();
                }
                case 5 -> {
                    mostrarFrecuenciaDeUnaPalabra();
                }
                case 6 -> {
                    mostrarPalabraValor();
                }
                case 7 -> {
                    mostrarPalabrasSinRepetir();
                }
                case 8 -> {
                    volver = true;
                }
                case 9 -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("Opcion invalida");
                }
            }
        }
    }
}
