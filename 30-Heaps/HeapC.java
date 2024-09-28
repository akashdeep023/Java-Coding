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

        // Peek(Get min) from Heap --------------------------------
        public int peek() { // TC -> O(1)
            return arr.get(0);
        }

        // Remove(delete) from Heap --------------------------------
        public int remove() { // TC -> O(logn)
            int data = arr.get(0);
            // 1st & last element Swap
            int temp = arr.get(arr.size() - 1);
            arr.set(arr.size() - 1, arr.get(0));
            arr.set(0, temp);
            // remove last idx
            arr.remove(arr.size() - 1); // first element before swaped
            // fix heap
            heapify(0); // root index pass
            return data;
        }

        // helper function to fix heap
        private void heapify(int i) { // TC -> O(logn)
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i; // supposed i is min index
            // find min index
            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            if (minIdx != i) { // swap root index change
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx); // minIdx = root index (minIdx pass to fix child node)
            }

        }

        // Print Heap
        public void print() {
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
        }

        // Empty function to check arrayList is empty or not
        public boolean isEmpty() {
            return arr.size() == 0;
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
        System.out.println();

        // Peek(Get min) from Heap --------------------------------
        System.out.println("Peek from Heap : " + h.peek()); // 1
        System.out.println();

        // Remove(delete) from Heap --------------------------------
        System.out.println("Remove from Heap : " + h.remove());
        System.out.println();

        // Heap performs PriorityQueue Data Structure ---
        Heap pq = new Heap();
        pq.add(2);
        pq.add(4);
        pq.add(1);
        pq.add(5);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }
        // Output -> 1,2,4,5 (PriorityQueue)
    }
}
