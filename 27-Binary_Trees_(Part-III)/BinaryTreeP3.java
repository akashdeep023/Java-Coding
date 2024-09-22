public class BinaryTreeP3 {
    // Create Node class
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Kth level of a Tree -------------------------------- TC -> O(n)
    public static void kLevelNode(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kLevelNode(root.left, level + 1, k);
        kLevelNode(root.right, level + 1, k);
    }

    public static void main(String[] args) {
        /* Create a Tree --------------------------------
                 1      
                / \     
              2     3   
             / \   / \  
            4   5 6   7 
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Kth level of a Tree --------------------------------
        System.out.print("Kth leverl of node : ");
        kLevelNode(root, 1, 3); // k = 3; Output -> 4,5,6,7

    }
}