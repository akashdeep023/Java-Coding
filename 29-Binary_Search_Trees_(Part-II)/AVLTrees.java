public class AVLTrees {
    // BST Node is Same Structure of BT Node 
    static class Node {
        int data;
        int height; // Height of node
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    // Height calculate function
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Preorder traversal function
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Get Balance factor of node
    public static int getBalanceF(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    // Left rotate subtree rooted with x
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right) + 1);
        y.height = max(height(y.left), height(y.right) + 1);

        // Return new root
        return y;
    }

    // Right rotate subtree rooted with y
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right) + 1);
        x.height = max(height(x.left), height(x.right) + 1);

        // Return new root
        return x;
    }

    // Insert a Node in BST
    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; // Duplicate keys not allowed (Without inserting return root)
        }

        // Update root height
        root.height = 1 + max(height(root.left), height(root.right));

        // Get root's Balance Factor
        int bf = getBalanceF(root);

        // Left Left Case - 1
        if (bf > 1 && key < root.left.data) {
            return rightRotate(root);
        }
        // Right Right Case - 2
        if (bf < -1 && key > root.right.data) {
            return leftRotate(root);
        }
        // Left Right Case - 3
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.right);
            return rightRotate(root);
        }
        // Right Left Case - 4
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root; // returned If AVL balanced
    }

    public static void main(String[] args) {
        // Creaating an AVL Tree --------------------------------
        // 10,20,30,40,50,25
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);
        /*
         *          30
         *         /  \
         *        20   40
         *       /  \    \
         *      10  25    50
         */
        System.out.print("Print Preorder Sequence : ");
        preorder(root); // 30,20,10,25,40,50
        System.out.println();
    }
}
