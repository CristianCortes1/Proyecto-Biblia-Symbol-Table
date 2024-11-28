package mundoOrdenado;

import java.io.IOException;
import tdas.DisorderedST;

/**
 * @author Cristian Cortes
 * @author David Chacon
 * @author Juan Coronado
 * @author Miguel Ardila
 */

/**
 * Esta clase representa una Biblia que utiliza una estructura de datos
 * desordenada
 * para almacenar palabras y sus frecuencias. Permite realizar diversas
 * operaciones
 * como buscar palabras, contar palabras únicas y obtener la palabra con mayor
 * frecuencia,
 * utiliza una tabla de símbolos desordenada (DisorderedST) para gestionar las
 * palabras.
 */
public class BibliaDesordenada {
    /**
     * Tabla de símbolos desordenada que mapea palabras a sus frecuencias.
     */
    private DisorderedST<String, Integer> palabrasDesordenadas;

    /**
     * Constructor de la clase BibliaDesordenada. Inicializa las estructuras de
     * datos
     * y carga las palabras del archivo.
     * 
     * @throws IOException Si ocurre un error al leer las palabras del archivo.
     */
    public BibliaDesordenada() throws IOException {
        palabrasDesordenadas = new DisorderedST<>();
    }

    /**
     * Llena la tabla de símbolos desordenada con las palabras del texto.
     * Calcula y almacena las frecuencias de cada palabra en la tabla de símbolos.
     * 
     * @throws IOException
     */
    public void llenarDisorderedST() throws IOException {
        GestorArchivos.obtenerPalabras(palabrasDesordenadas);
    }

    /**
     * Busca la frecuencia de una palabra en el texto.
     *
     * @param palabra La palabra a buscar.
     * @return La frecuencia de la palabra, o 0 si no se encuentra.
     */
    public Integer buscarFrecuenciaDeUnaPalabra(String palabra) {
        return palabrasDesordenadas.get(palabra);
    }

    /**
     * Devuelve el número total de palabras en el texto.
     *
     * @return El número total de palabras.
     */
    public int palabrasTotales() {
        return palabrasDesordenadas.size();
    }

    /**
     * Devuelve un String con todas las palabras únicas encontradas.
     *
     * @return Un String con todas las palabras únicas.
     */
    public String palabrasUnicas() {
        String palabrasUnicas = "";
        for (String palabra : palabrasDesordenadas.keys()) {
            if (palabrasDesordenadas.get(palabra) == 1) {
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
        for (String palabra : palabrasDesordenadas.keys()) {
            if (palabrasDesordenadas.get(palabra) == 1) {
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
        for (String palabra : palabrasDesordenadas.keys()) {
            if (palabrasDesordenadas.get(palabra) > mayorFrecuencia) {
                mayorFrecuencia = palabrasDesordenadas.get(palabra);
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
        for (String palabra : palabrasDesordenadas.keys()) {
            if (palabrasDesordenadas.get(palabra) > mayorFrecuencia) {
                mayorFrecuencia = palabrasDesordenadas.get(palabra);
            }
        }
        return mayorFrecuencia;
    }

    /**
     * Devuelve una palabra y su frecuencia en formato de cadena.
     *
     * @return Una cadena con una palabra y su frecuencia.
     */
    public String palabraValor() {
        String palabraValor = "";
        for (String palabra : palabrasDesordenadas.keys()) {
            palabraValor += palabra + "," + palabrasDesordenadas.get(palabra) + "\n";
        }
        return palabraValor;
    }

/**
 * Devuelve un String con todas las palabras almacenadas sin repetir.
 *
 * @return Un String con todas las palabras en la estructura de datos.
 */
    public String mostrarPalabrasSinRepetir() {
        String palabras = "";
        for (String palabra : palabrasDesordenadas.keys()) {
            palabras += palabra + "\n";

        }
        return palabras;
    }
}
