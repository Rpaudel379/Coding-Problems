public class FortyTwo {
    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();

        System.out.println(s.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));

        System.out.println(s.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));

        System.out.println(s.search(new int[] { 1, 2 }, 2));

        System.out.println(s.search(new int[] { 5, 1, 3 }, 2));

    }
}

class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int l = 0, r = length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            int mid = nums[m];

            if (target == mid) {
                return m;
            }

            // left sorted portion, large numbers
            if (nums[l] <= mid) {
                // no need to check the left sorted portion if:
                // 1. target is less than the smallest element i.e. nums[l] in this portion. or
                // 2. target is greater than the largest element i.e. nums[m] in this portion
                if (target < nums[l] || target > mid) {
                    l = m + 1;
                } else {
                    // if target lies between nums[l] and nums[m]
                    r = m - 1;
                }
            }
            // sorted right portion, small numbers
            else {
                // no need to check the right sorted portion if:
                // 1. target is less than the smallest element i.e. nums[m] in this portion. or
                // 2. target is greater than the largest element i.e. nums[r] in this portion
                if (target < nums[m] || target > nums[r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

        }

        return -1;
    }
}