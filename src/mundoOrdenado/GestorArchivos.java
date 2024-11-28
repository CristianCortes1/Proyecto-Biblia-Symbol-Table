package mundoOrdenado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import tdas.ST;

/**
 * @author Cristian Cortes
 * @author David Chacon
 * @author Juan Coronado
 * @author Miguel Ardila
 */

/**
 * Esta clase se encarga de gestionar la lectura de archivos de texto. 
 * En particular, proporciona un método para leer un archivo de texto específico
 * y extraer las palabras que contiene, almacenándolas en una cola.
 */
public class GestorArchivos {

    /**
     * Lee las palabras de un archivo de texto y las almacena en una cola.
     *
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public static void obtenerPalabras(ST<String, Integer> palabrasTxt) throws IOException {
        if (palabrasTxt == null) {
            throw new IllegalArgumentException("La estructura de datos palabrasTxt no puede ser nula.");
        }
        String ruta = new File("Biblia.txt").getAbsolutePath();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabrasLinea = linea.split(" ");
                for (String palabra : palabrasLinea) {
                    palabra = palabra.trim();
                    if (!palabra.isEmpty()) {
                        if (palabrasTxt.contains(palabra)) {
                            palabrasTxt.put(palabra, palabrasTxt.get(palabra) + 1);
                        } else {
                            palabrasTxt.put(palabra, 1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new IOException("Error al leer el archivo: " + ruta, e);
        }
    }
}
