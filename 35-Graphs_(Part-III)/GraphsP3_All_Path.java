import java.util.ArrayList;

public class GraphsP3_All_Path {
    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        /*
         *  Directed Graph 
         * 
         *   5 ———→ 0 ←——— 4     Output -> 5031
         *   |      |      |               5231
         *   ↓      ↓      ↓ 
         *   2 ———→ 3 ———→ 1
         */
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    // All Paths from Source to Target (DFS) -------------------------------- TC -> O(V^V)
    public static void allPath(ArrayList<Edge>[] graph, int src, int dest, StringBuilder path) {
        if (src == dest) {
            System.out.println(path.toString() + src);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            path.append(src);
            Edge e = graph[src].get(i);
            allPath(graph, e.dest, dest, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        // All Paths from Source to Target --------------------------------
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        int src = 5;
        int dest = 1;
        System.out.println("Print all path from " + src + " to " + dest + " :-");
        allPath(graph, src, dest, new StringBuilder(""));
    }
}
