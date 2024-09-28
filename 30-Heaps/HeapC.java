public class HeapC {
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
    }
}
