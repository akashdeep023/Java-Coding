import java.util.*; // Import all package

public class StackC {
    // ArrayList --------------------------------
    // static class Stack {
    //     static ArrayList<Integer> list = new ArrayList<>();

    //     public boolean isEmpty() { // Check Stack is empty
    //         return list.size() == 0;
    //     }

    //     public void push(int data) { // Push data (add data to stack)
    //         list.add(data);
    //     }

    //     public int pop() {
    //         if (isEmpty()) { // Check stack is empty
    //             return -1;
    //         }
    //         int data = list.get(list.size() - 1); // Pop data (remove from stack)
    //         list.remove(list.size() - 1);
    //         return data;
    //     }

    //     public int peek() { // Peek data (get from stack)
    //         if (isEmpty()) { // Check stack is empty
    //             return -1;
    //         }
    //         return list.get(list.size() - 1);
    //     }
    // }

    // LinkedList -------------------------------- 
    // static class Node { // LinkedList Node class
    //     int data;
    //     Node next;

    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }

    // static class Stack {
    //     static Node head = null;

    //     public boolean isEmpty() {
    //         return head == null;
    //     }

    //     public void push(int data) {
    //         Node newNode = new Node(data);
    //         if (isEmpty()) {
    //             head = newNode;
    //             return;
    //         }
    //         newNode.next = head;
    //         head = newNode;
    //     }

    //     public int pop() {
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         int top = head.data;
    //         head = head.next;
    //         return top;
    //     }

    //     public int peek() {
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }

    // Print Stack --- helper function to print stack
    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    // Q-1 Push at the bottom of the Stack -------------------------------- 
    public static void pushBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) { // base case
            s.push(data);
            return;
        }
        int top = s.pop();
        pushBottom(s, data); // recursion
        s.push(top); // backtracking
    }

    public static void main(String[] args) {
        // Stack using ArrayList & LinkedList --------------------------------
        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        // Stack using Collections framework --------------------------------
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        while (!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }

        // Q-1 Push at the bottom of the Stack -------------------------------- 
        pushBottom(st, 4);
        printStack(st);

    }
}