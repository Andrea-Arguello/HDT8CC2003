/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

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
     */
    @Test
    public void testGetFirst() {
    }

    /**
     * Test of remove method, of class VectorHeap.
     */
    @Test
    public void testRemove() {
        Vector<String> lista = new Vector<>();
        lista.add("1");
        lista.add("2");
        VectorHeap heap = new VectorHeap(lista);
        heap.remove();
        assertEquals(heap.size(),1);
    }

    /**
     * Test of isEmpty method, of class VectorHeap.
     */
    @Test
    public void testIsEmpty() {
        Vector<String> lista = new Vector<>();
        lista.add("1");
        lista.add("2");
        VectorHeap heap = new VectorHeap(lista);
        
        assertEquals(heap.isEmpty(),false);
    }

    /**
     * Test of size method, of class VectorHeap.
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
     */
    @Test
    public void testClear() {
        
    }
    
}
