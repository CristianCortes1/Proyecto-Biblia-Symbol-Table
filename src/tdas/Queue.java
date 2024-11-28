package tdas;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Cristian Cortes
 * @author David Chacon
 * @author Juan Coronado
 * @author Moiguel Ardila
 */
/**
 * Esta clase implementa una cola FIFO (First-In-First-Out) usando una lista
 * enlazada simple.
 * 
 * En una cola FIFO, el primer elemento agregado (enqueue) es el primero en ser
 * eliminado (dequeue).
 *
 * @author (desconocido)
 * @param <Item> El tipo de elemento que se almacena en la cola.
 */
public class Queue<Item> implements Iterable<Item> {

    /**
     * Referencia al primer nodo de la cola.
     */
    private Node first;

    /**
     * Referencia al último nodo de la cola.
     */
    private Node last;

    /**
     * Cantidad de elementos en la cola.
     */
    private int count;

    /**
     * Clase interna que representa un nodo de la lista enlazada.
     */
    private class Node {

        /**
         * Elemento almacenado en el nodo.
         */
        Item item;

        /**
         * Referencia al siguiente nodo en la lista.
         */
        Node next;
    }

    /**
     * Crea una cola vacía.
     */
    public Queue() {
        this.first = null;
        this.last = null;
        count = 0;
    }

    /**
     * Agrega un elemento a la cola (al final).
     * 
     * @param item El elemento a agregar.
     */
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;

        }
        count++;
    }

    /**
     * Elimina y devuelve el elemento frontal de la cola (el primer elemento
     * agregado).
     * 
     * @return el elemento eliminado de la cola.
     * @throws NoSuchElementException Si la cola está vacía.
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        Item item = first.item;
        first.item = null;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        count--;
        return item;
    }

    /**
     * Devuelve el elemento frontal de la cola (el primer elemento agregado) sin
     * eliminarlo.
     * 
     * @return el elemento frontal de la cola.
     * @throws NoSuchElementException Si la cola está vacía.
     */
    public Item front() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return first.item;
    }

    /**
     * Devuelve el elemento final de la cola (el último elemento agregado) sin
     * eliminarlo.
     * 
     * @return el elemento final de la cola.
     * @throws NoSuchElementException Si la cola está vacía.
     */
    public Item back() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return last.item;
    }

    /**
     * Comprueba si la cola está vacía.
     * 
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Devuelve el número de elementos en la cola.
     * 
     * @return la cantidad de elementos en la cola.
     */
    public int size() {
        return count;
    }

    /**
     * Devuelve un iterador para recorrer los elementos de la cola en el orden de
     * inserción.
     * 
     * @return un iterador que permite recorrer la cola.
     */
    @Override
    public Iterator<Item> iterator() {
        return new LLIterator();
    }

    /**
     * Clase interna que implementa la interfaz Iterator para recorrer la cola.
     */
    private class LLIterator implements Iterator<Item> {

        /**
         * Referencia al nodo actual en la iteración, comenzando por el primer nodo de
         * la cola.
         */
        private Node current = first;

        /**
         * Comprueba si hay un siguiente elemento en la iteración.
         * 
         * @return true si hay un elemento más en la cola, false en caso contrario.
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Devuelve el siguiente elemento en la iteración y avanza al siguiente nodo.
         * 
         * @return el siguiente elemento en la cola.
         * @throws NoSuchElementException Si se llama al método `next()` cuando no hay
         *                                más elementos en la cola.
         */
        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("La cola está vacía");
            }
            Item item = current.item;
            current = current.next;
            return item;

        }
    }
}
