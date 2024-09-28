import java.util.Comparator;
import java.util.PriorityQueue;

public class Priority_Queue {
    public static void main(String[] args) {
        // Priority Queue in JCF --------------------------------
        // Priority Queue is not a FIFO Data structure.
        // PriorityQueue<Integer> pq = new PriorityQueue<>(); // Priority (Min element)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // Priority (Max element)
        // Comparator - Interface 
        // reverseOrder - Function
        // Add - TC -> O(logn) 
        pq.add(2);
        pq.add(3);
        pq.add(1);
        pq.add(4);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek()); // Peek - TC -> O(logn)
            pq.remove(); // Remove - TC -> O(1)
        }
        // Accending Order - Output -> 1,2,3,4
        // Decending Order - Output -> 4,3,2,1

    }
}