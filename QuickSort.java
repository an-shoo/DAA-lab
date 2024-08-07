import java.util.*;

class Solution {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i <= high && arr[i] <= pivot) {
                i++;
            }
            while (j >= low + 1 && arr[j] >= pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    public static void QuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pindex = partition(arr, low, high);
            QuickSort(arr, low, pindex - 1);
            QuickSort(arr, pindex + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 1, 3, 2, 7};
        System.out.println("Original array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        QuickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
