import java.util.ArrayList;

public class GraphsP4_BellmanFord {
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
         *              (-1)
         *        1 ←—————————— 4 
         *      ↗ |             ↑           Edge = 6
         *  (2)/  |             |           Vertices = 5 (nodes)
         *    /   |             |
         *  0     |(-4)         |(4)
         *    \   |             |
         *  (4)\  |             |
         *      ↘ ↓             |
         *        2 ——————————→ 3
         *              (2)
         */
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    // Bellman Ford Algorithm (Shortest Path Src to All vertices) -------------------------------- TC -> O(V*E)
    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
        // Create a Array to store distances & initialize
        int[] dist = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;

        for (int i = 0; i < V - 1; i++) { // Algorithm loop - O(V)
            for (int j = 0; j < graph.length; j++) { // Vertices loop - (E)
                for (int k = 0; k < graph[j].size(); k++) { // Edge loop
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) { // Relaxation
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Source " + src + " to destination " + i + " Sorted path : " + dist[i]);
        }
    }

    // 2nd Sorted Method with sort code (Bellman Ford) --------------------------------
    // Create Graph ---
    public static void createGraph2(ArrayList<Edge> graph) { // Edges graph
        /*  
         *              (-1)
         *        1 ←—————————— 4 
         *      ↗ |             ↑           Edge = 6
         *  (2)/  |             |           Vertices = 5 (nodes)
         *    /   |             |
         *  0     |(-4)         |(4)
         *    \   |             |
         *  (4)\  |             |
         *      ↘ ↓             |
         *        2 ——————————→ 3
         *              (2)
         */
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2, -4));

        graph.add(new Edge(2, 3, 2));

        graph.add(new Edge(3, 4, 4));

        graph.add(new Edge(4, 1, -1));
    }

    // Bellman Ford Algorithm (Shortest Path Src to All vertices) -------------------------------- TC -> O(V*E)
    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V) {
        // Create a Array to store distances & initialize
        int[] dist = new int[V];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < V - 1; i++) { // Algorithm loop - O(V)
            for (int k = 0; k < graph.size(); k++) { // Edge loop - O(E)
                Edge e = graph.get(k);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) { // Relaxation
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Source " + src + " to destination " + i + " Sorted path : " + dist[i]);
        }
    }

    public static void main(String[] args) {
        // Bellman Ford Algorithms --------------------------------
        // Shortest paths from the source to all vertices (Weighted Graph)
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph); // call for create graph
        int src = 0;
        bellmanFord(graph, src);
        System.out.println();

        // 2nd Sorted Method with sort code (Bellman Ford) --------------------------------
        ArrayList<Edge> graph2 = new ArrayList<>();
        createGraph2(graph2);
        bellmanFord2(graph2, src, V);
    }

}