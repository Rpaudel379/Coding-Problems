import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Fifty {
    public static void main(String[] args) {
        SlidingWindowMaximum sol = new SlidingWindowMaximum();

        {
            sol.maxSlidingWindow(new int[] { 1, 1, 1, 1, 1, 4, 5 }, 6);
            sol.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
        }
    }
}

class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] out = new int[nums.length - k + 1];

        Deque<Integer> q = new LinkedList<>();
        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            // remove the smaller values from q
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            // add the current index
            q.offer(i);

            // check for the left boundary
            if (q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }

            // add to the array if right boundary is greater than or equal to k
            if (i + 1 >= k) {
                out[j++] = nums[q.peekFirst()];
            }

        }

        return out;
    }

    public int[] bruteForce(int[] nums, int k) {
        ArrayList<Integer> out = new ArrayList<>();

        int l = 0;

        for (int r = k - 1; r < nums.length; r++) {
            int max = nums[l];
            System.out.print(r + " ");
            for (int i = l; i <= r; i++) {
                // System.out.print(nums[i] + " ");
                max = Math.max(max, nums[i]);
            }
            l++;
            out.add(max);
        }

        System.out.println("\n" + out);
        return new int[] { 1, 2 };
    }
}