package dev.boccuti.www.cisc213.lab3;

/**
 * Implementation of Lab #3 for CISC 213 that implements a deque using a Doubly
 * Linked List design and avoids using any Java built-in classes for Deque.
 * 
 * @author Jason Boccuti | jason@boccuti.dev
 */
public class BoccutiLabThree {

    /**
     * Main method that produces the testing output for the Lab.
     * 
     * @param args
     */
    public static void main(String args[]) {
        JBDeque<String> deque = new JBDeque<String>();

        System.out.println(deque.buildDequeString());

        // Test peaking empty deque
        deque.peekFront();
        deque.peekRear();
        // Test polling empty deque
        deque.pollFront();
        deque.pollRear();
        // Add to front and rear
        deque.addFront("Apple");
        deque.addRear("Banana");
        deque.addFront("Orange");
        deque.addRear("Kiwi");
        // Peek front and rear
        deque.peekFront();
        deque.peekRear();
        // Poll front and rear
        deque.pollFront();
        deque.peekFront();
        deque.pollRear();
        deque.peekRear();
        // Add to front and rear to ensure nothing broke
        deque.addFront("Mango");
        deque.addFront("Plum");
        deque.addRear("Blueberries");
    }
}
