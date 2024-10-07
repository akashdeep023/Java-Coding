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
    }
}
