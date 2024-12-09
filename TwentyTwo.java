// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order

import java.util.HashMap;

public class TwentyTwo {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();

        int[] nums = new int[] { 2, 7, 11, 15 };
        int[] nums2 = new int[] { 3, 2, 4 };

        ts.bruteForce(nums, 9);
        ts.bruteForce(nums2, 6);

        ts.TwoPassHashTable(nums, 9);
        ts.TwoPassHashTable(nums2, 6);

        ts.OnePassHashTable(nums, 9);
        ts.OnePassHashTable(nums2, 6);

    }
}

class TwoSum {

    // O(N) - time
    // O(N) - space
    public int[] OnePassHashTable(int[] nums, int target) {

        HashMap<Integer, Integer> table = new HashMap<>();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int complement = target - nums[i];
            if (table.containsKey(complement)) {
                System.out.println(i + " " + table.get(complement));
                return new int[] { i, table.get(complement) };
            }
            table.put(nums[i], i);
        }
        return null;
    }

    // O(N) - time
    // O(N) - space
    public int[] TwoPassHashTable(int[] nums, int target) {

        HashMap<Integer, Integer> table = new HashMap<>();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            table.put(nums[i], i);
        }

        // { 2, 7, 11, 15 };
        // T = 9, 18
        for (int i = 0; i < length; i++) {

            int complement = target - nums[i];
            if (table.containsKey(complement) && table.get(complement) != i) {
                System.out.println(i + " " + table.get(complement));
                return new int[] { i, table.get(complement) };
            }

        }

        return null;
    }

    // O(N2) - time
    // O(1) - space
    public int[] bruteForce(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(i + " " + j);
                    return new int[] { i, j };
                }
            }
        }

        return null;
    }

}