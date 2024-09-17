import java.util.*;
import java.util.LinkedList;

public class DequeC {
    // Implement Stack using Deque --------------------------------
    static class Stack {
        Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty() {
            return dq.isEmpty();
        }

        public void push(int data) {
            dq.addLast(data);
        }

        public int pop() {
            return dq.removeLast();
        }

        public int peek() {
            return dq.getLast();
        }
    }

    // Implement Queue using Deque --------------------------------
    static class Queue {
        Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty() {
            return dq.isEmpty();
        }

        public void add(int data) {
            dq.addLast(data);
        }

        public int remove() {
            return dq.removeFirst();
        }

        public int peek() {
            return dq.getFirst();
        }
    }

    public static void main(String[] args) {
        // Deque (Double ended Queue) --------------------------------
        // Deque -> (Data structure) 
        // Dequeue -> Verb / Action / Method (Remove the first element from the queue)
        // Enqueue -> Verb / Action / Method (Add the last element to the queue)
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1); // add first
        deque.addFirst(2);
        deque.addLast(3); // add last
        deque.addLast(4);
        System.out.println(deque); // 2 1 3 4
        deque.removeFirst(); // remove first
        System.out.println(deque); // 1 3 4
        deque.removeLast(); // remove last
        System.out.println(deque); // 1 3 
        System.out.println("First element : " + deque.getFirst());
        System.out.println("Last element : " + deque.getLast());
        System.out.println();

        // Implement Stack using Deque --------------------------------
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek = " + s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println();

        // Implement Queue using Deque --------------------------------
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("peek = " + q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());

    }
}
