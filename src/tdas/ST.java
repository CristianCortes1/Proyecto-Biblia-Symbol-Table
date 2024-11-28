package tdas;

/**
 * @author Cristian Cortes
 * @author David Chacon
 * @author Juan Coronado
 * @author Miguel Ardila
 */

/**
 * Clase abstracta para una tabla de símbolos genérica.
 * Proporciona la estructura básica para almacenar pares clave-valor.
 *
 * @param <Key>   el tipo de las claves, que deben ser comparables
 * @param <Value> el tipo de los valores asociados a las claves
 */
public abstract class ST<Key extends Comparable<Key>, Value> {

    /**
     * Arreglo para almacenar las claves.
     */
    protected Key[] keys;

    /**
     * Arreglo para almacenar los valores asociados a las claves.
     */
    protected Value[] values;

    /**
     * Número de pares clave-valor almacenados en la tabla.
     */
    protected int count;

    /**
     * Constructor que inicializa la tabla de símbolos con un tamaño inicial fijo.
     */
    @SuppressWarnings("unchecked")
    public ST() {
        keys = (Key[]) new Comparable[10];
        values = (Value[]) new Object[10];
        count = 0;
    }

    /**
     * Cambia el tamaño de los arreglos subyacentes para ajustarse a una nueva
     * capacidad.
     * 
     * @param capacity el nuevo tamaño de los arreglos
     */
    @SuppressWarnings("unchecked")
    protected void resize(int capacity) {
        Key[] newKeys = (Key[]) new Comparable[capacity];
        Value[] newValues = (Value[]) new Object[capacity];
        for (int i = 0; i < count; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        keys = newKeys;
        values = newValues;
    }

    /**
     * Inserta un par clave-valor en la tabla.
     * Si el valor es {@code null}, elimina la clave de la tabla.
     * 
     * @param key la clave a insertar o actualizar
     * @param val el valor asociado a la clave
     * @throws IllegalArgumentException si la clave es {@code null}
     */
    public abstract void put(Key key, Value val);

    /**
     * Obtiene el valor asociado a una clave.
     * 
     * @param key la clave a buscar
     * @return el valor asociado a la clave, o {@code null} si no existe
     * @throws IllegalArgumentException si la clave es {@code null}
     */
    public abstract Value get(Key key);

    /**
     * Elimina una clave y su valor asociado de la tabla.
     * 
     * @param key la clave a eliminar
     * @throws IllegalArgumentException si la clave es {@code null}
     */
    public abstract void delete(Key key);

    /**
     * Verifica si una clave está presente en la tabla.
     * 
     * @param key la clave a buscar
     * @return {@code true} si la clave está presente, {@code false} en caso
     *         contrario
     * @throws IllegalArgumentException si la clave es {@code null}
     */
    public abstract boolean contains(Key key);

    /**
     * Obtiene todas las claves almacenadas en la tabla en orden de inserción.
     * 
     * @return un iterable con todas las claves
     */
    public Iterable<Key> keys() {
        Queue<Key> cola = new Queue<>();
        for (int i = 0; i < count; i++) {
            cola.enqueue(keys[i]);
        }
        return cola;
    }

    /**
     * Verifica si la tabla está vacía.
     * 
     * @return {@code true} si la tabla está vacía, {@code false} en caso contrario
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Obtiene el número de pares clave-valor almacenados en la tabla.
     * 
     * @return el número de pares clave-valor
     */
    public int size() {
        return count;
    }
}
