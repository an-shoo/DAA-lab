import java.util.*;

public class GaleShapleyString {
    static int N = 3; // Number of men and women

    // Function to check if woman w prefers man m1 over her current engagement m
    boolean wPrefersM1OverM(String[][] prefer, String w, String m, String m1) {
        int wIndex = indexOf(women, w);
        for (int i = 0; i < N; i++) {
            if (prefer[N + wIndex][i].equals(m1))
                return true;
            if (prefer[N + wIndex][i].equals(m))
                return false;
        }
        return false;
    }

    // Helper function to find the index of a string in an array
    int indexOf(String[] array, String name) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(name)) {
                return i;
            }
        }
        return -1; // Not found
    }

    void stableMarriage(String[][] prefer, String[] men, String[] women) {
        String[] wPartner = new String[N];
        boolean[] mFree = new boolean[N];
        Arrays.fill(wPartner, null);
        int freeCount = N;

        while (freeCount > 0) {
            int m;
            for (m = 0; m < N; m++)
                if (!mFree[m])
                    break;

            for (int i = 0; i < N && !mFree[m]; i++) {
                String w = prefer[m][i];
                int wIndex = indexOf(women, w);
                int mIndex = indexOf(men, men[m]);

                if (wPartner[wIndex] == null) {
                    wPartner[wIndex] = men[m];
                    mFree[m] = true;
                    freeCount--;
                } else {
                    String m1 = wPartner[wIndex];
                    if (!wPrefersM1OverM(prefer, w, men[m], m1)) {
                        wPartner[wIndex] = men[m];
                        mFree[m] = true;
                        mFree[indexOf(men, m1)] = false;
                    }
                }
            }
        }

        System.out.println("Woman   Man");
        for (int i = 0; i < N; i++)
            System.out.println(women[i] + "  " + wPartner[i]);
    }

    static String[] men = {"A", "B", "C"};
    static String[] women = {"V", "W", "X"};

    public static void main(String[] args) {
        String[][] prefer = {
            {"V", "W", "X"}, // A's preferences
            {"W", "V", "X"}, // B's preferences
            {"V", "W", "X"}, // C's preferences
            {"A", "B", "C"}, // V's preferences
            {"B", "C", "A"}, // W's preferences
            {"C", "A", "B"}  // X's preferences
        };

        GaleShapleyString gs = new GaleShapleyString();
        gs.stableMarriage(prefer, men, women);
    }
}
