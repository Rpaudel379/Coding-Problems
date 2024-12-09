// Time complexity: O(n) where n is size of given array
// Auxiliary Space: O(1) because it is using constant space for variables

public class Seven {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 6 };
        // int[] arr = { 1, 3, 2, 4, 5 };

        // multiply(arr);
        revise(arr);
    }

    private static void multiply(int[] arr) {

        int prev = arr[0];
        arr[0] = arr[0] * arr[1];

        for (int i = 1; i < arr.length - 1; i++) {
            int curr = arr[i];
            arr[i] = prev * arr[i + 1];
            prev = curr;
        }

        arr[arr.length - 1] = prev * arr[arr.length - 1];

        for (int product : arr) {
            System.out.print(product + " ");
        }

        System.out.println();
    }

    private static void revise(int[] arr) {

        // 2 3 4 5 6
        // int[] arr = { 1, 3, 2, 4, 5 };

        int n = arr.length;
        int prev = arr[0];
        arr[0] = prev * arr[1];

        for (int i = 1; i < n - 1; i++) {
            int curr = arr[i];
            arr[i] = prev * arr[i + 1];
            prev = curr;
        }

        arr[n - 1] = prev * arr[n - 1];

        for (int product : arr) {
            System.out.print(product + " ");
        }

        System.out.println();
    }
}
