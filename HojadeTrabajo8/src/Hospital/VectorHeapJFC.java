/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

import java.util.Vector;
import java.util.PriorityQueue;
/**
 *
 * @author anahernandez
 * @param <E> Object
 */
public class VectorHeapJFC<E extends Comparable<E>> extends PriorityQueue<E> {

    /**
     * The data, kept in heap order.
     */
    protected Vector<E> data;  // the data, kept in heap order

    /**
     * Construct a new priority queue
     *
     */
    public VectorHeapJFC()
    //post:constructs a new priority queue
    {
        data = new Vector<E>();
    }

    /**
     * Construct a new priority queue from an unordered vector
     *
     * @param v vector of objects
     */
    public VectorHeapJFC(Vector<E> v)
    //post:constructs a new priority queue from an unordered vector
    {
        int i;
        data = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++) {   // add elements to heap
            add(v.get(i));
        }
    }

    /**
     * Returns parent index
     *
     * @param i a node index
     * @return parent of node at i
     */
    protected static int parent(int i)
    //pre: 0 <= i < size
    //post: returns parent of node at location i
    {
        return (i - 1) / 2;
    }

    /**
     * Returns left child index.
     *
     * @param i a node index
     * @return left child of node at i
     */
    protected static int left(int i)
    //pre:0 <= i < size
    //post:returns index of left child of node at location i
    {
        return 2 * i + 1;
    }

    /**
     * Returns right child index.
     *
     * @param i a node index
     * @return right child of node at i
     */
    protected static int right(int i)
    //pre:0 <= i < size
    //post:returns index of right child of node at location i
    {
        return 2 * (i + 1);
    }

    /**
     * Fetch lowest valued (highest priority) item from queue.
     *
     *
     * @return The smallest value from queue.
     */
    public E getFirst()
    //pre:!isEmpty()
    //post:returns minimum value from queue
    {
        return data.get(0);
    }

    /**
     * Returns the minimum value from the queue.
     *
     *
     * @return The minimum value in the queue.
     */
    public E remove()
    //pre:!isEmpty()
    //post:returns and removes minimum value from queue
    {
        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) {
            pushDownRoot(0);
        }
        return minVal;
    }

    /**
     * Determine if the queue is empty.
     *
     * @return True if the queue is empty.
     */
    public boolean isEmpty()
    //post:returns true iff no elements are in queue
    {
        return data.size() == 0;
    }

    /**
     * Moves node upward to appropriate position within heap.
     *
     * @param leaf Index of the node in the heap.
     */
    protected void percolateUp(int leaf)
    //pre:0 <= leaf < size
    //post:moves node at index leaf up to appropriate position
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0
                && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    /**
     * Moves node downward, into appropriate position within subheap.
     *
     * @param root Index of the root of the subheap.
     */
    protected void pushDownRoot(int root)
    //pre:0 <= root < size
    //post:moves node at index root down to appropriate position in subtree
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize)
                        && ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root, value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * Determine the size of the queue.
     *
     * @return The number of elements within the queue.
     */
    public int size()
    //post: returns number of elements within queue
    {
        return data.size();
    }

    /**
     * Remove all the elements from the queue.
     */
    public void clear()
    //post: removes all elements from queue
    {
        data.clear();
    }

    /**
     * Construct a string representation of the heap.
     *
     *
     * @return The string representing the heap.
     */
    public String toString()
    //post returns string representation of heap
    {
        return "<VectorHeap: " + data + ">";
    }
}
