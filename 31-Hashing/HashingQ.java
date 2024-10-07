import java.util.HashMap;
// import java.util.Set;

public class HashingQ {
    // Valid Anagram --------------------------------
    public static boolean isAnagram(String s, String t) { // TC -> O(n)
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> cm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cm.put(ch, cm.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (cm.containsKey(ch)) {
                if (cm.get(ch) == 1) {
                    cm.remove(ch);
                } else {
                    cm.put(ch, cm.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return cm.isEmpty();
    }

    public static void main(String[] args) {
        // Majority element -------------------------------- TC -> O(n)
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
                System.out.print(key + " ");
            }
        }
        System.out.println("\n");

        // Valid Anagram -------------------------------- TC -> O(n)
        // Given two strings s and t, return true if t is an anagram of s, and false otherwise.
        // An Anagram is word or phrase formed by rearranging the letters of a defferent word 
        // or phrase, typically using all the original letters exactly once.
        String s = "race";
        String t = "care";
        System.out.println("Anagram : " + isAnagram(s, t));

    }
}
