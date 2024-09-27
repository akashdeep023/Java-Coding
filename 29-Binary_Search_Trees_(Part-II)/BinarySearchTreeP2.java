import java.util.ArrayList;
import java.lang.Math;

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

    // Size of largest BST in BT --------------------------------
    static class Info { // Store Information of node
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0; // static size of maxBST
    public static Node maxBSTNode = null; // static Node of maxBST

    public static Info largestBST(Node root) {
        if (root == null) { // base case
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1; // size (leftsz + rightsz + self(1))
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min)); // min(leftsz, rightsz, self)
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max)); // max(leftsz, rightsz, self)

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) { // Not valid BST
            return new Info(false, size, min, max);
        }
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size); // Update maxBST size
            maxBSTNode = root;
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    // Merge 2 BST -------------------------------- TC -> O(n + M) -> Linear TC
    public static Node mergeBSTs(Node bst1, Node bst2) {
        // Step 1: Bst1 inorder sequence - O(n)
        ArrayList<Integer> inorder1 = new ArrayList<>();
        getInorder(bst1, inorder1); // Bst to ArrayList

        // Step 2: Bst2 inorder sequence - O(n)
        ArrayList<Integer> inorder2 = new ArrayList<>();
        getInorder(bst2, inorder2); // Bst to ArrayList

        // Step 3: Merge inorder sequence (inorder1, inorder2) - O(n)
        ArrayList<Integer> finalInorder = merge(inorder1, inorder2); // Merge 2 ArrayList 

        // Step 4: Create Balance BST - O(n)
        return balancedBST2(finalInorder, 0, finalInorder.size() - 1);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2) { // Merge 2 Sorted inorder ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        while (!arr1.isEmpty() && !arr2.isEmpty()) {
            if (arr1.get(0) < arr2.get(0)) {
                result.add(arr1.remove(0));
            } else {
                result.add(arr2.remove(0));
            }
        }
        while (!arr1.isEmpty()) { // Extra element add
            result.add(arr1.remove(0));
        }
        while (!arr2.isEmpty()) { // Extra element add
            result.add(arr2.remove(0));
        }
        return result;
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
        System.out.println("\n");

        // Size of largest BST in BT --------------------------------
        /*
        *            50
        *           /  \                     60
        *         30    60                  /  \
        *         / \   / \       ->       45   70  (Size -> 5)
        *        5  20 45  70                   / \
        *                  / \                 65  80
        *                65   80
        */
        Node root3 = new Node(50);
        root3.left = new Node(30);
        root3.left.left = new Node(5);
        root3.left.right = new Node(20);
        root3.right = new Node(60);
        root3.right.left = new Node(45);
        root3.right.right = new Node(70);
        root3.right.right.left = new Node(65);
        root3.right.right.right = new Node(80);
        largestBST(root3);
        System.out.println("Size of largest BST : " + maxBST); // 5
        System.out.println("Root Node of BST : " + maxBSTNode.data); // 60
        System.out.println();

        // Merge 2 BST --------------------------------
        /*
         *                              3
         *      2         9           /   \
         *     / \   +   / \   ->    1     9    preorder traversal - 3,1,2,9,4,12
         *    1   4     3  12         \   / \
         *                             2 4  12
         */
        Node bst1 = new Node(2);
        bst1.left = new Node(1);
        bst1.right = new Node(4);

        Node bst2 = new Node(9);
        bst2.left = new Node(3);
        bst2.right = new Node(12);

        Node finalBst = mergeBSTs(bst1, bst2);
        preorder(finalBst); // 3,1,2,9,4,12

    }
}