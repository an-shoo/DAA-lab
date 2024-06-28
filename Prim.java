import java.util.*;
class Pair{
    int node;
    int distance;
    public Pair(int node,int distance){
        this.node=node;
        this.distance=distance;
    }
}
class Solution{
    public int prim(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        PriorityQueue<Pair> pq= new PriorityQueue<Pair> ((x,y)-> x.distance - y.distance);
        int[] vis= new int[V];
        int sum=0;
        pq.add(new Pair(0,0));
        while(pq.size()>0){
            int node = pq.peek().node;
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
public class code {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        Solution obj = new Solution();
        int sum = obj.prim(V, adj);
        System.out.println("The sum of all the edge weights: " + sum);
    }
}
