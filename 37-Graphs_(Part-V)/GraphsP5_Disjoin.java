public class GraphsP5_Disjoin {
    static int n = 7;
    static int par[] = new int[n]; // Create an static array to use every function
    static int rank[] = new int[n];

    // Initialize ---
    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    // Find ---
    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        // return find(par[x]);
        return par[x] = find(par[x]); // Path compression optimization
    }

    // Inion ---
    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (rank[parA] == rank[parB]) {
            par[parB] = parA; // parent of parB = parA
            rank[parA]++; // parent parA rank increment by 1.
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void main(String[] args) {
        // Disjoin Set Data Structure (Union Find DS /  Merge DS) --------------------------------
        // Use this DS -> Cycle detection / Kruskal's algorithm
        init(); // initialize parent values
        System.out.println("Parent of 3 : " + find(3)); // 3
        union(1, 3);
        System.out.println("Parent of 3 : " + find(3)); // 1
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println("Parent of 3 : " + find(3)); // 1
        System.out.println("Parent of 4 : " + find(4)); // 1
        union(1, 5);
        System.out.println("Parent of 5 : " + find(5)); // 1

    }
}
