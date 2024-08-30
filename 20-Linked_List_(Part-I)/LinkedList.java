public class LinkedList { // Create LinkedList Class
    public static class Node { // Create Node Class
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    // Add first in LinkedList --- O(1)
    public void addFirst(int data) {
        // step1- create new node
        Node newNode = new Node(data);
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

    public static void main(String[] args) {
        // Introduction to Linked List --------------------------------
        // Node -> like a cell to store 2 things, 1st data and 2nd next node reference ya null value
        // Each node is an object and the first node is called the head node and last node is called the tail node 

        // Add in LinkedList --------------------------------
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
        // 
    }
}