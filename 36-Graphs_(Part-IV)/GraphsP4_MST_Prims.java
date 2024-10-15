import java.util.ArrayList;
import java.util.PriorityQueue;

public class GraphsP4_MST_Prims {
    // Create Weighted Edge ---
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Create Graph ---
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        /*  
         *            0
         *          / | \
         *     (10)/  |  \(15)
         *        /   |   \         Undirected & Weighted Graph
         *       1    |(30)2
         *        \   |   /
         *     (40)\  |  /(50)
         *          \ | / 
         *            3 
         */
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        int cost;

        public Pair(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    // Prims Algorithms -------------------------------- TC -> O(E logE)
    public static void prims(ArrayList<Edge>[] graph) {
        int finalCost = 0; // total minimum weight cost / MST cost
        boolean visited[] = new boolean[graph.length]; // visited array
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // create priority queue for store pairs of vertex and cost
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.vertex]) {
                visited[curr.vertex] = true;
                finalCost += curr.cost;
                for (int i = 0; i < graph[curr.vertex].size(); i++) {
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println("MST cost : " + finalCost);
    }

    public static void main(String[] args) {
        // Minimum Spanning Tree (MST) --------------------------------
        // A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, 
        // edge-weighted undirected graph that connects all the vertices together, without any cycles and with 
        // the minimum possible total edge weight.

        // Prims Algorithms --------------------------------
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph); // call for create graph
        prims(graph);
    }
}
