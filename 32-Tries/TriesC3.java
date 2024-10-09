public class TriesC3 {
    // Create Node Class for Trie 
    public static class Node {
        Node children[] = new Node[26]; // a to z
        boolean eow = false; // End Of Word

        Node() { // Node constructor
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node(); // root node -> empty node

    // Insertion  TC -> O(L) Where L = Length of word
    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true; // last letter or word (end of word = true)
    }

    // Searching  TC -> O(L)
    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) { // letter not exists in trie then return false
                return false;
            }
            curr = curr.children[idx]; // update curr
        }
        return curr.eow == true; // last letter of eow is true then return true otherwise false
    }

    // StartsWith Problem --------------------------------
    public static boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    // Count Unique Substrings --------------------------------
    public static int countNodes(Node root) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1; // All children nodes + self node
    }

    // Longest Word with all Prefixes --------------------------------
    public static String longWord = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.length; i++) { // Alphabeticaly smaller (a to z)
            if (root.children[i] != null && root.children[i].eow == true) {
                temp = temp.append((char) (i + 'a'));
                if (temp.length() > longWord.length()) {
                    longWord = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1); // backtrack
            }
        }
    }

    public static void main(String[] args) {
        // StartsWith Problem --------------------------------
        // Create a function boolean startWith(String prefix) for a trie.
        // Return true if there is a previously inserted string word that has the prefix and false otherwise.
        // String words[] = { "apple", "app", "mango", "man", "woman" };
        // String prefix1 = "app"; // Output -> true
        // String prefix2 = "moon"; // Output -> false
        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }
        // System.out.println(prefix1 + " is prefix : " + startsWith(prefix1));
        // System.out.println(prefix2 + " is prefix : " + startsWith(prefix2));
        // System.out.println();

        // Count Unique Substrings --------------------------------
        // Given a string of length n of lowercase alphabet characters, we need to count total number 
        // of distinct substrings of this string.
        // String str = "ababa"; // Output -> 10
        // for (int i = 0; i < str.length(); i++) { // Step-1 Suffix -> Step-2 Insert in trie
        //     insert(str.substring(i));
        // }
        // System.out.println("Count of unique substring : " + countNodes(root)); // Step-3 count all Nodes
        // System.out.println();

        // Longest Word with all Prefixes --------------------------------
        // Find the longest string in words such tat every prefix of it is also in words.
        String arr[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println("Longest word : " + longWord);

    }
}
