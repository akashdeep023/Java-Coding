import java.util.PriorityQueue;

public class HeapQ {
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

    }
}