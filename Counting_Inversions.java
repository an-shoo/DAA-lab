import java.util.*;
class Solution{
    public  int mergesort(int[] arr, int low, int high){
        int invcount=0;
        if(low>=high) return invcount;
        int mid=(low+high)/2;
        invcount+=mergesort(arr,low,mid);
        invcount+=mergesort(arr,mid+1,high);
        invcount+=merge(arr,low,mid,high);
        return invcount;
    }
    public static int merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp=new ArrayList<>();
        int invcount=0;
        int left=low;
        int right=mid+1;
        while(left<=mid&&right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                invcount+=(mid-left+1);
                right++;
                
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }
        return invcount;
    }
    public static void main(String[] args){
        Solution s1=new Solution();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
        }
        int count=s1.mergesort(arr,0,n-1);
        System.out.println();
        for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("No. of inversions: "+count);
    }
}
