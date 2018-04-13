/*
 * VectorHeapNGTest.java
 * JUnitTest de la clase VectorHeap
 * Ana Lucia Hernandez 17138
 * Andrea Arguello 17801
 */

import java.util.Vector;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author cooli
 */
public class VectorHeapNGTest {
    
    public VectorHeapNGTest() {
    }

    /**
     * Test of parent method, of class VectorHeap.
     */
    @Test
    public void testParent() {
    }

    /**
     * Test of left method, of class VectorHeap.
     */
    @Test
    public void testLeft() {
    }

    /**
     * Test of right method, of class VectorHeap.
     */
    @Test
    public void testRight() {
    }

    /**
     * Test of percolateUp method, of class VectorHeap.
     */
    @Test
    public void testPercolateUp() {
    }

    /**
     * Test of add method, of class VectorHeap.
     */
    @Test
    public void testAdd() {
    }

    /**
     * Test of pushDownRoot method, of class VectorHeap.
     */
    @Test
    public void testPushDownRoot() {
    }

    /**
     * Test of getFirst method, of class VectorHeap.
     * Devuelve el primer elemento de la lista
     */
    @Test
    public void testGetFirst() {
        Vector<String> lista = new Vector<>();
        lista.add("3");
        lista.add("2");
        VectorHeap heap = new VectorHeap(lista);
        //A pesar de haber sido añadido de segundo, 2 debería ser el primer elemento por comparación
        assertEquals(heap.getFirst(),"2");
    }

    /**
     * Test of remove method, of class VectorHeap.
     * Elimina el primer elemento de la lista
     */
    @Test
    public void testRemove() {
        Vector<String> lista = new Vector<>();
        lista.add("1");
        lista.add("2");
        VectorHeap heap = new VectorHeap(lista);
        heap.remove();
        //El resultado debería ser dos, ya que se elimino el elemento de principal prioridad
        assertEquals(heap.getFirst(),"2");
    }

    /**
     * Test of isEmpty method, of class VectorHeap.
     * El metodo devuelve true si esta vacio, falso si no
     */
    @Test
    public void testIsEmpty() {
        Vector<String> lista = new Vector<>();
        lista.add("1");
        lista.add("2");
        VectorHeap heap = new VectorHeap(lista);
        //El resultado debería ser falso, ya que se estan ingresando valores al heap
        assertEquals(heap.isEmpty(),false);
    }

    /**
     * Test of size method, of class VectorHeap.
     * Devuelve la cantidad de elementos en el heap
     */
    @Test
    public void testSize() {
        Vector<String> lista = new Vector<>();
        lista.add("1");
        lista.add("2");
        VectorHeap heap = new VectorHeap(lista);
        assertEquals(heap.size(),2);
    }

    /**
     * Test of clear method, of class VectorHeap.
     * Vacia el heap.
     */
    @Test
    public void testClear() {
        Vector<String> lista = new Vector<>();
        lista.add("1");
        lista.add("2");
        VectorHeap heap = new VectorHeap(lista);
        heap.clear();
        assertEquals(heap.size(),0);
    }
    
}
