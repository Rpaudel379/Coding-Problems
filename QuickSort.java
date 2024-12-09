// quick sort with pivot to right most index

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {

        // int[] arr = { 5, 10, 4, 6, 2, 7, 8 };
        int[] arr = { 8, 7, 6, 1, 0, 9, 2 };

        // Random rand = new Random();
        // int n = 5000;
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = rand.nextInt(n);
        // }

        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    private static void quickSort(int[] arr, int low, int high) {

        if (low > high) {
            return;
        }

        int pivotIndex = partition(arr, low, high);
        // System.out.println(pivotIndex);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        // experiment a little bit
        int i = low, pivotIndex = low - 1;

        while (i != high) {
            if (arr[i] < pivot) {
                // swap
                int temp = arr[++pivotIndex];
                arr[pivotIndex] = arr[i];
                arr[i] = temp;
            }
            i++;
        }

        int temp = arr[++pivotIndex];
        arr[pivotIndex] = arr[high];
        arr[high] = temp;

        return pivotIndex;
    }

}
