import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetC {
    public static void main(String[] args) {
        // TreeSet --------------------------------
        // Collection of unique elements
        // Sorted in accending order

        // Create ---
        TreeSet<Integer> ts = new TreeSet<>();

        // Add ---
        ts.add(1);
        ts.add(2);
        ts.add(4);
        ts.add(5);
        ts.add(2); // Allready added
        ts.add(1); // Allready added

        System.out.println(ts); // [1, 2, 4, 5] sorted in accending order

        // Contains ---
        if (ts.contains(2)) {
            System.out.println("Set contain 2");
        }
        if (ts.contains(3)) {
            System.out.println("Set contain 3");
        }

        // Remove ---
        System.out.println(ts);
        System.out.println("Remove 2 " + ts.remove(2));
        System.out.println(ts);

        // Size ---
        System.out.println("Size of Set : " + ts.size());

        // Clear ---
        System.out.println("Clear of Set");
        ts.clear();
        System.out.println(ts);

        // Is empty ---
        System.out.println("Check is Empty : " + ts.isEmpty());
        System.out.println();

        // Iteration on TreeSet --------------------------------
        TreeSet<String> cities = new TreeSet<>();
        cities.add("Delhi");
        cities.add("Patna");
        cities.add("Mumbai");
        cities.add("Bengaluru");

        // 1st Method ---
        Iterator<String> it = cities.iterator(); // Iterator ya Iterator<String>
        while (it.hasNext()) {
            System.out.println(it.next()); // Sorted 
        }
        System.out.println();

        // 2nd Method --- using foreach loop
        for (String city : cities) {
            System.out.println(city);
        }

    }
}
