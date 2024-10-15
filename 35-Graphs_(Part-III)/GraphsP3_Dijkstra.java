import java.util.ArrayList;
import java.util.PriorityQueue;

public class GraphsP3_Dijkstra {
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
         *              (7)
         *        1 ——————————→ 3  
         *      ↗ |             ↑ \
         *  (2)/  |             |  \(1)
         *    /   |             |   ↘
         *  0     |(1)       (2)|    5
         *    \   |             |   ↗
         *  (4)\  |             |  /(5)
         *      ↘ ↓             | /
         *        2 ——————————→ 4
         *              (3)
         */
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    // Create Pair class to store node & distance in sorted order
    static class Pair implements Comparable<Pair> {
        int n; // node
        int path; // path distance

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        // deside Which bases to compare
        public int compareTo(Pair p2) { // Compare to p1 - p2 (Sorted order)
            return this.path - p2.path; // path based sorting for my Pair
        }
    }

    // Dijkstra Algorithm (Shortest Path Src to All vertices) -------------------------------- TC -> O(V + E logV)
    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        // Create distances Array & initialize
        int[] dist = new int[graph.length]; // dist[i] = src to i
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE; // +infinity
            }
        }
        // Visited Array 
        boolean[] visited = new boolean[graph.length];
        // Create PriorityQueue
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0)); // add src to src 
        // BFS loop
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.n]) {
                visited[curr.n] = true;
                // neighbors
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src; // current = e.src ya curr.n
                    int v = e.dest; // neighbor
                    int wt = e.wt; // weight
                    if (dist[u] + wt < dist[v]) { // Update distance of source(u) to vertex(v)
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v])); // Add new pair in Priority Queue
                    }
                }
            }
        }
        // Print all source to all vertices Path
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Source " + src + " to destination " + i + " Sorted path : " + dist[i]);
        }
    }

    public static void main(String[] args) {
        // Dijkstra Algorithms --------------------------------
        // Shortest paths from the source to all vertices (Weighted Graph)
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph); // call for create graph
        int src = 0;
        dijkstra(graph, src);

    }
}
