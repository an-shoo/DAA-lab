import java.util.Scanner;

public class Kruskal {

    int i, j, k, a, b, u, v, n, ne = 1;
    int min, mincost = 0;
    int[][] cost = new int[9][9];
    int[] parent = new int[9];

    int find(int i) {
        while (parent[i] != 0)
            i = parent[i];
        return i;
    }

    boolean uni(int i, int j) {
        if (i != j) {
            parent[j] = i;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kruskal's algorithm in Java");
        System.out.println("===========================");

        System.out.print("Enter the number of vertices: ");
        kruskal.n = scanner.nextInt();

        System.out.println("Enter the cost adjacency matrix:");
        for (kruskal.i = 1; kruskal.i <= kruskal.n; kruskal.i++) {
            for (kruskal.j = 1; kruskal.j <= kruskal.n; kruskal.j++) {
                System.out.print("cost of edge (" + kruskal.i + "," + kruskal.j + "): ");
                kruskal.cost[kruskal.i][kruskal.j] = scanner.nextInt();
                if (kruskal.cost[kruskal.i][kruskal.j] == 0)
                    kruskal.cost[kruskal.i][kruskal.j] = 999;
            }
        }

        System.out.println("The edges of Minimum Cost Spanning Tree are");
        while (kruskal.ne < kruskal.n) { // n-1 edges
            for (kruskal.i = 1, kruskal.min = 999; kruskal.i <= kruskal.n; kruskal.i++) {
                for (kruskal.j = 1; kruskal.j <= kruskal.n; kruskal.j++) {
                    if (kruskal.cost[kruskal.i][kruskal.j] < kruskal.min) {
                        kruskal.min = kruskal.cost[kruskal.i][kruskal.j];
                        kruskal.a = kruskal.u = kruskal.i;
                        kruskal.b = kruskal.v = kruskal.j;
                    }
                }
            }

            kruskal.u = kruskal.find(kruskal.u);
            kruskal.v = kruskal.find(kruskal.v);

            if (kruskal.uni(kruskal.u, kruskal.v)) {
                System.out.println(kruskal.ne++ + " edge (" + kruskal.a + "," + kruskal.b + ") = " + kruskal.min);
                kruskal.mincost += kruskal.min;
            }

            kruskal.cost[kruskal.a][kruskal.b] = kruskal.cost[kruskal.b][kruskal.a] = 999;
        }

        System.out.println("Minimum cost = " + kruskal.mincost);
    }
}
