import java.util.*;

public class HeapC {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        // Insert in Heap --------------------------------
        public void add(int data) { // TC -> O(logn)
            // add at last index
            arr.add(data); // O(1)
            // fix heap
            int ci = arr.size() - 1; // index of child
            int pi = (ci - 1) / 2; // index of parent
            while (arr.get(pi) > arr.get(ci)) { // O(logn)
                int temp = arr.get(pi); // store pi value
                arr.set(pi, arr.get(ci)); // pi = ci value
                arr.set(ci, temp); // ci = temp(parent) value
                ci = pi;
                pi = (ci - 1) / 2;
            }
        }

        public void print() {
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /* 
         * Heap Introduction --------------------------------
         * Heap -> Visualize (Binary Tree)
         *       -> Implement (Array/ArrayList)
         *  
         *         10                     1
         *        /  \                   / \ 
         *       4    5                 2   4
         *      / \                    / \
         *     1   2                  5   10
         * 
         *    (Max Heap) ↑            (Min Heap) ↓
         * 
         * Binary Tree ---
         * -> At most 2 children
         * Complete Binary Tree ---
         * -> CBT is a BT in which all the levels are completely filled except possible
         *    the last one, which is filled from the left to right.
         * Heap order Property ---
         * -> Children >= Parent (Min Heap)
         *    Children <= Parent (Max Heap)
         * 
         * Heap Implementation --------------------------------
         * Heap is not implemented as a class (Node) ---
         * -> Insert 1 - Tree last position O(n) + Convert Heap Property O(extra time)
         * Heap as an Array/ArrayList ---
         * -> Insert 1 - ArrayList last position O(1) + Convert Heap Property O(extra time)
         * 
         * Parent idx = i
         * Left child idx = 2i + 1
         * Right child idx = 2i + 2 
        */
        // Insert in Heap --------------------------------
        Heap h = new Heap();
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(10);
        h.print(); // 2 3 4 5 10 
        h.add(1); // insert 1
        h.print(); // 1 3 2 5 10 4

    }
}
