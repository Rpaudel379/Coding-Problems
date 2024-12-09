
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = { 5, 6, 4, 7, 8, 9, 3, 10, 2, 1 };
        // int[] arr = { 8, 10, 9, 7, };
        mergeSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] arr) {

        int length = arr.length;

        if (length == 1) {
            return;
        }

        int mid = length / 2;

        int[] leftArr = new int[mid];
        int[] rightArr = new int[length - mid];

        int i = 0, j = 0;
        // populate left and right sub array
        while (i < length) {
            if (i < mid) {
                leftArr[i] = arr[i];
            } else {
                rightArr[j] = arr[i];
                j++;
            }
            i++;
        }

        mergeSort(leftArr); // [8 10] = [8]
        mergeSort(rightArr); // [9 7] =

        // for (int k : leftArr) {
        // System.out.print(k + " ");
        // }
        // System.out.println();
        // for (int k : rightArr) {
        // System.out.print(k + " ");
        // }
        // System.out.println();

        sort(leftArr, rightArr, arr);

    }

    private static void sort(int[] leftArr, int[] rightArr, int[] arr) {

        int idx = 0, lIdx = 0, rIdx = 0;

        while (lIdx < leftArr.length && rIdx < rightArr.length) {
            if (leftArr[lIdx] < rightArr[rIdx]) {
                arr[idx] = leftArr[lIdx];
                lIdx++;
            } else {
                arr[idx] = rightArr[rIdx];
                rIdx++;
            }
            idx++;
        }
        while (lIdx < leftArr.length) {
            arr[idx] = leftArr[lIdx];
            idx++;
            lIdx++;
        }
        while (rIdx < rightArr.length) {
            arr[idx] = rightArr[rIdx];
            idx++;
            rIdx++;
        }
    }
}
