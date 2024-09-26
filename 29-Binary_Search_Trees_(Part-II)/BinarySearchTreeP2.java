import java.util.ArrayList;

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

    // Sorted array to Balanced BST -------------------------------- TC -> O(n)
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

    // Convert BST to Balanced BST -------------------------------- TC -> O(n)
    public static Node convertBalanceBST(Node root) {
        // BST -> Sorted inorder ArrayList - O(n)
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        // Sorted inorder -> Balance BST - O(n)
        root = balancedBST2(inorder, 0, inorder.size() - 1);
        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) { // Sorted inorder ArrayList TC -> O(n)
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node balancedBST2(ArrayList<Integer> inorder, int start, int end) { // Sorted inorder -> Balance BST (ArrayList) TC -> O(n)
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = balancedBST2(inorder, start, mid - 1);
        root.right = balancedBST2(inorder, mid + 1, end);
        return root;
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
        System.out.println("\n");

        // Convert BST to Balanced BST --------------------------------
        /*
         *            8
         *           / \                      8
         *          6   10                  /   \
         *         /      \       ->       5     11
         *        5        11             / \    / \
         *       /          \            3   6  10 12
         *      3            12
         */
        Node root2 = new Node(8);
        root2.left = new Node(6);
        root2.left.left = new Node(5);
        root2.left.left.left = new Node(3);
        root2.right = new Node(10);
        root2.right.right = new Node(11);
        root2.right.right.right = new Node(12);
        preorder(root2);
        System.out.println();
        preorder(convertBalanceBST(root2));

    }
}