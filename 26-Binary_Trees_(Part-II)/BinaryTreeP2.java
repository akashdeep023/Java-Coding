import java.util.*;
import java.util.LinkedList;
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
    public static int diameterA1(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDiam = diameterA1(root.left);
        int rightDiam = diameterA1(root.right);
        int leftHt = height(root.left);
        int rightHt = height(root.left);
        int selfDiam = leftHt + rightHt + 1;
        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));

    }

    // Info class to store diameter and height of a tree --- helper class
    static class Info {
        int diam; // diameter
        int ht; // height

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    // Diameter of Tree Approach-2 -------------------------------- TC -> O(n)
    public static Info diameterA2(Node root) {
        if (root == null) {
            return new Info(0, 0); // return Info object
        }
        Info leftInfo = diameterA2(root.left);
        Info rightInfo = diameterA2(root.right);
        int finalDiam = Math.max((leftInfo.ht + rightInfo.ht + 1), Math.max(leftInfo.diam, rightInfo.diam));
        int finalHt = Math.max(leftInfo.ht, rightInfo.ht) + 1;
        return new Info(finalDiam, finalHt);
    }

    // Subtree of another tree -------------------------------- Tc O(n)
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) { // base case
            return false;
        }
        if (root.data == subRoot.data) { // find node (root == subRoot)
            if (isIdentical(root, subRoot)) { // check identical
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); // find node (root == subRoot)
    }

    public static boolean isIdentical(Node node, Node subRoot) { // helper method
        if (node == null && subRoot == null) { // node == subRoot == null
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) { // node.data is not equal subRoot.data
            return false;
        }
        if (!isIdentical(node.left, subRoot.left)) { // Check left child node is non-identical
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) { // Check right child node is non-identical
            return false;
        }
        return true; // subTree is identical
    }

    // Infom class to store Node and horizontal distance --- helper class
    static class Infom {
        Node node; // node
        int hd; // horizontal distance

        public Infom(Node node, int hd) {
            this.hd = hd;
            this.node = node;
        }
    }

    // Top View of a Tree --------------------------------
    public static void topView(Node root) {
        // Level order traversal
        Queue<Infom> q = new LinkedList<>(); // helper 
        HashMap<Integer, Node> map = new HashMap<>(); // Create map (hd,node)
        int min = 0, max = 0; // Print all nodes by order

        q.add(new Infom(root, 0)); // Add first node and horizontal distance = 0
        q.add(null); // For print next line
        while (!q.isEmpty()) {
            Infom curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break; // traversal all nodes
                } else {
                    q.add(null); // For print next line
                }
            } else {
                if (!map.containsKey(curr.hd)) { // First time my hd is occurring -> !false -> true
                    map.put(curr.hd, curr.node);
                }
                if (curr.node.left != null) {
                    q.add(new Infom(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Infom(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
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
        System.out.println("Diameter A1 : " + diameterA1(root)); // 5
        System.out.println("Height A1 : " + height(root)); // 3
        System.out.println();

        // Approach - 2 ---
        Info info = diameterA2(root);
        System.out.println("Diameter A21 : " + info.diam); // 5
        System.out.println("Height A21 : " + info.ht); // 3
        System.out.println();

        // Subtree of another tree --------------------------------
        // Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with
        // the same structure and node values of subRoot and false otherwise.
        /*
                     1             
                    / \    
                  2     3    Node root = 1;
                 / \     \ 
                4   5     6        
        */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        /*
                  2           
                 / \         Node subRoot = 2;
                4   5
        */
        System.out.println("Subtree of another tree : " + isSubtree(root, subRoot));
        System.out.println();

        // Top View of a Tree --------------------------------
        /*
                     1             
                    / \    
                  2     3    Node root = 1;
                 / \     \ 
                4   5     6        
        */
        Node secRoot = new Node(1);
        secRoot.left = new Node(2);
        secRoot.right = new Node(3);
        secRoot.left.right = new Node(4);
        secRoot.left.right.right = new Node(5);
        secRoot.left.right.right.right = new Node(6);
        /*
                     1             
                    / \    
                  2     3
                   \
                    4           Node secRoot = 1;
                     \
                      5        
                       \
                        6
        */
        topView(root); // 4,2,,1,3,6
        topView(secRoot); // 2,1,3,6

    }
}