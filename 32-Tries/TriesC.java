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

    public static void main(String[] args) {
        // Tries --------------------------------
        // Tries = Prefix tree = Retrievel trees
        // Multiple pointers/Nodes (K-ary tree)

        // Creating a Trie --------------------------------
        String words[] = { "the", "a", "there", "their", "any", "thee" };

    }
}