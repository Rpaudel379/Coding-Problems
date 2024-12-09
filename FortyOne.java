public class FortyOne {
    public static void main(String[] args) {

        MinimumInRotatedSortedArray min = new MinimumInRotatedSortedArray();

        {
            int[] nums = new int[] { 3, 4, 5, 1, 2 };
            min.findMin(nums);
        }

        {
            int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
            min.findMin(nums);
        }
        {
            int[] nums = new int[] { 11, 13, 15, 17 };
            min.findMin(nums);
        }
        {
            int[] nums = new int[] { 2, 1 };
            min.findMin(nums);
        }

    }

}

class MinimumInRotatedSortedArray {
    public int findMin2(int[] nums) {
        int length = nums.length;
        int l = 0, r = length - 1;
        int min = nums[0];
        while (l <= r) {
            if (nums[l] < nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }

            int m = (l + r) / 2;
            int mid = nums[m];
            if (mid >= nums[l]) {
                l = m + 1;
            } else {
                min = Math.min(min, mid);
                r = m - 1;
            }
        }
        return min;
    }

    public int findMin(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int firstElement = nums[0];
        int min = firstElement;

        int l = 0, r = length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            int mid = nums[m];
            if (firstElement <= mid) {
                l = m + 1;
            } else {
                min = Math.min(min, mid);
                r = m - 1;
            }

        }

        System.out.println(min);
        return min;
    }
}
