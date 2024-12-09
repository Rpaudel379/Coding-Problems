public class ThirtyEight {
    public static void main(String[] args) {
        BinarySearch s = new BinarySearch();

        int[] nums = { -1, 0, 3, 5, 9, 12 }; // l=6
        // [0 5, 0 1, 1 1]
        System.out.println(s.search(nums, 13));
        System.out.println(s.searchRecurse(nums, 12, 0, nums.length - 1));

    }
}

class BinarySearch {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int lo = 0, hi = length - 1;

        while (lo <= hi) {
            int midIdx = (lo + hi) / 2;
            // int midIdx = low + (high - low) / 2;

            int mid = nums[midIdx];

            if (mid == target) {
                return midIdx;
            } else if (mid < target) {
                lo = midIdx + 1;
            } else {
                hi = midIdx - 1;
            }
        }

        return -1;
    }

    public int searchRecurse(int[] nums, int target, int low, int high) {

        if (low > high) {
            return -1;
        }

        int midIdx = (low + high) / 2;
        int mid = nums[midIdx];

        if (mid == target) {
            return midIdx;
        } else if (mid < target) {
            return searchRecurse(nums, target, midIdx + 1, high);
        } else {
            return searchRecurse(nums, target, low, midIdx - 1);
        }

    }

}