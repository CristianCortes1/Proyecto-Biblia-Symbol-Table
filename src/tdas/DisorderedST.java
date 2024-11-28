package tdas;

/**
 * @author Cristian Cortes
 * @author David Chacon
 * @author Juan Coronado
 * @author Miguel Ardila
 */

/**
 * Implementación de una tabla de símbolos desordenada utilizando arreglos.
 * 
 * @param <Key>   el tipo de las claves, que deben ser comparables
 * @param <Value> el tipo de los valores asociados a las claves
 */
public class DisorderedST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {

    /**
     * Constructor para inicializar los arreglos internos.
     */
    public DisorderedST() {
        super();
    }

    /**
     * Inserta un par clave-valor en la tabla. Si el valor es {@code null}, elimina la clave.
     * Si la clave ya existe, actualiza su valor.
     *
     * @param key la clave a insertar o actualizar
     * @param val el valor asociado a la clave, o {@code null} para eliminar
     * @throws IllegalArgumentException si la clave es {@code null}
     */
    @Override
    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("Key no puede ser nula");
        }
        int index = indexOf(key);

        if (val == null) {
            if (index != -1) {
                delete(key);
            }
            return;
        }

        if (index != -1) {
            values[index] = val;
        } else {
            if (count == keys.length) {
                resize(2 * keys.length);
            }
            keys[count] = key;
            values[count] = val;
            count++;
        }
    }

    /**
     * Obtiene el valor asociado a una clave.
     *
     * @param key la clave a buscar
     * @return el valor asociado, o {@code null} si la clave no existe
     */
    @Override
    public Value get(Key key) {
        int index = indexOf(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    /**
     * Elimina una clave y su valor asociado de la tabla.
     *
     * @param key la clave a eliminar
     */
    @Override
    public void delete(Key key) {
        int index = indexOf(key);
        if (index == -1) return;

        keys[index] = keys[count - 1];
        values[index] = values[count - 1];
        keys[count - 1] = null;
        values[count - 1] = null;
        count--;

        if (count > 0 && count == keys.length / 4) resize(keys.length / 2);
    }

    /**
     * Verifica si una clave está presente en la tabla.
     *
     * @param key la clave a verificar
     * @return {@code true} si la clave está presente, {@code false} en caso contrario
     */
    @Override
    public boolean contains(Key key) {
        return indexOf(key) != -1;
    }

    /**
     * Encuentra el índice de una clave en la tabla.
     *
     * @param key la clave a buscar
     * @return el índice de la clave si existe, o -1 si no existe
     */
    private int indexOf(Key key) {
        for (int i = 0; i < count; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
