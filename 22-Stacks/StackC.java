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
        System.out.println();
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

    // Q-2 Reverse a String using a Stack --------------------------------
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>(); // Create character type stack
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder sb = new StringBuilder("");
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    // Q-3 Reverse a Stack --------------------------------
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) { // base case
            return; // stack is empty then return
        }
        int top = s.pop(); // top element pop
        reverseStack(s); // recursion call
        pushBottom(s, top); // backtracking for top element to push bottom
    }

    // Q-4 Stock span Problem --------------------------------
    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        span[0] = 1;
        for (int i = 1; i < span.length; i++) {
            int currStock = stocks[i];
            while (!s.isEmpty() && currStock >= stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    // Next greater element --------------------------------
    public static void nextGreaterEle(int arr[], int nextGreater[]) { // TC -> O(2n + n) => O(n)
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) { // backwards travers
            // while loop to pop lessthan element idx
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) { // stack not empty && lessthan
                s.pop();
            }
            // step-1 if-else or add greater element in nextGreater
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            // push current idx in stack
            s.push(i);
        }
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
        System.out.println();

        // Q-1 Push at the bottom of the Stack -------------------------------- 
        Stack<Integer> st2 = new Stack<>();
        st2.push(1);
        st2.push(2);
        st2.push(3);
        pushBottom(st2, 4);
        printStack(st2);

        // Q-2 Reverse a String using a Stack --------------------------------
        System.out.println(reverseString("jack"));
        System.out.println();

        // Q-3 Reverse a Stack --------------------------------
        Stack<Integer> st3 = new Stack<>();
        st3.push(1);
        st3.push(2);
        st3.push(3);
        reverseStack(st3);
        printStack(st3);

        // Q-4 Stock span Problem --------------------------------
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);

        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
        System.out.println("\n");

        // Next greater element --------------------------------
        // Next greater element of some element x in an array in the first greater 
        // element that is to the right of x in the same array.
        // 1st Approach -> Nested Loop (TC - O(n^2))
        // 2nd Using Stack Approach ->  (TC - O(n))
        int arr[] = { 6, 8, 0, 1, 3 };
        int nextGreater[] = new int[arr.length];
        nextGreaterEle(arr, nextGreater);
        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println("\n");

    }
}