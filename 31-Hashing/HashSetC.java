import java.util.HashSet;

public class HashSetC {
    public static void main(String[] args) {
        // HashSet --------------------------------
        // Collection of unique elements
        // No duplicates, unordered, Null is allowed

        // Create ---
        HashSet<Integer> hs = new HashSet<>();

        // Add ---
        hs.add(1);
        hs.add(2);
        hs.add(4);
        hs.add(5);
        hs.add(2); // Allready added
        hs.add(1); // Allready added

        System.out.println(hs); // [1, 2, 4, 5]

        // Contains ---
        if (hs.contains(2)) {
            System.out.println("Set contain 2");
        }
        if (hs.contains(3)) {
            System.out.println("Set contain 3");
        }

        // Remove ---
        System.out.println(hs);
        System.out.println("Remove 2 " + hs.remove(2));
        System.out.println(hs);

        // Size ---
        System.out.println("Size of Set : " + hs.size());

        // Clear ---
        System.out.println("Clear of Set");
        hs.clear();
        System.out.println(hs);

        // Is empty ---
        System.out.println("Check is Empty : " + hs.isEmpty());

    }
}
