import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        int V = 5, E = 6, S = 0;

        // Creating adjacency list for the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 10)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(4, 100)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 50)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 20)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 10)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 60)));
        
        Solution s1 = new Solution();
        int[] res = s1.dijkstra(V, adj, S);
        
        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
    }
    class Pair{
        int node;
        int dist;
        public Pair(int dist,int node){
            this.node=node;
            this.dist=dist;
        }
    }
    public int[] dijkstra(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj,int S){
        int[] dis=new int[V];
        Arrays.fill(dis,999);
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.dist-y.dist);
        dis[S]=0;
        pq.add(new Pair(0,S));
        while(!pq.isEmpty()){
            Pair current=pq.poll();
            int node=current.node;
            int distance=current.dist;
            for(int i=0;i < adj.get(node).size();i++){
                int adjnode=adj.get(node).get(i).get(0);
                int edgeWeight=adj.get(node).get(i).get(1);
                if(distance+edgeWeight<dis[adjnode]){
                    dis[adjnode]=distance+edgeWeight;
                    pq.add(new Pair(dis[adjnode],adjnode));
                }
            }
        }
        return dis;
        
    }
}
