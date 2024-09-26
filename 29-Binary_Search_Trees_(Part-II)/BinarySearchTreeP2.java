public class BinarySearchTreeP2 {
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

    // Sorted array to Balanced BST --------------------------------
    public static Node balancedBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = balancedBST(arr, start, mid - 1);
        root.right = balancedBST(arr, mid + 1, end);
        return root;
    }

    public static void preorder(Node root) { // Preorder Traversal
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        // Sorted array to Balanced BST --------------------------------
        /*
         *             8
         *           /   \
         *          5     11   Preorder Traversal -> 8,5,3,6,11,10,12
         *         / \    / \
         *        3   6  10 12
         */
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        Node root = balancedBST(arr, 0, arr.length - 1);
        preorder(root);

    }
}