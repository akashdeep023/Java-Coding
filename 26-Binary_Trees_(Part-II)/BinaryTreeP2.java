import java.lang.Math;

public class BinaryTreeP2 {
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

    // Height of Tree -------------------------------- TC -> O(n)
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int totalHeight = Math.max(lh, rh) + 1;
        return totalHeight;
    }

    // Diameter of Tree Approach-1 -------------------------------- TC -> O(n^2)
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDiam = diameter(root.left);
        int rightDiam = diameter(root.right);
        int leftHt = height(root.left);
        int rightHt = height(root.left);
        int selfDiam = leftHt + rightHt + 1;
        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));

    }

    public static void main(String[] args) {
        // Diameter of a Tree --------------------------------
        /*
        => No. of nodes in the longest path between two leaves(last node).
        
                 1                        1
                / \     diameter = 5     / \
              2     3                   2   3
             / \     \                 / \          diameter = 7
            4   5     6               4   5     
                                     /     \
                                    6       7
                                   /         \
                                  8           9
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        /*
         * 1
         * 2 3
         * 4 5 6
         */
        // Approach - 1 ---
        System.out.println("Diameter A1 : " + diameter(root));

    }
}