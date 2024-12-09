public class A {
    public static void main(String[] args) {

        // ? Binary search
        // int[] arr = { 15, 44, 53, 62, 100, 333, 555 };
        // binarySearch(arr, 555);
        // BS(arr, 555);

        // int[] ms = { 15, 13, 14, 22, 1, 2, 44, 5, };
        // mergeSort(ms);

        // int[] ms1 = { 15, 13, 14, 22, 1, 2, 44, 5, };
        // mergeSortIndex(ms1);

        int[] arr = { 15, 13, 14, 22, 1, 2, 44, 5, };
        quickSort(arr);

    }

    private static void quickSort(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        quickSort(arr, low, high);

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int pivotIdx = low - 1;
        int i = low;

        while (i < high) {
            if (arr[i] < pivot) {
                pivotIdx++;

                int temp = arr[pivotIdx];
                arr[pivotIdx] = arr[i];
                arr[i] = temp;
            }
            i++;
        }

        pivotIdx++;
        int temp = arr[pivotIdx];
        arr[pivotIdx] = arr[high];
        arr[high] = temp;

        return pivotIdx;
    }

    private static void mergeSortIndex(int[] arr) {

        int length = arr.length;
        int left = 0;
        int right = length - 1;

        mergeSortIndex(arr, left, right);

    }

    private static void mergeSortIndex(int[] arr, int left, int right) {

        if (left == right) {
            return;
        }

        // int leftArray =
        int mid = (left + right) / 2;

        mergeSortIndex(arr, left, mid);
        int[] a1 = { left, mid };
        mergeSortIndex(arr, mid + 1, right);
        int[] a2 = { mid + 1, right };

        // System.out.println("l " + arr[left] + " " + arr[mid]);
        // System.out.println("r " + arr[mid + 1] + " " + arr[right]);
        // System.out.println("l " + a1[0] + " " + a1[1]);
        // System.out.println("r " + a2[0] + " " + a2[1]);

        sortIndex(arr, a1, a2);

    }

    private static void sortIndex(int[] arr, int[] lA, int[] rA) {

        int i = 0, l = lA[0], r = rA[0];

        while (i < arr.length && l < lA[1] && r < rA[1]) {

        }

    }

    private static void mergeSort(int[] arr) {
        int length = arr.length;

        if (length == 1) {
            return;
        }

        int leftSize = length / 2;
        int rightSize = length - leftSize;

        int[] lA = new int[leftSize];
        int[] rA = new int[rightSize];

        // for (int i = 0; i < leftSize; i++) {
        // lA[i] = arr[i];
        // }

        // for (int i = 0; i < rightSize; i++) {
        // rA[i] = arr[i + leftSize];
        // }

        int k = 0, l = 0;
        while (k < length) {

            if (k < leftSize) {
                lA[k] = arr[k];
            } else {
                rA[l] = arr[k];
                l++;
            }
            k++;
        }

        for (int i : lA) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : rA) {
            System.out.print(i + " ");
        }
        System.out.println();

        mergeSort(lA);
        mergeSort(rA);

        sort(arr, lA, rA);

    }

    private static void sort(int[] arr, int[] lA, int[] rA) {

        int i = 0, l = 0, r = 0;

        while (i < arr.length && l < lA.length && r < rA.length) {
            if (lA[l] < rA[r]) {
                arr[i] = lA[l];
                l++;
            } else {
                arr[i] = rA[r];
                r++;
            }

            i++;
        }

        while (l < lA.length) {
            arr[i] = lA[l];
            l++;
            i++;
        }
        while (r < rA.length) {
            arr[i] = rA[r];
            r++;
            i++;
        }

    }

    // recursive
    private static void BS(int[] arr, int num) {
        int lo = 0;
        int hi = arr.length - 1;
        BS(arr, lo, hi, num);
    }
    // recursive

    private static int BS(int[] arr, int lo, int hi, int num) {

        if (lo > hi) {
            System.out.println("not found");
            return -1;
        }

        int midIdx = lo + (hi - lo) / 2;
        int mid = arr[midIdx];

        if (num == mid) {
            System.out.println("found " + num + " in position " + (midIdx + 1));
            return midIdx + 1;
        } else if (num < mid) {
            return BS(arr, lo, midIdx - 1, num);
        } else {
            return BS(arr, midIdx + 1, hi, num);
        }

    }

    private static int binarySearch(int[] arr, int num) {

        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int midIdx = lo + (hi - lo) / 2;
            int mid = arr[midIdx];
            if (num == mid) {
                System.out.println("found " + num + " in position " + (midIdx + 1));
                return midIdx + 1;
            } else if (num < mid) {
                hi = midIdx - 1;
            } else {
                lo = midIdx + 1;
            }
        }

        System.out.println("not found");
        return -1;
    }
}
