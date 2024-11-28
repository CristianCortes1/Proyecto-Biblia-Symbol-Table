package mundoOrdenado;

import java.io.IOException;
import tdas.OrderedST;

/**
 *
 * @author Cristian Cortes
 * @author David Chacon
 * @author Juan Coronado
 * @author Miguel Ardila
 */

/**
 * Esta clase representa una Biblia ordenada por palabras, donde se pueden
 * realizar diversas operaciones como ordenar, buscar y calcular frecuencias de
 * palabras.
 */
public class BibliaOrdenada {

    /**
     * Un símbolo de tabla ordenado que mapea cada palabra a su frecuencia.
     */
    private OrderedST<String, Integer> palabrasOrdenadas;

    /**
     * Constructor de la clase BibliaOrdenada. Carga las palabras del archivo,
     * las ordena y crea las estructuras de datos necesarias.
     */
    public BibliaOrdenada() throws IOException {
        palabrasOrdenadas = new OrderedST<>();
    }

    public void llenarOrderedST() throws IOException {
        GestorArchivos.obtenerPalabras(palabrasOrdenadas);
    }

    /**
     * Busca la frecuencia de una palabra en el texto.
     *
     * @param palabra La palabra a buscar.
     * @return La frecuencia de la palabra, o 0 si no se encuentra.
     */
    public Integer buscarFrecuenciaDeUnaPalabra(String palabra) {
        return palabrasOrdenadas.get(palabra);
    }

    /**
     * Devuelve el número total de palabras en el texto.
     *
     * @return El número total de palabras.
     */
    public int palabrasTotales() {
        return palabrasOrdenadas.size();
    }

    /**
     * Devuelve un String con todas las palabras únicas encontradas.
     *
     * @return Un String con todas las palabras únicas.
     */
    public String palabrasUnicas() {
        String palabrasUnicas = "";
        for (String palabra : palabrasOrdenadas.keys()) {
            if (palabrasOrdenadas.get(palabra) == 1) {
                palabrasUnicas += palabra + "\n";
            }
        }
        return palabrasUnicas;
    }

    /**
     * Devuelve el número de palabras únicas encontradas.
     *
     * @return El número de palabras únicas.
     */
    public int palabrasUnicasContador() {
        int contador = 0;
        for (String palabra : palabrasOrdenadas.keys()) {
            if (palabrasOrdenadas.get(palabra) == 1) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Devuelve la palabra con mayor frecuencia.
     *
     * @return La palabra con mayor frecuencia.
     */
    public String palabraMayorFrecuencia() {
        String palabraMayor = "";
        int mayorFrecuencia = 0;
        for (String palabra : palabrasOrdenadas.keys()) {
            if (palabrasOrdenadas.get(palabra) > mayorFrecuencia) {
                mayorFrecuencia = palabrasOrdenadas.get(palabra);
                palabraMayor = palabra;
            }
        }
        return palabraMayor;
    }

    /**
     * Devuelve la frecuencia máxima de una palabra.
     *
     * @return La frecuencia máxima.
     */
    public int mayorFrecuencia() {
        int mayorFrecuencia = 0;
        for (String palabra : palabrasOrdenadas.keys()) {
            if (palabrasOrdenadas.get(palabra) > mayorFrecuencia) {
                mayorFrecuencia = palabrasOrdenadas.get(palabra);
            }
        }
        return mayorFrecuencia;
    }

    /**
     * Devuelve la primera palabra en orden alfabético.
     *
     * @return La primera palabra en orden alfabético.
     */
    public String primerPalabra() {
        return palabrasOrdenadas.min();
    }

    /**
     * Devuelve la última palabra en orden alfabético.
     *
     * @return La última palabra en orden alfabético.
     */
    public String ultimaPalabra() {
        return palabrasOrdenadas.max();
    }

    /**
     * Devuelve una palabra y su frecuencia en formato de cadena.
     *
     * @return Una cadena con una palabra y su frecuencia.
     */
    public String palabraValor() {
        String palabraValor = "";
        for (String palabra : palabrasOrdenadas.keys()) {
            palabraValor += palabra + "," + palabrasOrdenadas.get(palabra) + "\n";
        }
        return palabraValor;
    }

    /**
     * Devuelve la palabra en la posición n-ésima del orden alfabético.
     *
     * @param n La posición de la palabra.
     * @return La palabra en la posición n-ésima.
     */
    public String palabraDeRangoN(int n) {
        return palabrasOrdenadas.select(n);
    }

    /**
     * Devuelve el rango de una palabra en el orden alfabético.
     *
     * @param palabra La palabra a buscar.
     * @return El rango de la palabra.
     */
    public int rangoPalabra(String palabra) {
        return palabrasOrdenadas.rank(palabra);
    }

    /**
     * Devuelve un String con todas las palabras almacenadas sin repetir.
     *
     * @return Un String con todas las palabras en la estructura de datos.
     */
    public String mostrarPalabrasSinRepetir() {
        String palabras = "";
        for (String palabra : palabrasOrdenadas.keys()) {
            palabras += palabra + "\n";

        }
        return palabras;
    }

}
