import java.util.ArrayList;

public class GraphsP2_Cycle_UG {
    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        /*
         * 1 —— 0 ————3
         *   \  |     |
         *    \ |     |
         *      2     4
         */
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    // Cycle Detection (Undirection Graph) DFS -------------------------------- TC -> O(V+E) where V is vertex & E is edge
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, visited, i, -1)) { // pass as a argument (graph, visited, current, parent)
                    return true; // cycle exists in one of the parts
                }

            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, int par) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) { // not visited but neighbor exists cycle
                if (detectCycleUtil(graph, visited, e.dest, curr)) {
                    return true;
                }
            } else if (visited[e.dest] && e.dest != par) { // visited && neighbor != parent
                return true;
            }

            // visited && neighbor == parent -> Do nothing -> continue
        }
        return false;
    }

    public static void main(String[] args) {
        // Cycle Detection (Undirection Graph) --------------------------------
        int V = 5;
        @SuppressWarnings("unchecked") // Remove unnecessary warnings
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println("Cycle Detect : " + detectCycle(graph));
    }
}
