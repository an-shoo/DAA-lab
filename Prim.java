import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        int V = 5, E = 7, S = 0;

        // Creating adjacency list for the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 4)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(3, 8)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 1)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 7)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 8)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 3)));
        
        Solution s1 = new Solution();
        int res = s1.prim(V, adj, S);
        System.out.println("The Minimum cost achieved is: "+res);
        
    }
    class Pair{
        int node;
        int distance;
        public Pair(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    public int prim(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj,int S){
        int[] vis=new int[V];
        int sum=0;
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.distance-y.distance);
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            int node=pq.peek().node;
            int wt=pq.peek().distance;
            pq.remove();
            if(vis[node]==1) continue;
            vis[node]=1;
            sum+=wt;
            for(int i=0;i<adj.get(node).size();i++){
                int edgewt=adj.get(node).get(i).get(1);
                int adjnode=adj.get(node).get(i).get(0);
                if(vis[adjnode]==0){
                    pq.add(new Pair(adjnode,edgewt));
                }
            }
        }
        return sum;
    }
}
