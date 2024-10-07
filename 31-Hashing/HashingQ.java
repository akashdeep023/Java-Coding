import java.util.HashMap;
// import java.util.Set;

public class HashingQ {
    public static void main(String[] args) {
        // Majority element --------------------------------
        // Given an integer array of size n, find all elements that appear more than [n/3] times.
        int nums[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 }; // Output -> 1
        // int nums2[] = { 1, 2 }; // Output -> 1,2
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // if (map.containsKey(nums[i])) {
            //     map.put(nums[i], map.get(nums[i]) + 1); // frequency update
            // } else {
            //     map.put(nums[i], 1); // frequency add in 1st time
            // }

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); // Sort form
        }
        // Iterate map
        // Set<Integer> keys = map.keySet();
        for (Integer key : map.keySet()) { // Direct passed of KeySet
            if (map.get(key) > nums.length / 3) {
                System.out.println(key + " ");
            }
        }

    }
}
