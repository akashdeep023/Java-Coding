public class QueueC {
    // Array --------------------------------
    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) { // constructor (n = array size)
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty() { // Check Queue is empty
            return rear == -1;
        }

        public void add(int data) { // Add data (TC -> O(1))
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        public int remove() { // Remove data (TC -> O(n))
            if (isEmpty()) { // Queue is empty
                return -1;
            }
            int front = arr[0];
            // for (int i = 1; i < arr.length; i++) {
            //     arr[i - 1] = arr[i]; // remove front element
            // }
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        public int peek() { // Peek data (TC -> O(1))
            if (isEmpty()) { // Queue is empty
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        // Queue using Arrays --------------------------------
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
        System.out.println();

    }
}