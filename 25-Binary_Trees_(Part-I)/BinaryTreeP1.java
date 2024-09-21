import java.util.*;
import java.util.LinkedList;
import java.lang.Math;

public class BinaryTreeP1 {
    // Create Node class
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Create BinaryTree class
    static class BinaryTree {
        static int idx = -1;

        // Build Tree Preorder -------------------------------- TC -> O(n)
        public Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes); // left node
            newNode.right = buildTree(nodes); // right node
            return newNode; // root node
        }

        // Preorder Traversal -------------------------------- TC -> O(n)
        public void preorder(Node root) { // Recursive traversal
            if (root == null) { // base case
                System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " "); // print root data
            preorder(root.left); // print root left
            preorder(root.right); // print root right
        }

        // Inorder Traversal -------------------------------- TC -> O(n)
        public void inorder(Node root) { // Recursive traversal
            if (root == null) {
                // System.out.print(-1 + " ");
                return;
            }
            inorder(root.left); // print root left
            System.out.print(root.data + " "); // print root data
            inorder(root.right); // print root right
        }

        // Postorder Traversal -------------------------------- TC -> O(n)
        public void postorder(Node root) { // Recursive traversal
            if (root == null) {
                // System.out.print(-1 + " ");
                return;
            }
            postorder(root.left); // print root left
            postorder(root.right); // print root right
            System.out.print(root.data + " "); // print root data
        }

        // Level order Traversal -------------------------------- TC -> O(2n) -> O(n)
        public void levelorder(Node root) { // Iterative traversal
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null); // for next line print
            while (!q.isEmpty()) {
                Node curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null); // for next line print
                    }
                    System.out.println();
                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }

        // Height of a Tree -------------------------------- TC -> O(n)
        public int height(Node root) {
            if (root == null) {
                return 0;
            }
            int hl = height(root.left);
            int hr = height(root.right);
            int totalHeight = Math.max(hl, hr) + 1; // child height + self height(1)
            return totalHeight;
        }

        // Count of Nodes of a tree -------------------------------- TC -> O(n)
        public int countOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int leftCount = countOfNodes(root.left); // left child count
            int rightCount = countOfNodes(root.right); // right child count
            int totalNodes = leftCount + rightCount + 1; // left + right + root
            return totalNodes;
        }
    }

    public static void main(String[] args) {
        // Binary Tree -> Hierarchical Data Structure
        // Ex -> Family Tree
        // At max 2 children in Binary Tree

        // Pop Quiz. --------------------------------           1 
        // Children of 4 -> 7,8                                / \
        // No. of Leaves -> 4                                 2   3
        // Parent of 6 -> 3                                  / \   \
        // Level of 2 -> 2                                  4   5   6
        // Ancestor of 8 -> 4,2,1                          / \       \
        // Subtree of 2 -> Left(4,7,8),Right(5)           7   8       9

        // Build Tree Preorder --------------------------------
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 }; // preorder sequence
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root data : " + root.data); // root data -> 1
        System.out.println();

        // Preorder Traversal --------------------------------
        tree.preorder(root); // 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1
        System.out.println("\n");

        // Inorder Traversal --------------------------------
        tree.inorder(root); // 4 2 5 1 3 6 (without -1)
        System.out.println("\n");

        // Postorder Traversal -------------------------------- 
        tree.postorder(root); // 4 5 2 6 3 1 (without -1)
        System.out.println("\n");

        // Level order Traversal -------------------------------- 
        tree.levelorder(root);
        System.out.println("\n");

        // Height of a Tree --------------------------------
        /*
                 1 
                / \
              2     3
             / \     \
            4   5     6          
        */
        System.out.println("Tree height : " + tree.height(root));
        System.out.println();

        // Count of Nodes of a tree --------------------------------
        System.out.println("Count of Nodes : " + tree.countOfNodes(root));
    }
}