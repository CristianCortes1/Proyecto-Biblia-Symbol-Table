package main;

import java.io.IOException;
import java.util.Scanner;
import mundoOrdenado.BibliaOrdenada;

/**
 * @author Cristian Cortes
 * @author David Chacon
 * @author Juan Coronado
 * @author Miguel Ardila
 */

/**
 * Esta clase implementa un menú interactivo para gestionar y consultar
 * estadísticas
 * de una Biblia organizada en una tabla ordenada. El menú permite al usuario
 * realizar
 * diversas operaciones, como obtener el número total de palabras, las palabras
 * únicas,
 * la frecuencia de palabras y el orden alfabético de las mismas, entre otras
 * opciones.
 * 
 * El usuario puede interactuar con la Biblia ordenada a través de diversas
 * consultas,
 * como obtener la palabra con mayor frecuencia, mostrar el rango de una
 * palabra, o
 * listar las palabras ordenadas alfabéticamente.
 */
public class menuTablaOrdenada {

    /**
     * Objeto que representa la Biblia usando una tabla ordenada.
     */
    private BibliaOrdenada biblia;

    /**
     * Objeto Scanner para la captura de entrada del usuario.
     */
    private Scanner sc;

    /**
     * Indica si la tabla ordenada ha sido llenada con los datos del texto.
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
    public menuTablaOrdenada(Scanner sc) throws IOException {
        biblia = new BibliaOrdenada();
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
     * Muestra la última palabra en orden alfabético del texto.
     */
    public void mostrarUltimaPalabra() {
        System.out.println("La última palabra es: " + biblia.ultimaPalabra());
    }

    /**
     * Muestra la primera palabra en orden alfabético del texto.
     */
    public void mostrarPrimeraPalabra() {
        System.out.println("La primera palabra es: " + biblia.primerPalabra());
    }

    /**
     * Muestra la frecuencia de cada palabra en el texto.
     */
    public void mostrarPalabraValor() {
        System.out.print("La frecuencia de cada palabra es:\n" + biblia.palabraValor());
    }

    /**
     * Muestra el menú de operaciones disponibles que el usuario puede elegir.
     * Incluye opciones para mostrar estadísticas y realizar búsquedas de palabras
     * según diferentes criterios (frecuencia, rango, palabras alfabéticas, etc.).
     * 
     * @throws IOException
     */
    public void conTablaOrdenada() throws IOException {
        if (!llenado) {
            biblia.llenarOrderedST();
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
                    + "\n6. Mostrar la primera palabra alfabéticamente."
                    + "\n7. Mostrar la última palabra alfabéticamente."
                    + "\n8. Mostrar la frecuencia de cada palabra."
                    + "\n9. Mostrar el rango de una palabra."
                    + "\n10. Mostrar la palabra en el rango n."
                    + "\n11. Volver."
                    + "\n12. Salir.");
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
                    mostrarPrimeraPalabra();
                }
                case 7 -> {
                    mostrarUltimaPalabra();
                }
                case 8 -> {
                    mostrarPalabraValor();
                }
                case 9 -> {
                    mostrarRango();
                }
                case 10 -> {
                    mostrarPalabraRangoN();
                }
                case 11 -> {
                    volver = true;
                }
                case 12 -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("Opcion invalida");
                }
            }
        }
    }

    /**
     * Solicita al usuario una palabra y muestra su rango en la tabla ordenada.
     */
    public void mostrarRango() {
        System.out.println("Escriba la palabra que quiere mostrar el rango: ");
        String palabra = sc.next();
        System.out.println("El rango de la palabra " + palabra + " es " + biblia.rangoPalabra(palabra));
    }

    /**
     * Solicita al usuario un número de rango y muestra la palabra correspondiente
     * a ese rango en el texto ordenado alfabéticamente.
     */
    public void mostrarPalabraRangoN() {
        System.out.println("Escriba el rango de la palabra:");
        int n = sc.nextInt();
        System.out.println("La palabra de rango N es: " + biblia.palabraDeRangoN(n));
    }
}
