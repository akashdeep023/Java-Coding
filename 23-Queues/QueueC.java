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
    public static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front; // rear + 1 == front (full)
        }

        public void add(int data) { // add TC -> O(1)
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) { // add first element
                front = 0;
            }
            rear = (rear + 1) % size; // size = 3 (rear = 0,1,2,0,1..)
            arr[rear] = data;
        }

        public int remove() { // remove TC -> O(1)
            if (isEmpty()) {
                return -1;
            }
            int data = arr[front];
            if (rear == front) { // last element delete
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return data;
        }

        public int peek() { // peek TC -> O(1)
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        // Queue using Arrays --------------------------------
        // Queue q = new Queue(5);
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while (!q.isEmpty()) { // Queue Output -> 1 2 3
        //     System.out.println(q.peek());
        //     q.remove();
        // }       

        // Circular Queue using Arrays --------------------------------
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        while (!q.isEmpty()) { // Circular Queue Output -> 1 2 3 4 5
            System.out.println(q.peek());
            q.remove();
        }

    }
}