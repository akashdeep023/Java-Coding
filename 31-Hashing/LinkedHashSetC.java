import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetC {
    public static void main(String[] args) {
        // LinkedHashSet --------------------------------
        // Ordered Using DLL (Doubly LinkedList)
        // Create ---
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();

        // Add ---
        lhs.add(1);
        lhs.add(2);
        lhs.add(4);
        lhs.add(5);
        lhs.add(2); // Allready added
        lhs.add(1); // Allready added

        System.out.println(lhs); // [1, 2, 4, 5] -> Ordered

        // Contains ---
        if (lhs.contains(2)) {
            System.out.println("Set contain 2");
        }
        if (lhs.contains(3)) {
            System.out.println("Set contain 3");
        }

        // Remove ---
        System.out.println(lhs);
        System.out.println("Remove 2 " + lhs.remove(2));
        System.out.println(lhs);

        // Size ---
        System.out.println("Size of Set : " + lhs.size());

        // Clear ---
        System.out.println("Clear of Set");
        lhs.clear();
        System.out.println(lhs);

        // Is empty ---
        System.out.println("Check is Empty : " + lhs.isEmpty());
        System.out.println();

        // Iteration on LinkedHashSet --------------------------------
        LinkedHashSet<String> cities = new LinkedHashSet<>();
        cities.add("Delhi");
        cities.add("Patna");
        cities.add("Mumbai");
        cities.add("Bengaluru");

        // 1st Method ---
        Iterator<String> it = cities.iterator(); // Iterator ya Iterator<String>
        while (it.hasNext()) {
            System.out.println(it.next()); // Ordered 
        }
        System.out.println();

        // 2nd Method --- using foreach loop
        for (String city : cities) {
            System.out.println(city);
        }
    }
}
