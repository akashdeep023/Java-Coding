import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class GraphsP2 {
    // Create a Graph (Using Adjacency List)
    static class Edge { // Create Edge for Graphs
        int src; // Source
        int dest; // Destination
        int wt; // Weight

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // BFS Graph Traversal Connected Components -------------------------------- TC -> O(V+E)
    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfsUtil(graph, visited);
            }
        }
    }

    // helper bfs util function
    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // source (starting point)
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) { // visite curr
                System.out.print(curr + " "); // print
                visited[curr] = true; // visite
                for (int i = 0; i < graph[curr].size(); i++) { // curr neighbors add in queue 
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // DFS Graph Traversal Connected Components -------------------------------- TC -> O(V+E)
    public static void dfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfsUtil(graph, i, visited);
            }
        }
    }

    // helper dfs util function
    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        // visite curr
        System.out.print(curr + " ");
        visited[curr] = true;
        // call for 1st neighbor if is not visited
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfsUtil(graph, e.dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        // Connected Components --------------------------------
        // Create BSF & DFS Functions

    }
}