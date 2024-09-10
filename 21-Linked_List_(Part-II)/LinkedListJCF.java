
// import java.util.*; // All package
import java.util.LinkedList; // LinkedList package import (Java Collections Framework) JCF

public class LinkedListJCF {
    public static void main(String arg[]) {
        // LinkedList in Java Collections Framework --------------------------------
        // Create ---
        LinkedList<Integer> ll = new LinkedList<>();

        // Add ---
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        System.out.println(ll);

        // Remove ---
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
    }
}