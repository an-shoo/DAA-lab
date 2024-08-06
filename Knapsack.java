import java.util.*;

public class Knapsack {

    // Function to get the maximum of two integers
    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Function to print the Knapsack solution
    private static void printKnapsack(int W, int[] wt, int[] val, int n) {
        int[][] M = new int[n + 1][W + 1];

        // Initialize the first row and column with 0
        for (int w = 0; w <= W; w++) {
            M[0][w] = 0;
        }
        for (int i = 0; i <= n; i++) {
            M[i][0] = 0;
        }

        // Build the table M[][] in bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i] > w) {
                    M[i][w] = M[i - 1][w];
                } else {
                    M[i][w] = max(M[i - 1][w], val[i] + M[i - 1][w - wt[i]]);
                }
            }
        }

        // Print the result of the knapsack
        System.out.println("Knapsack Result: " + M[n][W]);

        // Print the items included in the knapsack
        System.out.print("Knapsack Items: ");
        int i = n, k = W;
        while (i > 0 && k > 0) {
            if (M[i][k] != M[i - 1][k]) {
                System.out.print(i + " ");
                k -= wt[i];
            }
            i--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] val = {0, 10, 4, 9, 11}; // Value of items
        int[] wt = {0, 3, 5, 6, 2}; // Weight of items
        int W = 7; // Maximum weight capacity of the knapsack
        int n = val.length - 1; // Number of items

        printKnapsack(W, wt, val, n);
    }
}
