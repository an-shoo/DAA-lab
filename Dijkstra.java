import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        int V = 3, E = 3, S = 2;

        // Creating adjacency list for the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 1)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 6)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 1)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 3)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(0, 6)));
        
        Solution s1 = new Solution();
        int[] res = s1.dijkstra(V, adj, S);
        
        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
    }

    class Pair {
        int node;
        int distance;

        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[S] = 0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int dis = current.distance;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }
}
