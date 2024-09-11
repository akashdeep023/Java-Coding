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

    // Add first in LinkedList --- O(1)
    public void addFirst(int data) {
        // step1- create new node
        Node newNode = new Node(data);
        size++; // new node add -> increment size
        if (head == null) { // 
            head = tail = newNode;
            return;
        }
        // step2- newNode next = head (address)
        newNode.next = head; // link
        // step3- head = newNode
        head = newNode;
    }

    // Add last in LinkedList --- O(1)
    public void addLast(int data) {
        // step1- create new node
        Node newNode = new Node(data);
        size++; // new node add -> increment size
        if (head == null) { // 
            head = tail = newNode;
            return;
        }
        // step2- tail next = newNode (address)
        tail.next = newNode; // link
        // step3- tail = newNode
        tail = newNode;
    }

    // Print a LinkedList --- O(n)
    public void print() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

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

    // Remove Cycle in LinkedList ---
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

    // Merge Sort TC=O(nlogn) ---
    private Node getMid(Node head) { // helper function
        Node slow = head;
        Node fast = head.next; // 1st half last node

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid Node
    }

    private Node merge(Node head1, Node head2) { // helper function
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next; // mergedLL.head == dummy
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);
        // left & right merge sort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        // merge
        return merge(newLeft, newRight);
    }

    // Zig Zag LinkedList ---
    public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next; // 1st half last node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow; // 1st half last node
        // reverse 2nd half
        Node curr = mid.next; // 2nd half curr
        mid.next = null; // 1st half mid.next=null
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        // alt merge - zig-zag marge
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }

    public static void main(String args[]) {
        // Detecting Cycle in LinkedList --------------------------------
        // head = new Node(1); // Create Manually LinkedList
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = head;
        // System.out.println(isCycle()); // 1->2->3->1 Cycle LL

        // Remove Cycle in LinkedList --------------------------------
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // System.out.println(isCycle()); // 1->2->3->2 Cycle LL
        // removeCycle();
        // System.out.println(isCycle()); // 1->2->3->null Cycle not exists

        // Merge Sort TC=O(nlogn) --------------------------------
        // LinkedList ll = new LinkedList();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addFirst(5); // 5->4->3->2->1->null        
        // ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();

        // Zig Zag LinkedList --------------------------------
        // Find mid Node (min = 1st half last node)
        // 2nd half reverse (using 3 variables -> prev, curr or next)
        // Alternate merging
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.print(); // 1->2->3->4->5->null
        ll.zigZag();
        ll.print(); // 1->5->2->4->3->null
    }
}
