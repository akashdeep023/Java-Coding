import java.util.ArrayList;

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

    // Lowest Common Ancestor -------------------------------- TC -> O(n) SC -> O(n)
    public static Node lowestCommonAncestor(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>(); // create array list to store path root to n1
        getPath(root, n1, path1);
        ArrayList<Node> path2 = new ArrayList<>(); // create array list to store path root to n2
        getPath(root, n2, path2);

        // last common node
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lca = path1.get(i - 1);
        return lca;
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) { // TC -> O(n)
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) { // root is n
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);
        if (foundLeft || foundRight) { // left or right side exists
            return true;
        }
        path.remove(path.size() - 1);
        return false;
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
        System.out.println("\n");

        // Lowest Common Ancestor --------------------------------
        int n1 = 4, n2 = 6; // Output -> 1
        int n3 = 4, n4 = 5; // Output -> 2
        System.out.println("LCA : " + lowestCommonAncestor(root, n1, n2).data);
        System.out.println("LCA : " + lowestCommonAncestor(root, n3, n4).data);

    }
}