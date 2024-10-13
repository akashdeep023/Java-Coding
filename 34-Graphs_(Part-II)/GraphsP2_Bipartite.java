import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class GraphsP2_Bipartite {
    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        /*
         * 1 ———— 0 ———— 2
         *  \           /
         *   \         /
         *    3 ————— 4
         */
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    // Bipartite Graph BFS -------------------------------- TC -> O(V+E) & SC -> O(V) where V is vertex & E is edge
    public static boolean isBipartiteGraph(ArrayList<Edge>[] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = -1; // no colors
        }
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (isBipartiteGraphUtil(graph, i, colors)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isBipartiteGraphUtil(ArrayList<Edge>[] graph, int curr, int[] colors) { // BSF
        Queue<Integer> q = new LinkedList<>();
        q.add(curr); // add in queue
        colors[curr] = 0; // add color (Yellow)
        while (!q.isEmpty()) {
            curr = q.remove();
            for (int level = 0; level < graph[curr].size(); level++) { // current Edge neighbor traversal
                Edge e = graph[curr].get(level);
                if (colors[e.dest] == colors[curr]) { // same color
                    return false;
                } else if (colors[e.dest] == -1) { // add color
                    q.add(e.dest);
                    colors[e.dest] = (colors[curr] == 0) ? 1 : 0;
                }
                // deffered color -> continue
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Bipartite Graph --------------------------------
        // If graph doesn't have cycle -> Bipartite Graph (true)
        int V = 5;
        @SuppressWarnings("unchecked") // Remove unnecessary warnings
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println("Is Bipartite graph : " + isBipartiteGraph(graph));
    }
}
