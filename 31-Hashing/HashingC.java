import java.util.HashMap; // HashMap import from JCF

public class HashingC {
    public static void main(String[] args) {
        /* 
         * Hashing --------------------------------
         * Integer (123) ----HashFunction----> 48
         * String (Akash) ----HashFunction----> 713
         * 
         * Hashing (Use Two data structures to generate)
         *  ├── map (3 Types)
         *  │ ├── HashMap (Important)
         *  │ ├── LinkedHashMap
         *  │ └── TreeMap
         *  └── set (3 Types)
         *    ├── HashSet (Important)
         *    ├── LinkedHashSet
         *    └── TreeSet 
         */

        // HashMap --------------------------------
        // HashMap store pair(node) form data (Key, Value) Key is Unique
        // Create ---
        HashMap<String, Integer> hm = new HashMap<>();

        // HashMap Operation --------------------------------
        // Insert (Add) --- TC -> O(1)
        hm.put("India", 100); // India (Key) & 100 (Value)
        hm.put("China", 150);
        hm.put("US", 50);
        System.out.println("Print HashMap : " + hm); // {China=150, US=50, India=100} (HashMap unordered map)

        // Get --- TC -> O(1)
        System.out.println("India Population : " + hm.get("India")); // 100
        System.out.println("Nepal Population : " + hm.get("Nepal")); // Null

        // ContainsKey --- TC -> O(1)
        System.out.println("India contain in HashMap : " + hm.containsKey("India")); // true
        System.out.println("Nepal contain in HashMap : " + hm.containsKey("Nepal")); // false

        // Remove --- TC -> O(1)
        System.out.println("Print HashMap : " + hm);
        System.out.println("Remove India : " + hm.remove("India")); // 100
        System.out.println("Print HashMap : " + hm);
        System.out.println("Remove Nepal : " + hm.remove("Nepal")); // Null
        System.out.println("Print HashMap : " + hm);

        // Size 
        System.out.println("HashMap size : " + hm.size()); // 2 (Count Pair/Node)

        // Is Empty
        System.out.println("HashMap is empty : " + hm.isEmpty()); // false (2 pairs exist)

        // Clear 
        hm.clear(); // clear all elements
        System.out.println("Clear HashMap");
        System.out.println("HashMap is empty : " + hm.isEmpty()); // true (0 pairs exist);
        System.out.println("Print HashMap : " + hm);
    }
}