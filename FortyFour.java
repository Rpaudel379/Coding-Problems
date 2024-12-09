public class FortyFour {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();

        {

            // median.bruteForce(new int[] { 1, 3, 5, 7, 9, 11, 13 }, new int[] { 2, 4, 6,
            // 8, 10, 12, });

            // median.bruteForce(new int[] { 6, 7, 8, 9 }, new int[] {14, 15});

        }

        {
            System.out.println(median.findMedianSortedArrays(new int[] { 6, 7, 8, 9 }, new int[] { 14, 15 }));
            System.out.println(median.findMedianSortedArrays(new int[] { 1, 3, 5, 7, 9, 11, 13 }, new int[] { 2, 4, 6,
                    8, 10, 12, }));
        }
    }
}

class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = m + n;
        int half = total / 2;
        int left = 0, right = m;

        float res;
        while (true) {

            int i = (left + right) / 2; // mid of A
            int j = half - i; // mid of B

            int Aleft = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int Aright = (i < m) ? nums1[i] : Integer.MAX_VALUE;
            int Bleft = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int Bright = (j < n) ? nums2[j] : Integer.MAX_VALUE;

            if ((Aleft <= Bright) && (Bleft <= Aright)) {

                // if even
                if (total % 2 == 0) {
                    System.out.println("even");
                    return ((double) (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2);
                } else {
                    System.out.println("odd");
                    return (double) Math.min(Aright, Bright);
                }

            } else if (Aleft > Bright) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

    }

    public double bruteForce(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] nums = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }

        for (; i < m;) {
            nums[k++] = nums1[i++];
        }
        for (; j < n;) {
            nums[k++] = nums2[j++];
        }

        int total = m + n;

        var res = 0.0;
        if (total % 2 == 0) {
            System.out.println("even");
            res = (double) (nums[(m + n - 1) / 2] + nums[(m + n) / 2]) / 2;
        } else {
            System.out.println("odd");
            res = (double) nums[(m + n - 1) / 2];
        }

        System.out.println(res);
        return res;
    }
}