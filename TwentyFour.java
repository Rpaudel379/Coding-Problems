// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwentyFour {

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();

        int[] nums = new int[] { 1, 2, 3, 2 };

        cd.sorting(nums);
        cd.bf(nums);
        cd.usingHashSet(nums);
        cd.usingHashMap(nums);
    }
}

class ContainsDuplicate {

    public boolean usingHashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                System.out.println("true");
                return true;
            }
            map.put(nums[i], i);
        }

        System.out.println("false");
        return false;
    }

    public boolean usingHashSet(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                System.out.println("true");
                return true;
            }
            // set.add(nums[i]);
        }

        System.out.println("false");
        return false;
    }

    // O(N log N) - time
    // O(1) - space
    public boolean sorting(int[] arr) {

        int[] nums = arr.clone();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                System.out.println(i + " " + (i + 1));
                return true;
            }
        }

        return false;
    }

    public boolean bf(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    System.out.println(i + " " + j);
                    return true;
                }
            }
        }
        return false;
    }
}

// Map<Integer, Integer> map = new HashMap<>();

// for ( int i = 0; i < nums.length; i++){

// if(map.containsKey(nums[i])){
// return true;
// }
// map.put(nums[i], i);

// }

// return false;