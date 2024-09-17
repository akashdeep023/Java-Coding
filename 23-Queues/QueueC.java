import java.util.*;
import java.util.LinkedList;

public class QueueC {
    // Array --------------------------------
    // static class Queue {
    //     static int arr[];
    //     static int size;
    //     static int rear;

    //     Queue(int n) { // constructor (n = array size)
    //         arr = new int[n];
    //         size = n;
    //         rear = -1;
    //     }

    //     public boolean isEmpty() { // Check Queue is empty
    //         return rear == -1;
    //     }

    //     public void add(int data) { // Add data (TC -> O(1))
    //         if (rear == size - 1) {
    //             System.out.println("Queue is full");
    //             return;
    //         }
    //         rear++;
    //         arr[rear] = data;
    //     }

    //     public int remove() { // Remove data (TC -> O(n))
    //         if (isEmpty()) { // Queue is empty
    //             return -1;
    //         }
    //         int front = arr[0];
    //         // for (int i = 1; i < arr.length; i++) {
    //         //     arr[i - 1] = arr[i]; // remove front element
    //         // }
    //         for (int i = 0; i < rear; i++) {
    //             arr[i] = arr[i + 1];
    //         }
    //         rear--;
    //         return front;
    //     }

    //     public int peek() { // Peek data (TC -> O(1))
    //         if (isEmpty()) { // Queue is empty
    //             return -1;
    //         }
    //         return arr[0];
    //     }
    // }

    // Circular Queue using Arrays --------------------------------
    // static class Queue {
    //     static int arr[];
    //     static int size;
    //     static int rear;
    //     static int front;

    //     Queue(int n) {
    //         arr = new int[n];
    //         size = n;
    //         rear = -1;
    //         front = -1;
    //     }

    //     public boolean isEmpty() {
    //         return rear == -1 && front == -1;
    //     }

    //     public boolean isFull() {
    //         return (rear + 1) % size == front; // rear + 1 == front (full)
    //     }

    //     public void add(int data) { // add TC -> O(1)
    //         if (isFull()) {
    //             System.out.println("Queue is full");
    //             return;
    //         }
    //         if (front == -1) { // add first element
    //             front = 0;
    //         }
    //         rear = (rear + 1) % size; // size = 3 (rear = 0,1,2,0,1..)
    //         arr[rear] = data;
    //     }

    //     public int remove() { // remove TC -> O(1)
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         int data = arr[front];
    //         if (rear == front) { // last element delete
    //             rear = front = -1;
    //         } else {
    //             front = (front + 1) % size;
    //         }
    //         return data;
    //     }

    //     public int peek() { // peek TC -> O(1)
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         return arr[front];
    //     }
    // }

    // LinkedList --------------------------------
    // static class Node {
    //     int data;
    //     Node next;

    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }

    // static class Queue {
    //     static Node head = null;
    //     static Node tail = null;

    //     public boolean isEmpty() {
    //         return head == null && tail == null;
    //     }

    //     public void add(int data) { // add TC -> O(1)
    //         Node newNode = new Node(data);
    //         if (isEmpty()) { // first element add
    //             head = tail = newNode;
    //             return;
    //         }
    //         tail.next = newNode;
    //         tail = newNode;
    //     }

    //     public int remove() { // remove TC -> O(1)
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         int front = head.data;
    //         if (head == tail) { // last element delete
    //             head = tail = null;
    //         } else {
    //             head = head.next;
    //         }
    //         return front;
    //     }

    //     public int peek() { // peek TC -> O(1)
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }

    // 2 Stack --------------------------------
    // static class Queue {
    //     static Stack<Integer> s1 = new Stack<>();
    //     static Stack<Integer> s2 = new Stack<>();

    //     public boolean isEmpty() {
    //         return s1.isEmpty();
    //     }

    //     public void add(int data) { // add TC -> O(2n) = O(n)
    //         while (!s1.isEmpty()) { // O(n)
    //             s2.push(s1.pop()); // move element s1 to s2
    //         }
    //         s1.push(data); // O(1)
    //         while (!s2.isEmpty()) { // O(n)
    //             s1.push(s2.pop()); // move element s2 to s1
    //         }
    //     }

    //     public int remove() { // remove TC -> O(1)
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         return s1.pop();
    //     }

    //     public int peek() { // peek TC -> O(1)
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         return s1.peek();
    //     }
    // }

    // Stack using 2 Queue --------------------------------
    // static class Stack {
    //     static Queue<Integer> q1 = new LinkedList<>();
    //     static Queue<Integer> q2 = new LinkedList<>();

    //     public boolean isEmpty() {
    //         return q1.isEmpty() && q2.isEmpty();
    //     }

    //     public void push(int data) { // push TC -> O(1)
    //         if (!q1.isEmpty()) {
    //             q1.add(data);
    //         } else {
    //             q2.add(data);
    //         }
    //     }

    //     public int pop() { // pop TC -> O(n)
    //         if (isEmpty()) { // empty stack
    //             return -1;
    //         }
    //         int top = -1;
    //         if (!q1.isEmpty()) { // case-1
    //             while (!q1.isEmpty()) {
    //                 top = q1.remove();
    //                 if (q1.isEmpty()) { // q1 is empty then break
    //                     break;
    //                 }
    //                 q2.add(top);
    //             }
    //         } else { // case-2
    //             while (!q2.isEmpty()) {
    //                 top = q2.remove();
    //                 if (q2.isEmpty()) { // q2 is empty then break
    //                     break;
    //                 }
    //                 q1.add(top);
    //             }
    //         }
    //         return top;
    //     }

    //     public int peek() { // peek TC -> O(n)
    //         if (isEmpty()) { // empty stack
    //             return -1;
    //         }
    //         int top = -1;
    //         if (!q1.isEmpty()) { // case-1
    //             while (!q1.isEmpty()) {
    //                 top = q1.remove();
    //                 q2.add(top);
    //             }
    //         } else { // case-2
    //             while (!q2.isEmpty()) {
    //                 top = q2.remove();
    //                 q1.add(top);
    //             }
    //         }
    //         return top;
    //     }
    // }

    // First Non-Repeating latter --------------------------------
    public static void printNonRepeating(String str) { // TC -> O(n)
        Queue<Character> q = new LinkedList<>(); // Use Queue because first character is need
        int freq[] = new int[26]; // 'a' to 'z'
        for (int i = 0; i < str.length(); i++) { // loop for each character traversed
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print("-1" + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
        if (q.isEmpty()) { // print last non-repeating character
            System.out.println("No First non-repeating letter");
        } else {
            System.out.println("First non-repeating letter : " + q.peek());
        }
    }

    public static void main(String[] args) {
        // Queue using Arrays --------------------------------
        // Queue q = new Queue(5); // size of queue = 5 (array size)
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while (!q.isEmpty()) { // Queue Output -> 1 2 3
        //     System.out.println(q.peek());
        //     q.remove();
        // }       

        // Circular Queue using Arrays --------------------------------
        // Queue q = new Queue(3); // size of queue = 5 (array size)
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // System.out.println(q.remove());
        // q.add(4);
        // System.out.println(q.remove());
        // q.add(5);
        // while (!q.isEmpty()) { // Circular Queue Output -> 1 2 3 4 5
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        // Queue using LinkedList --------------------------------
        // Queue q = new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while (!q.isEmpty()) { // Queue Output -> 1 2 3
        //     System.out.println(q.peek());
        //     q.remove(); 
        // }

        // Queue using Collections framework --------------------------------
        // Queue is an interface its not an object so create it from LinkedList & ArrayDeque --
        // Queue<Integer> q = new LinkedList<>(); // LinkedList
        // Queue<Integer> q = new ArrayDeque<>(); // ArrayDeque
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        // Queue using 2 Stack --------------------------------
        // Queue q = new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while (!q.isEmpty()) { // Queue Output -> 1 2 3
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        // Stack using 2 Queue --------------------------------
        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // while (!s.isEmpty()) { // Stack Output -> 3 2 1
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        // First Non-Repeating latter --------------------------------
        // First non-repeating latter in a stream of characters. (Solve using Queue)
        String str = "aabccxb";
        printNonRepeating(str);

        // 
    }
}