import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// 268. Missing Number
// Easy
// Given an array nums containing n distinct numbers in the range [0, n], return the only 
// number in the range that is missing from the array.

public class Ten {
    public static void main(String[] args) {
        int[] nums = { 2, 0, 1 };
        // int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        // int[] nums = { 0, 1 };

        // T O(n) and S O(1)
        // gaussianSummationFormula(nums);
        // usingHashset(nums);
        // bySorting(nums);
        usingBoolean(nums);
    }

    private static int usingBoolean(int[] nums) {
        boolean[] seen = new boolean[nums.length + 1];
        int n = nums.length;

        for (int num : nums) {
            seen[num] = true;
        }

        for (int i = 0; i <= n; i++) {
            if (!seen[i]) {
                System.out.println(i);
                return i;
            }
        }

        for (boolean num : seen) {
            System.out.print(num + " ");
        }

        return 0;
    }

    private static int gaussianSummationFormula(int[] nums) {

        int n = nums.length;
        int totalSum = n * (n + 1) / 2;

        int actualSum = 0; // because of missing number
        for (int i = 0; i < n; i++) {
            actualSum += nums[i];
        }
        System.out.println(totalSum - actualSum);
        return totalSum - actualSum;
    }

    private static int usingHashset(int[] nums) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

    private static int bySorting(int[] arr) {
        int[] nums = arr.clone();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                System.out.println(i);
                return i;
            }
        }

        // if the last number is missing then, its already sorted pick the last number
        // from array and return with +1;
        int end = nums[nums.length - 1] + 1;
        System.out.println("\n" + end);
        return end;
    }

    private static int reviseSort(int[] arr) {
        int[] nums = arr.clone();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }

        return nums[nums.length - 1] + 1;
    }

    private static int reviseSet(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    private static int reviseGussianSum(int[] nums) {
        int n = nums.length;
        int totalSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return totalSum - actualSum;
    }

}
