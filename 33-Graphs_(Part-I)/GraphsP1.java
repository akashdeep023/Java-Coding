import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphsP1 {
    // Create a Graph (Using Adjacency List) --------------------------------
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

    // BFS Graph Traversal -------------------------------- TC -> O(V+E)
    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
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

    // DFS Graph Traversal -------------------------------- TC -> O(V+E)
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        // visite curr
        System.out.print(curr + " ");
        visited[curr] = true;
        // call for 1st neighbor if is not visited
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    // Has Path (DFS) -------------------------------- TC -> O(V+E)
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) { // base case
            return true;
        }
        visited[src] = true; // visited src
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) { // not visited && call for next neighbor
                return true;
            }
        }
        return false; // not found in graph then return false
    }

    public static void main(String[] args) {
        /* 
         * Introduction --------------------------------
         * Graphs -> Network of Vertices (Nodes)
         *    Ex: 
         *          1   4 —— 9
         *           \ / \
         *            6   3 —— 8
         *                 \
         *                  12
         * 
         *  Single node -> Vertex
         *  Connection to node -> Edge
         * 
         * Type Of Graphs (Based on Edge) --------------------------------
         * Direction ---
         * 1. Uni-Directional (Directed Graph)
         *    Ex: A ⇾ B
         * 2. Un-Directed / Bi-Directional (Undirected Graph)
         *    Ex: A — B 
         *        A ←→ B
         * 
         * Weight ---
         * 1. Weighted
         *    Ex: Weight of Edge = +ve & -ve
         * 
         * 2. Un-Weighted
         *    Ex: Weight of Edge = None
         * 
         * Graph Representations (Storing a Graph) --------------------------------
         * 1. Adjacency List (Important) -> Array<ArrayList><Edge><src,dest,wt> , TC -> O(K) where K is your neighbours length
         * 2. Adjacency Matrix -> (i,j) connect sotre 1 ya weight otherwise store 0 , TC -> O(V) where V is vertices count
         * 3. Edge List
         * 4. 2d Matris (Implicit Graph)
         * 
         * Graph Application --------------------------------
         * Ex: Google Maps, Social Network, Delivery Network (Shortest Cyclic Route), Physics & Chemistry (Atom-Molicules)
         *     Routing Algorithms, Machine Learning (Computation Graph), Dependency Graph (Windows->VS Code->Extensions)
         *     Computer Vision (Image Segmentation), Graph Databases (Nebula or neo4g), Research (Human Neurons), etc.
         *
         * Create a Graph (Using Adjacency List) --------------------------------
         * 
         *                (5)
         *            0 —————— 1
         *                    / \
         *                (1)/   \(3)
         *                  /     \
         *                 2 ————— 3
         *                 |  (1)
         *              (2)|
         *                 |
         *                 4
         */
        int V = 5; // Vertex count
        @SuppressWarnings("unchecked") // Remove Warning
        ArrayList<Edge>[] graph = new ArrayList[V]; // int[] arr = new int[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // null -> empty arraylist initalizes
        }
        // 0-vertex
        graph[0].add(new Edge(0, 1, 5));
        // 1-vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        // 2-vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        // 3-vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        // 4-vertex
        graph[4].add(new Edge(4, 2, 2));

        // 2's neighbors
        System.out.print("2's neighbors : ");
        for (int i = 0; i < graph[2].size(); i++) { // TC -> O(E) Where E is Edge length
            Edge e = graph[2].get(i);
            System.out.print(e.dest + " ");
        }
        System.out.println("\n");

        // Graph Traversal --------------------------------
        // Breadth First Search (BFS)
        // Depth First Search (DFS)
        /*
         *    1 —— 3
         *   /     | \
         *  0      |  5 —— 6
         *   \     | /
         *    2 —— 4
         */
        int V2 = 7;
        @SuppressWarnings("unchecked") // Remove Warning
        ArrayList<Edge>[] graph2 = new ArrayList[V2]; // int[] arr = new int[V];
        for (int i = 0; i < graph2.length; i++) {
            graph2[i] = new ArrayList<>(); // null -> empty arraylist initalizes
        }
        // 0-vertex
        graph2[0].add(new Edge(0, 1, 1));
        graph2[0].add(new Edge(0, 2, 1));
        // 1-vertex
        graph2[1].add(new Edge(1, 0, 1));
        graph2[1].add(new Edge(1, 3, 1));
        // 2-vertex
        graph2[2].add(new Edge(2, 0, 1));
        graph2[2].add(new Edge(2, 4, 1));
        // 3-vertex
        graph2[3].add(new Edge(3, 1, 1));
        graph2[3].add(new Edge(3, 4, 1));
        graph2[3].add(new Edge(3, 5, 1));
        // 4-vertex
        graph2[4].add(new Edge(4, 2, 1));
        graph2[4].add(new Edge(4, 3, 1));
        graph2[4].add(new Edge(4, 5, 1));
        // 5-vertex
        graph2[5].add(new Edge(5, 3, 1));
        graph2[5].add(new Edge(5, 4, 1));
        graph2[5].add(new Edge(5, 6, 1));
        // 6-vertex
        graph2[6].add(new Edge(6, 5, 1));
        // Breadth First Search (BFS) ---
        System.out.print("BFS Traversing : ");
        bfs(graph2);
        System.out.println("\n");

        // Depth First Search (DFS) ---
        System.out.print("DFS Traversing : ");
        dfs(graph2, 0, new boolean[V2]);
        System.out.println("\n");

        // Has Path --------------------------------
        // For given src & dest, tell if a path exists from src to dest
        System.out.print("Has Path " + 0 + " to " + 5 + " : " + hasPath(graph2, 0, 5, new boolean[V2]));
        System.out.println();
        System.out.print("Has Path " + 0 + " to " + 7 + " : " + hasPath(graph2, 0, 7, new boolean[V2]));
        System.out.println();

    }
}