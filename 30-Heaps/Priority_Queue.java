import java.util.Comparator;
import java.util.PriorityQueue;

public class Priority_Queue {
    // Create Student Class (Student uses Comparable Interface of Student)
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override // Override campareTo function
        public int compareTo(Student s2) { // compareTo function in Comparable<Student> Interface
            return this.rank - s2.rank; // Rank base Sort
            // this.rank - s2.rank = -ve => this < s2
            // this.rank - s2.rank = +ve => this > s2
            // this.rank - s2.rank = 0 => this == s2
        }
    }

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
        System.out.println();

        // Priority Queue for Object --------------------------------
        // PriorityQueue<Student> pqs = new PriorityQueue<>();
        PriorityQueue<Student> pqs = new PriorityQueue<>(Comparator.reverseOrder());
        pqs.add(new Student("A", 3)); // Add a new student ('A' -> Character & "A" -> String)
        pqs.add(new Student("B", 5));
        pqs.add(new Student("C", 2));
        pqs.add(new Student("D", 8));
        while (!pqs.isEmpty()) {
            System.out.println(pqs.peek().name + "->" + pqs.peek().rank); // Peek - TC -> O(logn)
            pqs.remove(); // Remove - TC -> O(1)
        }
        // Accending Order - Output -> C,A,B,D (Min Rank base sort)
        // Decending Order - Output -> D,B,A,C (Max Rank base sort)
    }
}