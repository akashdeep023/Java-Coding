public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Detecting Cycle in LinkedList ---
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if (slow == fast) {
                return true; // cycle exists
            }
        }
        return false; // cycle doesn't exists
    }

    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }
        // find meeting point
        slow = head; // slow reinitialize
        Node prev = null;
        while (slow != fast) { // slow = head or fast = cycle meet point node
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // remove cycle -> last.next = null
        prev.next = null;
    }

    public static void main(String args[]) {
        // Detecting Cycle in LinkedList --------------------------------
        head = new Node(1); // Create Manually LinkedList
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;
        System.out.println(isCycle()); // 1->2->3->1 Cycle LL
        System.out.println();

        // Remove Cycle in LinkedList --------------------------------
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        System.out.println(isCycle()); // 1->2->3->2 Cycle LL
        removeCycle();
        System.out.println(isCycle()); // 1->2->3->null Cycle not exists
        System.out.println();

    }
}
