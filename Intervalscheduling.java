public class JobScheduling {

    // Constants
    private static final int N = 6;

    // Jobs represented as {start-time, finish-time, value}
    private static int[][] jobs = {
        {0, 0, 0},   // Dummy job
        {1, 2, 100},
        {2, 5, 200},
        {3, 6, 300},
        {4, 8, 400},
        {5, 9, 500},
        {6, 10, 100}
    };

    private static int[] M = new int[N + 1];

    // Function to get the maximum of two integers
    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Function to find the largest index i < j such that job i finishes before job j starts
    private static int p(int j) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (jobs[j][0] >= jobs[i][1]) {
                count++;
            }
        }
        return count;
    }

    // Iteratively computes the optimal value with memoization
    private static int iterativeComputeOpt(int j) {
        M[0] = 0;
        for (int k = 1; k <= N; k++) {
            M[k] = max(jobs[k][2] + M[p(k)], M[k - 1]);
        }
        return M[N];
    }

    // Recursively finds the optimal set of jobs
    private static void findSolution(int j) {
        if (j > 0) {
            if (jobs[j][2] + M[p(j)] >= M[j - 1]) {
                System.out.print(j + "  ");
                findSolution(p(j));
            } else {
                findSolution(j - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Optimal solution : " + iterativeComputeOpt(N));
        System.out.print("Optimal Set : ");
        findSolution(N);
        System.out.println();
    }
}

