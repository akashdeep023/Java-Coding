import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class GraphsP3_Topological_Sort {
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

    // Topological Sorting (BFS) -------------------------------- TC -> O(V+E) SC -> O(V)
    public static void topologicalSort(ArrayList<Edge>[] graph) {
        int[] inDegree = new int[graph.length];
        calcInDegree(graph, inDegree);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        System.out.print("Topological Sort : ");
        while (!q.isEmpty()) { // BFS
            int curr = q.remove();
            System.out.print(curr + " "); // Print Topological Sort
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDegree[e.dest]--;
                if (inDegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void calcInDegree(ArrayList<Edge>[] graph, int[] inDeg) { // Calculates the in-degree or vertex (node)
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDeg[e.dest]++;
            }
        }
    }

    public static void main(String[] args) {
        // Topological Sorting (BFS) --------------------------------
        // Directed Acyclic Graph (DAG) is a directed graph with no cycles.
        // Topological sorting is used only for DAGs (Not for non-DAGs)
        // It is a linear order of vertices such that every directed edge u —→ v,
        // the vertex u comes before v in the order.
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topologicalSort(graph); // Topological Sort : 4 5 0 2 3 1
    }
}