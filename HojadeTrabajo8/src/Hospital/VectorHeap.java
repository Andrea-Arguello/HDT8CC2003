/*
 * VectorHeap.java
 * Vector Heap que implementa PrioirityQueue
 * Ana Lucia Hernandez 17138
 * Andrea Arguello 17801
 */
package Hospital;

import java.util.*;

/**
 *
 * @author Ana Lucia Hernandez (17138).
 * @author Andrea Arguello (17801). 
 * @param <E> Object
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>
{

    protected Vector<E> data; // the data, kept in heap order

    public VectorHeap()
    // post: constructs a new priority queue
    {
        data = new Vector<E>();
    }
    /**
     * 
     * @param v: vector a agregar
     */
    public VectorHeap(Vector<E> v)
    // post: constructs a new priority queue from an unordered vector
    {
        int i;
        data = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++)
        { // add elements to heap
            add(v.get(i));
        }
    }
    /**
     * 
     * @param i: indice de nodo
     * @return indice de padre
     */
    protected static int parent(int i)
    // pre: 0 <= i < size
    // post: returns parent of node at location i
    {
        return (i-1)/2;
    }
    /**
     * 
     * @param i: indice de padre
     * @return indice de hijo izquierdo del nodo
     */
    protected static int left(int i)
    // pre: 0 <= i < size
    // post: returns index of left child of node at location i
    {
        return 2*i+1;
    }
    /**
     * 
     * @param i: indice de padre
     * @return indice de hijo derecho del nodo
     */
    protected static int right(int i)
    // pre: 0 <= i < size
    // post: returns index of right child of node at location i
    {
        return (2*i+1) + 1;
    }
    /**
     * 
     * @param leaf : indice de hoja a mover
     */
    protected void percolateUp(int leaf)
    // pre: 0 <= leaf < size
    // post: moves node at index leaf up to appropriate position
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
        (value.compareTo(data.get(parent)) < 0))
        {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }
    /**
     * 
     * @param value : objeto a agregar al vectorheap
     */
    public void add(E value)
    // pre: value is non-null comparable
    // post: value is added to priority queue
    {
        data.add(value);
        percolateUp(data.size()-1);
    }
    /**
     * 
     * @param root : indice del nodo
     */
    protected void pushDownRoot(int root)
    // pre: 0 <= root < size
    // post: moves node at index root down
    // to appropriate position in subtree
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                ((data.get(childpos+1)).compareTo
                (data.get(childpos)) < 0))
                {
                    childpos++;
                }
            // Assert: childpos indexes smaller of two children
            if ((data.get(childpos)).compareTo
                (value) < 0)
            {
                data.set(root,data.get(childpos));
                root = childpos; // keep moving down
            } else { // found right location
                data.set(root,value);
                return;
            }
            } else { // at a leaf! insert and halt
                data.set(root,value);
                return;
            }
        }
    }
    /**
     * 
     * @return : objeto de la primera posicion del vector heap
     */
    public E getFirst()
    // pre: !isEmpty()
    // post: returns the minimum value in the priority queue
    {
        return data.get(0);
    }
    /**
     * 
     * @return : objeto removido 
     */
    public E remove()
    // pre: !isEmpty()
    // post: returns and removes minimum value from queue
    {
        E minVal = getFirst();
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    /**
     * 
     * @return boolean de si está vacío o no
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
    
    /**
     * 
     * @return el tamaño del actual
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Vacia el Vector
     */
    @Override
    public void clear() {
        data.clear();
    }
}