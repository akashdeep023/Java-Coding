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
        int key2 = 5;
        System.out.println("Delete Node key : " + key2);
        root2 = delete(root2, key2);
        inorder(root2);
    }
}