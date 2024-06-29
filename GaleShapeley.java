import java.util.*;

public class GaleShapley {
    static int N = 3;

    boolean wPrefersM1OverM(int prefer[][], int w, int m, int m1) {
        for (int i = 0; i < N; i++) {
            if (prefer[w][i] == m1)
                return true;
            if (prefer[w][i] == m)
                return false;
        }
        return false;
    }

    void stableMarriage(int prefer[][]) {
        int wPartner[] = new int[N];
        boolean mFree[] = new boolean[N];

        Arrays.fill(wPartner, -1);
        int freeCount = N;

        while (freeCount > 0) {
            int m;
            for (m = 0; m < N; m++)
                if (!mFree[m])
                    break;

            for (int i = 0; i < N && !mFree[m]; i++) {
                int w = prefer[m][i];

                if (wPartner[w - N] == -1) {
                    wPartner[w - N] = m;
                    mFree[m] = true;
                    freeCount--;
                } else {
                    int m1 = wPartner[w - N];
                    if (!wPrefersM1OverM(prefer, w, m, m1)) {
                        wPartner[w - N] = m;
                        mFree[m] = true;
                        mFree[m1] = false;
                    }
                }
            }
        }

        System.out.println("Woman   Man");
        for (int i = 0; i < N; i++)
            System.out.println(" " + (i + N) + "\t" + wPartner[i]);
    }

    public static void main(String[] args) {
        int prefer[][] = {
            {7, 5, 6},
            {5, 6, 7},
            {6, 7, 5},
            {0, 1, 2},
            {1, 2, 0},
            {2, 0, 1}
        };
        GaleShapley gs = new GaleShapley();
        gs.stableMarriage(prefer);
    }
}
