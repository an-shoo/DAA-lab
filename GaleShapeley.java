import java.util.*;
public class GaleShapeley{
    static int N=3;
    int indexof(String[] array,String w){
        for(int i=0;i<array.length;i++){
            if(array[i].equals(w)){
                return i;
            }
        }
        return -1;
    }
    boolean wprefersmoverm1(String[][] prefer,String w, String m, String m1){
        int windex=indexof(women,w);
        for(int i=0;i<N;i++){
            if(prefer[N+windex][i].equals(m)){
                return true;
            }
            if(prefer[N+windex][i].equals(m1)){
            return false;
        }}
        return false;
    }
    void stablemarriage(String[][] prefer, String[] men, String[] women){
        String[] wPartner= new String[N];
        Arrays.fill(wPartner,null);
        boolean[] mFree= new boolean[N];
        Arrays.fill(mFree,true);
        int freecount=N;
        while(freecount>0){
            int m;
            for(m=0;m<N;m++){
                if(mFree[m])
                break;
            }
            for(int i=0;i<N && mFree[m];i++){
                String w=prefer[m][i];
                int windex=indexof(women,w);
                if(wPartner[windex]==null){
                    wPartner[windex]=men[m];
                    mFree[m]=false;
                    freecount--;
                }
                else{
                    String m1=wPartner[windex];
                    if(wprefersmoverm1(prefer,w,men[m],m1)){
                        wPartner[windex]=men[m];
                        mFree[m]=false;
                        mFree[indexof(men,m1)]=true;
                    }
                }
            }
        }
        System.out.println("Woman\tMan");
        for(int i=0;i<N;i++){
            System.out.println(women[i]+"\t"+wPartner[i]);
        }
    }
    static String[] men={"A","B","C"};
    static String[] women={"V","W","X"};
    public static void main(String[] args){
        String[][] prefer = {
            {"V", "W", "X"}, // A's preferences
            {"W", "X", "V"}, // B's preferences
            {"X", "V", "W"}, // C's preferences
            {"A", "B", "C"}, // V's preferences
            {"B", "C", "A"}, // W's preferences
            {"C", "A", "B"}  // X's preferences
        };
        GaleShapeley gs=new GaleShapeley();
        gs.stablemarriage(prefer,men,women);
    }
}
