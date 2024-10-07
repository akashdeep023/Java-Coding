import java.util.HashSet;

public class HashingQ2 {
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
    }
}
