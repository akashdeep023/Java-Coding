import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class GraphsP5_CheapestFlights {
    // Create Edge Class ---
    static class Edge {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Create Graph ---
    public static void createGraph(ArrayList<Edge> graph[], int flights[][]) {
        for (int i = 0; i < graph.length; i++) { // initialize ArrayList of all vertices
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new Edge(flights[i][0], flights[i][1], flights[i][2]));
        }
    }

    // Create Info Class ---
    static class Info { // Already sorted based on stops
        int vertex; // vertex
        int cost; // cost/distance
        int stops; // number of stops

        public Info(int vertex, int cost, int stops) {
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }
    }

    // Cheapest Flights With in K Stops --------------------------------
    public static int cheapestFlights(int n, int flights[][], int src, int dst, int k) {
        // Create graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, flights);
        // Create cost array
        int dist[] = new int[n];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        // Create Queue for store Info (vertex,cost,stops)
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0)); // add src to src 

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }
            for (int i = 0; i < graph[curr.vertex].size(); i++) {
                Edge e = graph[curr.vertex].get(i);
                // int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if (curr.cost + wt < dist[v] && curr.stops <= k) { // dist[u] updates path cost, but curr.cost is current path cost
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }
        // Dist[dst]
        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dst];
        }
    }

    public static void main(String[] args) {
        // Cheapest Flights With in K Stops --------------------------------
        // There are n cities connected by some numbers of flights. You are given an array flights where
        // flight[i] = [from,to,price] indicates that there is a flight.
        // You are also given three integers src,dst and k, return the cheapest price from src to dst with
        // at most k stops. If there is no such route, return -1.
        int n = 4;
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0, dst = 3, k = 1;
        System.out.println("Cheapest Flights Cost : " + cheapestFlights(n, flights, src, dst, k));

    }
}