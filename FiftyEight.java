import java.util.Arrays;
import java.util.HashSet;

public class FiftyEight {
    public static void main(String[] args) {
        FindTheDuplicateNumber find = new FindTheDuplicateNumber();

        int[] nums = new int[] { 1, 3, 4, 2, 3 };

        System.out.println(find.findDuplicate(nums));
        System.out.println(find.countFrequency(nums));
        System.out.println(find.usingHash(nums));
        System.out.println(find.usingMarkingVisited(nums));
        System.out.println(find.bySorting(nums));

    }
}

class FindTheDuplicateNumber {

    // O(N)
    // O(1)
    // 0 1 2 3 4
    // 1 3 4 2 2
    public int findDuplicate(int[] nums) {

        int fast = 0, slow = 0;

        // s=3 f=4

        // find the point of intersection
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // find the duplicate
        int slow2 = 0;

        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }

    // O(NlogN)
    // O(logN)
    public int bySorting(int[] nums) {

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }

        }

        return -1;
    }

    // O(N)
    // O(1)
    public int usingMarkingVisited(int[] arr) {

        int[] nums = arr.clone();

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            int idx = Math.abs(nums[i]);

            if (nums[idx] < 0) {
                return idx;
            }

            nums[idx] = -nums[idx];

        }

        return -1;
    }

    // O(N)
    // O(N)
    public int usingHash(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (!set.add(n)) {
                return n;
            }
        }

        return -1;
    }

    // O(N)
    // O(N)
    public int countFrequency(int[] nums) {

        int len = nums.length;
        int[] count = new int[len];

        for (int i = 0; i < len; i++) {
            count[nums[i]]++;

            if (count[nums[i]] > 1) {
                return nums[i];
            }

        }

        return -1;
    }

    public int bruteForce(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {

                if (nums[i] == nums[j]) {
                    return nums[i];
                }

            }
        }

        return -1;
    }

}