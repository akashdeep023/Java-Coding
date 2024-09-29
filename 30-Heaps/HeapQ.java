import java.util.PriorityQueue;

public class HeapQ {
    // Nearby Cars--------------------------------
    static class Point implements Comparable<Point> { // use Comarable interface bases on Point class
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq; // ascending order
        }
    }

    // Weakest Soldier --------------------------------
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row j) {
            if (this.soldiers == j.soldiers) {
                return this.idx - j.idx;
            } else {
                return this.soldiers - j.soldiers;
            }
        }
    }

    // Sliding Window Maximum  --------------------------------
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            // return this.val - p2.val; // Ascending comparison
            return p2.val - this.val; // Descending comparison
        }
    }

    public static void main(String[] args) {
        // Nearby Cars --------------------------------
        // We are given N points in a 2D plane which are locations of N cars.
        // If we are at the origin, print the nearest K cars.
        int[][] pts = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }
        for (int i = 0; i < k; i++) {
            System.out.print("C" + pq.peek().idx + "-" + pq.remove().distSq + " ");
        }
        System.out.println("\n");

        // Connect N ropes with Minimum Cost --------------------------------
        // Given are N ropes of different lengths, the task is to connect these ropes into one rope with
        // minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.
        // int ropes[] = { 4, 3, 2, 6 }; // Output Cost : 29
        int ropes[] = { 2, 3, 3, 4, 6 }; // Output Cost : 41
        PriorityQueue<Integer> rpq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            rpq.add(ropes[i]);
        }
        int cost = 0;
        while (rpq.size() > 1) {
            int length = rpq.remove() + rpq.remove();
            cost += length;
            rpq.add(length);
        }
        System.out.println("Min cost of connecting n ropes : " + cost);
        System.out.println();

        // Weakest Soldier --------------------------------
        // We are given an mXn binary matrix of 1's (soldiers) and 0's (civilians). The soldiers are
        // positioned in front of the civilians. That is, all the 1's will appear to the left of 
        // all the 0's in each ros.
        // A row i is weaker than a row j if one of the following is true:
        // - The number of soldiers in row i is less than the number of soldirs in row j.
        // - Both rows have the same number of soldirs and i<j.
        // Find the K weakest row.
        // m = 4, n = 4, k = 2 ans = row0 & row2
        int army[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 },
        };
        PriorityQueue<Row> apq = new PriorityQueue<>();
        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army.length; j++) {
                count += army[i][j];
            }
            apq.add(new Row(count, i));
        }
        System.out.print("Weakest soldier row : ");
        for (int i = 0; i < 2; i++) {
            System.out.print("Row" + apq.remove().idx + " ");
        }
        System.out.println();

        // Sliding Window Maximum -------------------------------- TC -> O(n logk)
        // Maximum of all Subarrays of Size K ---
        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // Output -> 3 4 5 6 7 8 9 10
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 }; // Output -> 3 3 5 5 6 7
        int K = 3; // window size
        int res[] = new int[arr.length - K + 1]; // n-k+1
        PriorityQueue<Pair> ppq = new PriorityQueue<Pair>(); // All ready descending priority queue - Comparator.reverseOrder()
        // Add 1st Window
        ppq.add(new Pair(arr[0], 0));
        ppq.add(new Pair(arr[1], 1));
        ppq.add(new Pair(arr[2], 2));
        res[0] = ppq.peek().val; // max value of 1st Window
        // Add Next Window
        for (int i = K; i < arr.length; i++) {
            while (!ppq.isEmpty() && ppq.peek().idx <= i - K) { // Window index not in range
                ppq.remove();
            }
            ppq.add(new Pair(arr[i], i));
            res[i - K + 1] = ppq.peek().val;
        }
        // Print Max Window Size
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}