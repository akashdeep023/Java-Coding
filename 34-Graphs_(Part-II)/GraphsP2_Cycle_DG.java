import java.util.ArrayList;

public class GraphsP2_Cycle_DG {
    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        /*
         *  Directed Graph -> Cycle Exist (True)
         * 
         *  1 ——→ 0 ←——  3
         *        \     ↗
         *         ↘  /
         *           2  
         */
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));

    }

    static void createGraph2(ArrayList<Edge>[] graph) {
        /*
         *  Directed Graph -> Cycle Exist (True)
         * 
         *   0 ———→ 1
         *   |      |
         *   ↓      ↓
         *   2 ←——— 3 
         */
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));

        graph[3].add(new Edge(3, 2));

    }

    // Cycle Detection (Direction Graph) DFS -------------------------------- TC -> O(V+E) where V is vertex & E is edge
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length]; // Visited or not visited
        boolean[] stack = new boolean[graph.length]; // Stack call
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, i, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, boolean[] stack) {
        visited[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) { // Already in stack -> cycle exist
                return true;
            }
            if (!visited[e.dest] && detectCycleUtil(graph, e.dest, visited, stack)) { // Not visited -> Call recursively
                return true;
            }
        }
        stack[curr] = false; // Remove from stack
        return false;
    }

    public static void main(String[] args) {
        // Cycle Detection (Direction Graph) --------------------------------
        int V = 4;
        @SuppressWarnings("unchecked") // Remove unnecessary warnings
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph); // Create Cycle Graph. Output -> True
        System.out.println("Cycle Detect : " + detectCycle(graph));

        @SuppressWarnings("unchecked") // Remove unnecessary warnings
        ArrayList<Edge>[] graph2 = new ArrayList[V];
        createGraph2(graph2); // Create No-Cycle Graph. Output -> False
        System.out.println("Cycle Detect : " + detectCycle(graph2));
    }
}
