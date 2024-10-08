import java.util.HashMap;
import java.util.HashSet;
import java.lang.Math;

public class HashingQ2 {
    // Find itinerary from tickets -------------------------------- TC -> O(n)
    public static String getStart(HashMap<String, String> tickets) {
        HashSet<String> revSet = new HashSet<>(); // using HashSet
        for (String from : tickets.keySet()) {
            revSet.add(tickets.get(from)); // set (tickets.get(from) -> to)
        }
        for (String from : tickets.keySet()) {
            if (!revSet.contains(from)) { // to -> not exist from
                return from; // starting (from)
            }
        }
        return null; // for removing error
    }

    public static void main(String[] args) {
        // Count Distinct Elements -------------------------------- TC -> O(n)
        int num[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            hs.add(num[i]);
        }
        System.out.println("Counts: " + hs.size()); // Output -> 7
        System.out.println();

        // Union & Intersection of 2 Arrays --------------------------------
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        HashSet<Integer> set = new HashSet<>();

        // union
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        System.out.println("Union count : " + set.size());
        System.out.println(set);
        System.out.println();

        // intersection
        set.clear(); // Set Map use previous hashset
        int count = 0;
        HashSet<Integer> intersection = new HashSet<Integer>(); // Answer
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
                intersection.add(arr2[i]);
            }
        }
        System.out.println("Intersection count : " + count);
        System.out.println(intersection);
        System.out.println();

        // Find itinerary from tickets -------------------------------- TC -> O(n)
        String tickets[][] = {
                { "Chennai", "Bengalure" }, // from -> to
                { "Mumbai", "Delhi" },
                { "Gao", "Chennai" },
                { "Delhi", "Gao" },
        };
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            map.put(tickets[i][0], tickets[i][1]);
        }
        String start = getStart(map);
        System.out.print(start); // print start
        for (int i = 0; i < map.size(); i++) {
            start = map.get(start);
            System.out.print(" -> " + start); // print next journey
        }
        System.out.println("\n");

        // Largest Subarray With Sum 0 -------------------------------- TC ->  O(n) (Brute Force -> O(n^2))
        int nums[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        HashMap<Integer, Integer> hm = new HashMap<>(); // map(sum,idx)
        int sum = 0;
        int len = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (hm.containsKey(sum)) {
                len = Math.max(len, j - hm.get(sum));
            } else {
                hm.put(sum, j);
            }
        }
        System.out.println("Largest SubArray length : " + len);
    }
}
