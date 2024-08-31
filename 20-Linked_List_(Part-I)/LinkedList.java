public class LinkedList { // Create LinkedList Class
    public static class Node { // Create Node Class
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head; // null
    public static Node tail; // null
    public static int size; // 0

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

    // Add in the Middle of LinkedList --- O(n)
    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++; // new node add -> increment size
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next; // temp = idx - 1
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove first in LinkedList --- O(1)
    public int removeFirst() {
        if (size == 0) {
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next; // head = next node
        size--; // remove node -> decrement size
        return val;
    }

    // Remove last in LinkedList --- O(n)
    public int removeLast() {
        if (size == 0) {
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        // prev = n - 2;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data; // prev.next = tail;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Iterative Search --- O(n)
    public int searchIterative(int key) {
        Node temp = head;
        // for (int i = 0; i < size; i++) { // using for loop
        //     if (temp.data == key) { // key fou
        //         return i;
        //     }
        //     temp = temp.next;
        // }
        int i = 0;
        while (temp != null) { // using while loop
            if (temp.data == key) { // key found
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1; // key not found
    }

    // Recursive Search --- O(n) SC -> O(n) (call stack size)
    public int searchRecursive(int key) {
        return helperSearch(head, key);
    }

    public int helperSearch(Node head, int key) {
        if (head == null) { // parameter head
            return -1;
        }
        if (head.data == key) { // key found
            return 0;
        }
        int idx = helperSearch(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1; // backtrack (return org head index)
    }

    // Reverse a LinkedList --- O(n)
    public void reverse() {
        Node prev = null;
        Node curr = tail = head; // right to left assignment (tail = head (update tail node) or curr = tail)
        Node next;

        while (curr != null) { // curr == null -> exit loop
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev; // prev == last node (update head node)
    }

    public static void main(String[] args) {
        // Introduction to LinkedList --------------------------------
        // Node -> like a cell to store 2 things, 1st data and 2nd next node reference ya null value
        // Each node is an object and the first node is called the head node and last node is called the tail node 

        // Add in a LinkedList --------------------------------
        LinkedList ll = new LinkedList(); // Create a LinkedList (call LinkedList constructor)
        // Add first in LinkedList ---
        ll.addFirst(2);
        ll.addFirst(1);

        // Add last in LinkedList ---
        ll.addLast(3);
        ll.addLast(4);

        // Print a LinkedList --------------------------------
        ll.print();

        // Add in the Middle of LinkedList --------------------------------
        ll.add(2, 9);
        ll.print();

        // Size of a LinkedList --------------------------------
        System.out.println("LL size : " + ll.size);

        // Remove in a LinkedList --------------------------------
        // Remove first in LinkedList ---
        System.out.println("Remove first data : " + ll.removeFirst());
        ll.print();
        System.out.println("LL size : " + ll.size);

        // Remove last in LinkedList ---
        System.out.println("Remove last data : " + ll.removeLast());
        ll.print();
        System.out.println("LL size : " + ll.size);

        // Iterative Search --------------------------------
        // Search for a key in a linkedList. Return the position where it is found. If not found return -1.
        System.out.println("Found Index = " + ll.searchIterative(3));
        System.out.println("Found Index = " + ll.searchIterative(10));

        // Recursive Search --------------------------------
        System.out.println("Found Index = " + ll.searchRecursive(3));
        System.out.println("Found Index = " + ll.searchRecursive(10));

        // Reverse a LinkedList (Iterative Approach) --------------------------------
        ll.print();
        ll.reverse();
        ll.print();

    }
}