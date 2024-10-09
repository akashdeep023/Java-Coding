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

    public static void main(String[] args) {
        // Tries --------------------------------
        // Tries = Prefix tree = Retrievel trees
        // Multiple pointers/Nodes (K-ary tree)

        // Creating a Trie --------------------------------
        String words[] = { "the", "a", "there", "their", "any", "thee" };

        // Insertion --------------------------------
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        // Searching --------------------------------
        String key = "thee";
        String key2 = "thor";
        String key3 = "any";
        String key4 = "an";
        System.out.println(key + " key is exist : " + search(key));
        System.out.println(key2 + " key is exist : " + search(key2));
        System.out.println(key3 + " key is exist : " + search(key3));
        System.out.println(key4 + " key is exist : " + search(key4));
        System.out.println();

    }
}