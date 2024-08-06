import java.util.*;
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, int src,
    ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList < Integer > bfs = new ArrayList < > ();
        boolean vis[] = new boolean[V];
        Queue < Integer > q = new LinkedList < > ();

        q.add(src);
        vis[src] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer it: adj.get(node)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }
    
    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(4);
        adj.get(0).add(2);
        adj.get(2).add(4);
        adj.get(0).add(3);
        adj.get(3).add(4);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(2);
        
        Solution sl = new Solution(); 
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the source node");
        int src=s.nextInt();
        ArrayList < Integer > ans = sl.bfsOfGraph(5,(src-1), adj);
        int n = ans.size(); 
        for(int i = 0;i<n;i++) {
            System.out.print((ans.get(i)+1)+" "); 
        }
    }
}
