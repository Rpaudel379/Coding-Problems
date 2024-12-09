public class Nine {
    public static void main(String[] args) {

        // int[] arr = { 0 };
        // int[] arr = { 1, 1, 2 };
        // int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int[] arr = { 0, 1, 2, 2, 3, 4 };
        // bruteForce(arr);
        // twoPointer(arr);
        // differentTwoPointer(arr);
        revise(arr);
    }

    private static int differentTwoPointer(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {

            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }

        }

        for (int elem : nums) {
            System.out.print(elem + " ");
        }

        System.out.println();
        return ++i;
    }

    private static void bruteForce(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int j = i + 1;

            if (j < length && nums[i] == nums[j]) {
                int k = j + 1;
                while (k < length) {
                    nums[j] = nums[k];
                    k++;
                    j++;
                }
            }
        }

        for (int i : nums) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    private static int twoPointer(int[] nums) {

        int length = nums.length;
        int[] sorted = new int[length];

        int i = 0, j = 1;
        sorted[i] = nums[0];
        while (j < length) {

            int first = sorted[i];
            int second = nums[j];

            if (first != second) {
                i++;
                sorted[i] = nums[j];
            }

            j++;
        }

        System.out.println();
        for (int k : sorted) {
            System.out.print(k + " ");
        }
        System.out.println("\n" + ++i);

        return i;
        // int length = nums.length;

        // if (length == 1) {
        // return length;
        // }

        // int[] proper = new int[length];

        // int size = 0; // size of unique numbers
        // int uP = 0; // unique pointer
        // int dP = 1; // duplicate pointer

        // while (uP < length) {

        // int unique = nums[uP];
        // while (dP < length && nums[dP] == unique) {
        // dP++;
        // }
        // uP = dP;
        // dP++;
        // proper[size] = unique;
        // size++;
        // }

        // // proper[size] = nums[uP];
        // // size++;

        // System.out.println(size);
        // for (int i = 0; i < size; i++) {
        // nums[i] = proper[i];
        // }
        // for (int i : nums) {
        // System.out.print(i + " ");
        // }
        // System.out.println();
        // return size;
    }

    public static int revise(int[] nums) {
        // int[] arr = {0, 1, 2, 2, 3, 4};

        int l = 0;

        for (int r = 1; r < nums.length; r++) {

            if (nums[l] != nums[r]) {
                nums[++l] = nums[r];
            }

        }

        return ++l;
    }

}
