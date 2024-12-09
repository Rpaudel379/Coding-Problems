import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Eighteen {
    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();

        // int[] nums = { -1, 0, 1, 2, -1, -4 };
        // -4, -1, -1, 0, 1, 2
        int[] nums = { -2, 0, 0, 2, 2 };
        // -2 0 0 2 2

        ts.bruteforce(nums);
        // ts.twoPointer(nums);
        // ts.revise(nums);
    }
}

class ThreeSum {

    // time complexity = O(n log n) + O(n2) => O(n2)
    // space complexity = O(1) or O(n), because sorting takes extra memory for some
    // libraries

    public List<List<Integer>> twoPointer(int[] nums) {

        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length < 3) {
            return out;
        }

        if (nums[0] > 0) {
            return out;
        }

        int length = nums.length;

        for (int i = 0; i < length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1, r = length - 1;

            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    out.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    int lastLeft = nums[l], lastRight = nums[r];
                    while (lastLeft == nums[l] && l < r) {
                        l++;
                    }

                    while (lastRight == nums[r] && l < r) {
                        r--;
                    }

                    // while (nums[l] == nums[l + 1] && l < r) {
                    // l++;
                    // }
                    // while (nums[r] == nums[r - 1] && l < r) {
                    // r--;
                    // }
                    // l++;
                    // r--;
                }
            }

        }

        System.out.println(out);
        return out;
    }

    public List<List<Integer>> bruteforce(int[] arr) {

        int[] nums = arr.clone();

        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        int length = nums.length;

        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {

                    if ((nums[i] + nums[j] + nums[k] == 0) && i != j && j != k && i != k) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }

                }
            }
        }

        set.forEach((s) -> {
            out.add(s);
        });

        System.out.println(out);
        return out;
    }

    public List<List<Integer>> revise(int[] arr) {

        List<List<Integer>> out = new ArrayList<>();

        int length = arr.length;

        int[] nums = arr.clone();
        Arrays.sort(nums);

        if (length < 3 || nums[0] > 0) {
            return out;
        }

        for (int i = 0; i < length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1, r = length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    out.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // on further search also check the duplicates
                    while (nums[l] == nums[l + 1] && l < r) {
                        l++;
                    }

                    while (nums[r] == nums[r - 1] && l < r) {
                        r--;
                    }

                    l++;
                    r--;

                    // or
                    // int lastLeft = nums[l], lastRight = nums[r];
                    // while (lastLeft == nums[l] && l < r) {
                    // l++;
                    // }
                    // while (lastRight == nums[r] && l < r) {
                    // r--;
                    // }

                }

            }

        }

        System.out.println(out);
        return out;
    }
}