// 189. Rotate Array
// Solved
// Medium
// Topics
// Companies
// Hint
// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

// Example 1:

// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
// Example 2:

// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]

public class Twelve {
    public static void main(String[] args) {
        RotateArray rotate = new RotateArray();

        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

        // rotate.usingExtraSpaceArray(nums, 3);
        // rotate.reverse(new int[] { 1, 2, 3 }, 4);
        rotate.summ(nums, 3);
    }
}
/*
 * 1 2 3 4 5
 * 3 2 1 5 4
 * 4 5 1 2 3
 * ---------
 * 5 4 3 2 1
 * 4 5 1 2 3
 */

class RotateArray {

    public void reverse(int[] nums, int k) {

        int length = nums.length;

        if (k > length) {
            k = k % length;
        }

        int rotate = Math.abs(length - k);

        // reverse till 3
        int left = 0, right = rotate - 1;
        while (left < right) {

            swap(nums, left, right);

            left++;
            right--;
        }

        // reverse the remaining
        left = rotate;
        right = length - 1;
        while (left < right) {

            swap(nums, left, right);

            left++;
            right--;
        }

        // reverse the whole array
        left = 0;
        right = length - 1;
        while (left < right) {

            swap(nums, left, right);

            left++;
            right--;
        }

        for (int ele : nums) {
            System.out.print(ele + " ");
        }

    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int[] usingExtraSpaceArray(int[] nums, int k) {
        int length = nums.length;

        int[] rotatedArray = new int[length];

        int rotate = Math.abs(length - k);

        int i = 0, j = rotate;
        while (i < length) {
            if (j < length) {
                rotatedArray[i] = nums[j];
            } else {
                rotatedArray[i] = nums[j - length];
            }
            i++;
            j++;
        }

        nums = rotatedArray;

        for (int ele : nums) {
            System.out.print(ele + " ");
        }

        return rotatedArray;
    }

    public int[] summ(int[] nums, int k) {
        int length = nums.length;

        k = k % length;
        // 1,2,3,4,5,6,7
        rev(nums, 0, length - 1);
        rev(nums, 0, k - 1);
        rev(nums, k, length - 1);

        for (int elem : nums) {
            System.out.print(elem + " ");
        }
        return nums;
    }

    private void rev(int[] arr, int i, int j) {
        while (i < j) {
            swap2(arr, i++, j--);
        }
    }

    private void swap2(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reviseUsingExtraSpaceArray(int[] nums, int k) {
        int length = nums.length;
        int rotate = Math.abs(length - k);
        int[] rotatedArray = new int[length];

        int i = 0, j = 0, l = rotate;

        while (i < length) {

            if (l < length) {
                rotatedArray[i] = nums[l];
            } else {
                rotatedArray[i] = nums[j];
                j++;
            }

            i++;
            l++;
        }

        for (i = 0; i < nums.length; i++) {
            nums[i] = rotatedArray[i];
        }
    }

    public void reviseUsingReverse(int[] nums, int k) {
        // 1,2,3,4,5,6,7
        // k = 2
        int length = nums.length;
        if (k > length) {
            k = k % length;
        }

        int mid = Math.abs(length - k);

        // reverse left
        reviseReverse(nums, 0, mid - 1);
        // reverse right
        reviseReverse(nums, mid, length - 1);
        // reverse whole
        reviseReverse(nums, 0, length - 1);

        // // reverse whole
        // reviseReverse(nums, 0, length - 1);
        // // reverse left
        // reviseReverse(nums, 0, k - 1);
        // // reverse right
        // reviseReverse(nums, k, length - 1);
    }

    public void reviseReverse(int[] nums, int l, int r) {
        if (l < r) {
            reviseSwap(nums, l++, r--);
        }
    }

    private void reviseSwap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}