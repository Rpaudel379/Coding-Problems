// 11. Container With Most Water
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

public class Thirteen {
    public static void main(String[] args) {
        MostWater mostWater = new MostWater();
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        // int[] height = { 4, 3, 2, 1, 4 };
        // int[] height = { 1, 2, 1 };
        mostWater.bruteForce(height);
        mostWater.twoPointer(height);
        mostWater.reviseBF(height);
    }
}

class MostWater {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int twoPointer(int[] height) {

        int maxArea = 0;

        for (int i = 0, j = height.length - 1; i < j;) {

            int min = min(height[i], height[j]);
            int dist = j - i;
            int area = min * dist;
            maxArea = max(maxArea, area);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        System.out.println(maxArea);

        return maxArea;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public int bruteForce(int[] height) {

        int length = height.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                if (i == j) {
                    continue;
                }

                int min = Math.min(height[i], height[j]);
                int dist = Math.abs(i - j);
                int area = min * dist;
                if (area > maxArea) {
                    maxArea = area;
                }

            }
        }

        System.out.println(maxArea);

        return maxArea;
    }

    public int reviseBF(int[] height) {
        int length = height.length;
        int max = 0;

        for (int l = 0; l < length; l++) {
            for (int r = 0; r < length; r++) {
                if (l == r) {
                    continue;
                }

                int area = Math.abs(l - r) * Math.min(height[l], height[r]);
                max = Math.max(area, max);
            }
        }

        return max;
    }

    public int reviseTwoPointers(int[] height) {
        int length = height.length;
        int max = 0;

        int l = 0, r = length - 1;

        while (l < r) {
            int leftH = height[l];
            int rightH = height[r];

            int area = (r - l) * Math.min(leftH, rightH);
            max = Math.max(area, max);

            if (leftH < rightH) {
                l++;
            } else {
                r--;
            }

        }

        return max;
    }

}