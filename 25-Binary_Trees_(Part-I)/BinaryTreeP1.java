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

        // Build Tree Preorder -------------------------------- TC -> O(n)
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 }; // preorder sequence
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data); // root data -> 1

    }
}