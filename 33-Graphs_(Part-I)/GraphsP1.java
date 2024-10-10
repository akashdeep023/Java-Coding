public class GraphsP1 {
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
         */

    }
}