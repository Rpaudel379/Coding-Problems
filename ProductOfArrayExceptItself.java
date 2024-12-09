/**
 * ProductOfRemainingElementsInArray
 */
public class ProductOfArrayExceptItself {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4 };

        productExceptItself(arr);
        bruteForce(arr);
        constantSpace(arr);

    }

    // constant space
    private static void constantSpace(int[] arr) {
        int length = arr.length;
        int[] out = new int[length];
        out[0] = 1;

        for (int i = 1; i < length; i++) {
            out[i] = arr[i - 1] * out[i - 1];
        }

        int productFromRight = 1;

        for (int i = length - 1; i >= 0; i--) {
            out[i] = out[i] * productFromRight;
            productFromRight *= arr[i];
        }

        for (int product : out) {
            System.out.print(product + " ");
        }

    }

    // constant space
    private static void bruteForce(int[] arr) {

        int length = arr.length;
        int[] out = new int[length];

        for (int i = 0; i < length; i++) {
            int product = 1;
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                product *= arr[j];
            }
            out[i] = product;
        }

        for (int product : out) {
            System.out.print(product + " ");
        }
        System.out.println();

    }

    // O(N) space
    private static void productExceptItself(int[] arr) {
        int length = arr.length;
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];
        int[] out = new int[length];

        arr1[0] = 1;
        arr2[length - 1] = 1;

        int i = 1, j = length - 2;
        while (i < length && j >= 0) {
            arr1[i] = arr1[i - 1] * arr[i - 1];
            arr2[j] = arr2[j + 1] * arr[j + 1];

            i++;
            j--;
        }

        for (i = 0; i < length; i++) {
            out[i] = arr1[i] * arr2[i];
        }

        for (int product : out) {
            System.out.print(product + " ");
        }
        System.out.println();

    }
}