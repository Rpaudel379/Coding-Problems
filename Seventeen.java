import java.util.HashSet;

public class Seventeen {
    public static void main(String[] args) {
        LongestSequence solution = new LongestSequence();

        int[] nums = { 100, 4, 200, 1, 3, 2 };
        // int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        // int[] nums = { 0, 1, 1, 2 };

        solution.longestConsecutive(nums);
        solution.usingSet(nums);
        solution.revise(nums);
    }
}

class LongestSequence {

    public int usingSet(int[] nums) {

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }

        int longest = 0;

        for (int i : nums) {

            // check if its the start of a sequence
            if (!set.contains(i - 1)) {
                int length = 0;
                while (set.contains(i + length)) {
                    // what incrementing does is, increments atleast once.
                    length++;
                }
                longest = Math.max(longest, length);
            }

        }
        System.out.println("set " + longest);
        return longest;
    }

    public int longestConsecutive(int[] arr) {
        int[] nums = arr.clone();
        // sort
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }

        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();

        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int maxLen = 1;

        int i = 0, j = 1;

        int len = 1;
        while (j < length) {

            if (nums[i] == nums[j]) {
                i++;
                j++;
                continue;
            }
            if ((nums[i] + 1) == nums[j]) {
                maxLen = Math.max(maxLen, ++len);
            } else {
                len = 1;
            }
            i++;
            j++;
        }

        System.out.println("n2 " + maxLen);
        return maxLen;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int revise(int[] nums) {

        // int[] nums = { 100, 4, 200, 1, 3, 2 };
        // int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        // int[] nums = { 0, 1, 1, 2 };

        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int maxLen = 1;

        for (int i = 0; i < length; i++) {

            if (!set.contains(nums[i] - 1)) {
                int len = 1;
                while (set.contains(nums[i] + len)) {
                    len++;
                }

                maxLen = Math.max(maxLen, len);
            }

            if (maxLen > length / 2)
                break;

        }
        System.out.println(maxLen);
        return maxLen;
    }

}