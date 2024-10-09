public class TriesC2 {
    // Create Node Class for trie
    public static class Node {
        Node children[] = new Node[26]; // a to z
        boolean eow = false; // End of Word
        int freq = 1; // Frequency of letter (Add Extra data)

        Node() { // Node constructor
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    // Insertion  TC -> O(L) Where L = Length of word
    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++; // increment freq if node already exists
            }
            curr = curr.children[idx]; // update curr
        }
        curr.eow = true; // End of word = true
    }

    // Find Prefix -------------------------------- TC -> O(L)
    // Method 1 ---
    public static String findPrefix(String key) {
        Node curr = root;
        StringBuilder pre = new StringBuilder();
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (curr.children[idx] != null) {
                pre = pre.append(key.charAt(i));
                if (curr.children[idx].freq == 1) {
                    return pre.toString();
                }
            }
            curr = curr.children[idx];
        }
        return pre.toString();
    }

    // Method 2 --- (Ma'am Code)
    public static void findPrefix2(Node root, String ans) { // Recursion
        if (root == null) {
            return;
        }
        if (root.freq == 1) {
            System.out.print(ans + " ");
            return;
        }
        for (int i = 0; i < root.children.length; i++) { // 0 to 25
            if (root.children[i] != null) {
                findPrefix2(root.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        // Prefix Problem --------------------------------
        // Find shortest unique prefix for every word in a given list.
        // Assume no word is prefix of another.
        String arr1[] = { "zebra", "dog", "duck", "dove" }; // Output -> {"z","dog","du","dov"};
        for (int i = 0; i < arr1.length; i++) {
            insert(arr1[i]);
        }
        // Method 1 ---
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(findPrefix(arr1[i]) + " ");
        }
        System.out.println("\n");
        // Method 2 ---
        root.freq = -1;
        findPrefix2(root, "");
        System.out.println();
    }
}
