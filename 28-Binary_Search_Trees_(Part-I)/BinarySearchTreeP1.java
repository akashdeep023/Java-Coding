import java.util.ArrayList;

public class BinarySearchTreeP1 {
    // BST Node is Same Structure of BT Node 
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

    // Build a BST --------------------------------
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) { // insert left subtree
            root.left = insert(root.left, val);
        } else { // insert right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    // inorder traversal ---
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Search a BST --------------------------------
    public static boolean search(Node root, int key) { // TC -> O(H) (H -> height of tree)
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // Delete a Node --------------------------------
    public static Node delete(Node root, int key) {
        if (root == null) { // Key not found in tree
            System.out.println("Key not found in tree");
            return null;
        }
        if (root.data < key) {
            root.right = delete(root.right, key);
        } else if (root.data > key) {
            root.left = delete(root.left, key);
        } else {
            // case-1 leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // case-2 single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // case-3 both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) { // Min value in Right Subtree
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Print in Range --------------------------------
    public static void printInRange(Node root, int range1, int range2) {
        if (root == null) {
            return;
        }
        if (root.data >= range1 && root.data <= range2) { // Root in range
            printInRange(root.left, range1, range2);
            System.out.print(root.data + " ");
            printInRange(root.right, range1, range2);
        } else if (root.data < range1) { // Root less than range1
            printInRange(root.right, range1, range2);
        } else { // Root greater than range2
            printInRange(root.left, range1, range2);
        }
    }

    // Root to Leaf Path --------------------------------
    public static void printRootToLeaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
            // return;
        }
        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);
        path.remove(path.size() - 1); // last element remove
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    // Validate BST --------------------------------
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) { // base case ya null valid
            return true;
        }
        if (min != null && root.data <= min.data) { // root.data less than ya equal min.data
            return false;
        } else if (max != null && root.data >= max.data) { // root.data greater than ya equal max.data
            return false;
        }
        return isValidBST(root.left, min, root) &&
                isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        /* 
         * Introduction Binary Search Tree (BTS) -------------------------------- 
         * -> Use Binary Tree Properties (At max 2 children)  
         * -> Left Subtree Nodes < Root 
         * -> Right Subtree Nodes > Root
         * -> Left & Right Subtree are also BST with no duplicates.
         * 
         *            4
         *           / \       Root = 4
         *          2   5      2(LC) < 4(Root)
         *         / \   \     5(RC) > 4(Root)
         *        1   3   6
         * 
         * Special Property -> 'Inorder' Traversal of BST givess a Sorted Sequence.
         * -> 1,2,3,4,5,6 (Sorted Binary Search Tree)
         */

        // Build a Binary Search Tree (BST) --------------------------------
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println("\n");

        // Search a BST --------------------------------
        int key = 1;
        if (search(root, key)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
        System.out.println();

        // Delete a Node --------------------------------
        int values2[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root2 = null;
        for (int i = 0; i < values2.length; i++) {
            root2 = insert(root2, values2[i]);
        }
        inorder(root2);
        System.out.println();
        int key2 = 9; // 5;
        System.out.println("Delete Node key : " + key2);
        root2 = delete(root2, key2);
        inorder(root2);
        System.out.println("\n");

        // Print in Range --------------------------------
        // 8, 5, 3, 1, 4, 6, 10, 11, 14 
        int range1 = 4;
        int range2 = 12;
        System.out.print("Print in Range " + range1 + " to " + range2 + " : ");
        printInRange(root2, range1, range2);
        System.out.println("\n");

        // Root to Leaf Path --------------------------------
        // 8, 5, 3, 1, 4, 6, 10, 11, 14 
        ArrayList<Integer> path = new ArrayList<>();
        System.out.println("Print Root to Leaf Path :-");
        printRootToLeaf(root2, path);
        System.out.println();

        // Validate BST --------------------------------
        System.out.print("Validate BST : " + isValidBST(root2, null, null) + "\n");
        Node root3 = new Node(1);
        root3.left = new Node(1);
        root3.right = new Node(1);
        System.out.print("Validate BST : " + isValidBST(root3, null, null));

    }
}