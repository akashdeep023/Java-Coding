import java.util.*;
import java.util.LinkedList;

public class DequeC {
    public static void main(String[] args) {
        // Deque (Double ended Queue) --------------------------------
        // Deque -> (Data structure) 
        // Dequeue -> Verb / Action / Method (Remove the first element from the queue)
        // Enqueue -> Verb / Action / Method (Add the last element to the queue)
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1); // add first
        deque.addFirst(2);
        deque.addLast(3); // add last
        deque.addLast(4);
        System.out.println(deque); // 2 1 3 4
        deque.removeFirst(); // remove first
        System.out.println(deque); // 1 3 4
        deque.removeLast(); // remove last
        System.out.println(deque); // 1 3 
        System.out.println("First element : " + deque.getFirst());
        System.out.println("Last element : " + deque.getLast());

    }
}
