import java.util.ArrayList;
import java.util.Collections;

public class GraphsP5_Kruskal {
    // Create Edge Class
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge p2) {
            return this.wt - p2.wt; // ascending order
        }
    }

    // Create Graph use Edge list
    public static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    // Union
    static int n = 4; // vertices count
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]); // Path compression optimization
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (rank[parA] == rank[parB]) {
            par[parB] = parA; // B join to A
            rank[parA]++; // increment rank of A
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB; // A join to B
        } else {
            par[parB] = parA; // B join to A
        }
    }

    // Kruskal's algorithm (MST) -------------------------------- TC -> O(V + E logE)
    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        init(); // initialize parent array
        Collections.sort(edges); // O(E logE)
        int mstCost = 0;
        int count = 0;
        for (int i = 0; count < V - 1; i++) { // O(V)
            Edge e = edges.get(i);
            if (find(e.src) != find(e.dest)) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }
        System.out.println("MST cost : " + mstCost);
    }

    public static void main(String[] args) {
        // Kruskal's algorithm --------------------------------
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalsMST(edges, V);
    }
}
