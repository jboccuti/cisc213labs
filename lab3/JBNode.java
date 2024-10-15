package dev.boccuti.www.cisc213.lab3;

/**
 * Node implementation for a Doubly Linked List that utilizes generics for type.
 * 
 * @author Jason Boccuti | jason@boccuti.dev
 */
public class JBNode<T> {

    public T data;
    public JBNode<T> next;
    public JBNode<T> prev;

    /**
     * Constructor for Node class, initializes the provided data and sets the
     * next/prev pointers to null;
     * 
     * @param data
     */
    public JBNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
