public class TriesC {
    // Create Node Class for Trie --------------------------------
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

    // Insertion -------------------------------- TC -> O(L) Where L = Length of word
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

    // Searching -------------------------------- TC -> O(L)
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

    // Word Break Problem -------------------------------- TC -> O(L) L = key.length()
    public static boolean wordBreak(String key) {
        if (key.length() == 0) { // base case
            return true;
        }
        for (int i = 1; i <= key.length(); i++) { // 1 to key.length()
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) { // 1st Substring && 2nd Substring true then return true
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Tries --------------------------------
        // Tries = Prefix tree = Retrievel trees
        // Multiple pointers/Nodes (K-ary tree)

        // // Creating a Trie --------------------------------
        // String words[] = { "the", "a", "there", "their", "any", "thee" };

        // // Insertion --------------------------------
        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }

        // // Searching --------------------------------
        // String key = "thee";
        // String key2 = "thor";
        // String key3 = "any";
        // String key4 = "an";
        // System.out.println(key + " key is exist : " + search(key));
        // System.out.println(key2 + " key is exist : " + search(key2));
        // System.out.println(key3 + " key is exist : " + search(key3));
        // System.out.println(key4 + " key is exist : " + search(key4));
        // System.out.println();

        // Word Break Problem --------------------------------
        // Given an input string and a dictionary of words, find out if the input string
        // can be broken into a space-separated sequence of dictionary words.
        String arr[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        String k = "ilikesamsung"; // key Output -> true
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        System.out.println("Word Break : " + wordBreak(k));

    }
}