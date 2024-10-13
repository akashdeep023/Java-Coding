import java.util.ArrayList;
import java.util.Stack;

public class GraphsP2_Topological_Sort {
    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        /*
         *  Directed Acyclic Graph - DAG (Acyclic -> No-cycle)
         * 
         *   5 ———→ 0 ←——— 4
         *   |             |
         *   ↓             ↓ 
         *   2 ———→ 3 ———→ 1
         */
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    // Topological Sorting -------------------------------- TC -> O(V+E) SC -> O(V)
    public static void topologicalSort(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topologicalSortUtil(graph, i, visited, stack);
            }
        }
        System.out.print("Topological Sort : ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topologicalSortUtil(graph, e.dest, visited, stack);
            }
        }
        stack.push(curr);
    }

    public static void main(String[] args) {
        // Topological Sorting --------------------------------
        // Directed Acyclic Graph (DAG) is a directed graph with no cycles.
        // Topological sorting is used only for DAGs (Not for non-DAGs)
        // It is a linear order of vertices such that every directed edge u —→ v,
        // the vertex u comes before v in the order.
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topologicalSort(graph); // Topological Sort : 5 4 2 3 1 0
    }
}
