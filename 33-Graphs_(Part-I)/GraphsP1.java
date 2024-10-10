import java.util.ArrayList;

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
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.dest + " ");
        }
    }
}