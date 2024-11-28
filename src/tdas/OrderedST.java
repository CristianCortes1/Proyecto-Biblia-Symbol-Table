package tdas;

/**
 * @author Cristian Cortes
 * @author David Chacon
 * @author Juan Coronado
 * @author Miguel Ardila
 */

/**
 * Implementación de una tabla de símbolos ordenada utilizando arreglos.
 *
 * @param <Key>   el tipo de las claves, que deben ser comparables
 * @param <Value> el tipo de los valores asociados a las claves
 */
public class OrderedST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {

    /**
     * Constructor para crear una tabla de símbolos ordenada.
     */
    public OrderedST() {
        super();
    }

    /**
     * Inserta un par clave-valor en la tabla. Si el valor es {@code null}, elimina
     * la clave.
     * Si la clave ya existe, actualiza su valor.
     *
     * @param key la clave a insertar o actualizar
     * @param val el valor asociado a la clave, o {@code null} para eliminar
     * @throws IllegalArgumentException si la clave es {@code null}
     */
    @Override
    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int i = rank(key);
        if (i < count && keys[i].compareTo(key) == 0) {
            if (val == null) {
                delete(key);
            } else {
                values[i] = val;
            }
        } else {
            if (val != null) {
                if (count == keys.length) {
                    resize(2 * keys.length);
                }
                for (int j = count; j > i; j--) {
                    keys[j] = keys[j - 1];
                    values[j] = values[j - 1];
                }
                keys[i] = key;
                values[i] = val;
                count++;
            }
        }
    }

    /**
     * Obtiene el valor asociado a una clave.
     *
     * @param key la clave a buscar
     * @return el valor asociado, o {@code null} si la clave no existe
     * @throws IllegalArgumentException si la clave es {@code null}
     */
    @Override
    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int i = rank(key);
        if (i < count && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
    }

    /**
     * Elimina una clave y su valor asociado de la tabla.
     *
     * @param key la clave a eliminar
     * @throws IllegalArgumentException si la clave es {@code null}
     */
    @Override
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int i = rank(key);
        if (i < count && keys[i].compareTo(key) == 0) {
            for (int j = i; j < count - 1; j++) {
                keys[j] = keys[j + 1];
                values[j] = values[j + 1];
            }
            keys[count - 1] = null;
            values[count - 1] = null;
            count--;
            if (count > 0 && count == keys.length / 4) {
                resize(keys.length / 2);
            }
        }
    }

    /**
     * Verifica si una clave está en la tabla.
     *
     * @param key la clave a verificar
     * @return {@code true} si la clave está presente, {@code false} en caso
     *         contrario
     * @throws IllegalArgumentException si la clave es {@code null}
     */
    @Override
    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        return get(key) != null;
    }

    /**
     * Obtiene la clave más pequeña en la tabla.
     *
     * @return la clave más pequeña
     * @throws IllegalStateException si la tabla está vacía
     */
    public Key min() {
        if (isEmpty()) {
            throw new IllegalStateException("Table is empty");
        }
        return keys[0];
    }

    /**
     * Obtiene la clave más grande en la tabla.
     *
     * @return la clave más grande
     * @throws IllegalStateException si la tabla está vacía
     */
    public Key max() {
        if (isEmpty()) {
            throw new IllegalStateException("Table is empty");
        }
        return keys[count - 1];
    }

    /**
     * Obtiene la clave más grande menor o igual a la clave dada.
     *
     * @param key la clave de referencia
     * @return la clave más grande menor o igual a {@code key}, o {@code null} si no
     *         existe
     * @throws IllegalArgumentException si la clave es {@code null}
     */
    public Key floor(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int i = rank(key);
        if (i < count && keys[i].compareTo(key) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        }
        return keys[i - 1];
    }

    /**
     * Obtiene la clave más pequeña mayor o igual a la clave dada.
     *
     * @param key la clave de referencia
     * @return la clave más pequeña mayor o igual a {@code key}, o {@code null} si
     *         no existe
     * @throws IllegalArgumentException si la clave es {@code null}
     */
    public Key ceiling(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int i = rank(key);
        if (i == count) {
            return null;
        }
        return keys[i];
    }

    /**
     * Calcula la posición de una clave en la tabla.
     *
     * @param key la clave de referencia
     * @return la posición de la clave en la tabla
     * @throws IllegalArgumentException si la clave es {@code null}
     */
    public int rank(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        return rank(key, 0, count - 1);
    }

    /**
     * Calcula la posición de una clave en un rango.
     *
     * @param key la clave de referencia
     * @param lo  el índice inferior del rango
     * @param hi  el índice superior del rango
     * @return la posición de la clave en el rango
     */
    private int rank(Key key, int lo, int hi) {
        if (hi < lo) {
            return lo;
        }
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rank(key, lo, mid - 1);
        } else if (cmp > 0) {
            return rank(key, mid + 1, hi);
        } else {
            return mid;
        }
    }

    /**
     * Obtiene la clave de rango {@code k}.
     *
     * @param k el índice de la clave
     * @return la clave en la posición {@code k}
     * @throws IllegalArgumentException si {@code k} está fuera de rango
     */
    public Key select(int k) {
        if (k < 0 || k >= count) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        return keys[k];
    }

    /**
     * Elimina la clave más pequeña de la tabla.
     *
     * @throws IllegalStateException si la tabla está vacía
     */
    public void deleteMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Table is empty");
        }
        delete(min());
    }

    /**
     * Elimina la clave más grande de la tabla.
     *
     * @throws IllegalStateException si la tabla está vacía
     */
    public void deleteMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Table is empty");
        }
        delete(max());
    }

    /**
     * Obtiene el número de claves en el rango [lo..hi].
     *
     * @param lo la clave inferior del rango
     * @param hi la clave superior del rango
     * @return el número de claves en el rango
     * @throws IllegalArgumentException si alguna clave es {@code null}
     */
    public int size(Key lo, Key hi) {
        if (lo == null || hi == null) {
            throw new IllegalArgumentException("Keys cannot be null");
        }
        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        return rank(hi) - rank(lo) + (contains(hi) ? 1 : 0);
    }

    /**
     * Obtiene todas las claves en el rango [lo..hi], en orden.
     *
     * @param lo la clave inferior del rango
     * @param hi la clave superior del rango
     * @return un iterable con las claves en el rango
     * @throws IllegalArgumentException si alguna clave es {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null || hi == null) {
            throw new IllegalArgumentException("Keys cannot be null");
        }
        if (lo.compareTo(hi) > 0) {
            return new Queue<>();
        }
        Queue<Key> cola = new Queue<>();
        for (int i = rank(lo); i < rank(hi) + (contains(hi) ? 1 : 0); i++) {
            if (keys[i] != null) {
                cola.enqueue(keys[i]);
            }
        }
        return cola;
    }

}
