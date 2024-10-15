package dev.boccuti.www.cisc213.lab3;

/**
 * Implementation of a Deque in Java using a Doubly Linked List that supports
 * adding/removing/peeking from the front and rear of the queue.
 * 
 * @author Jason Boccuti | jason@boccuti.dev
 */
public class JBDeque<T> {

    private JBNode<T> front;
    private JBNode<T> rear;
    private int size;

    /**
     * Constructor of the Deque that sets the front/rear to null and size to 0.
     */
    public JBDeque() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    /**
     * Add a node to the front of the deque.
     * 
     * @param key data for the node
     */
    public void addFront(T key) {
        JBNode<T> newNode = new JBNode<T>(key);

        // If the deque is empty, the new node becomes the front + rear
        if (this.isEmpty()) {
            this.front = newNode;
            this.rear = newNode;
        }
        // Else, the new node's next is set to the current front and the current front's
        // prev is set to the new node, then the front is officially set to the new node
        else {
            newNode.next = this.front;
            this.front.prev = newNode;
            this.front = newNode;
        }
        // Increase the size of the deque
        this.size++;

        System.out.println("Adding \"" + key + "\" to front of deque:\n" + this.buildDequeString());
    }

    /**
     * Add a node to the rear of the deque
     * 
     * @param key data for the node
     */
    public void addRear(T key) {
        JBNode<T> newNode = new JBNode<T>(key);

        // If the deque is empty, the new node becomes the front + rear
        if (this.isEmpty()) {
            this.front = newNode;
            this.rear = newNode;
        }
        // Else, the new node's prev is set to the current rear and the current rear's
        // next is set to the new node, then the rear is officially set to the new node
        else {
            newNode.prev = this.rear;
            this.rear.next = newNode;
            this.rear = newNode;
        }
        // Increase the size of the deque
        this.size++;

        System.out.println("Adding \"" + key + "\" to rear of deque:\n" + this.buildDequeString());
    }

    /**
     * Peek the data in the front node of the deque.
     */
    public void peekFront() {
        // If the deque is empty, can't peek
        if (this.isEmpty()) {
            System.out.println("Deque is empty, can't peek front");
        }
        // Else, peek the front node
        else {
            System.out.println("Peeking front of deque, found node: \"" + this.front.data + "\"");
        }
    }

    /**
     * Peek the data in the rear node of the deque.
     */
    public void peekRear() {
        // If the deque is empty, can't peek
        if (this.isEmpty()) {
            System.out.println("Deque is empty, can't peek rear");
        }
        // Else, peek the rear node
        else {
            System.out.println("Peeking rear of deque, found node: \"" + this.rear.data + "\"");
        }
    }

    /**
     * Poll (remove) the front node of the deque.
     */
    public void pollFront() {
        // If the deque is empty, can't poll
        if (this.isEmpty()) {
            System.out.println("Can't poll front of deque as deque is empty");
        }
        // Else, poll (remove) the front node by setting the front pointer to the
        // current front node's next
        else {
            System.out.println("Polling (removing) front of deque: \"" + this.front.data + "\"");
            // Remove Front
            this.front = this.front.next;
            // Decrease the size of the deque
            this.size--;
            System.out.println(this.buildDequeString());
        }
    }

    /**
     * Poll (remove) the rear node of the deque.
     */
    public void pollRear() {
        // If the deque is empty, can't poll
        if (this.isEmpty()) {
            System.out.println("Can't poll rear of deque as deque is empty");
        }
        // Else, poll (remove) the rear node by setting the rear pointer to the current
        // rear node's prev
        else {
            System.out.println("Polling (removing) rear of deque: \"" + this.rear.data + "\"");
            // Remove rear
            this.rear = this.rear.prev;
            // Decrease the size of the deque
            this.size--;
            System.out.println(this.buildDequeString());
        }
    }

    /**
     * Method to check if the deque is currently empty;
     * 
     * @return a boolean of whether the deque is empty or not
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Method to check the size of the deque.
     * 
     * @return the deque's size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Build a string representation of the deque to show the front, rear and the
     * order of all the nodes.
     * 
     * @return the string to be displayed
     */
    public String buildDequeString() {
        String dequeStr = "";
        JBNode<T> currNode = this.front;

        dequeStr += "[DEQUE size = " + this.size + "] FRONT --> [";

        for (int i = 0; i < this.size; i++) {

            if (i != 0 && i != this.size) {
                dequeStr += ", ";
            }
            dequeStr += currNode.data;
            currNode = currNode.next;
        }

        dequeStr += "] <-- REAR";

        String spacer = "-".repeat(dequeStr.length());

        dequeStr = spacer + "\n" + dequeStr + "\n" + spacer;

        return dequeStr;
    }
}
