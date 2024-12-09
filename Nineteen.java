public class Nineteen {
    public static void main(String[] args) {
        RainWater rain = new RainWater();

        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // int[] height = new int[] { 4, 2, 0, 3, 2, 5 };

        rain.trap(height);
        // rain.trap2(height);
        rain.revise(height);
    }
}

class RainWater {

    // T O(N)
    // S O(1)

    public int trap2(int[] height) {
        int length = height.length;

        if (length == 0) {
            return 0;
        }

        int l = 0, r = length - 1;

        int maxLeft = height[l];
        int maxRight = height[r];
        int sum = 0;

        while (l < r) {

            if (maxLeft < maxRight) {
                l++;
                sum += Math.max(0, maxLeft - height[l]);
                maxLeft = Math.max(maxLeft, height[l]);
            } else {
                r--;
                sum += Math.max(0, maxRight - height[r]);
                maxRight = Math.max(maxRight, height[r]);
            }

        }

        System.out.println(sum);

        return sum;
    }

    // T O(N)
    // S O(N)
    public int trap(int[] height) {

        int length = height.length;
        if (length == 0) {
            return 0;
        }

        int sum = 0;

        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];
        int[] minHeight = new int[length];

        int i = 1, j = length - 2;

        maxLeft[0] = 0;
        maxRight[length - 1] = 0;
        while (i < length && j >= 0) {

            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
            maxRight[j] = Math.max(maxRight[j + 1], height[j + 1]);
            i++;
            j--;
        }

        for (i = 0; i < length; i++) {
            minHeight[i] = Math.min(maxLeft[i], maxRight[i]);
            sum += (Math.max(0, minHeight[i] - height[i]));
        }

        System.out.println(sum);

        return sum;
    }

    // T O(N)
    // S O(N)
    public int revise(int[] height) {

        int length = height.length;

        if (length == 0 || length == 1) {
            return 0;
        }

        int l = 0, r = length - 1;
        int maxLeft = height[0], maxRight = height[r];
        int sum = 0;

        while (l < r) {

            if (maxLeft < maxRight) {
                l++;
                sum += Math.max(0, maxLeft - height[l]);
                maxLeft = Math.max(maxLeft, height[l]);
            } else {
                r--;
                sum += Math.max(0, maxRight - height[r]);
                maxRight = Math.max(maxRight, height[r]);
            }

        }

        System.out.println(sum);
        return sum;
    }
}
