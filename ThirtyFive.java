import java.util.HashMap;
import java.util.Stack;

public class ThirtyFive {
    public static void main(String[] args) {

        NextGreaterElement solution = new NextGreaterElement();

        int[] nums1 = new int[] { 4, 1, 2 }, nums2 = new int[] { 1, 3, 4, 2 };
        // int[] nums1 = new int[] { 2, 4 }, nums2 = new int[] { 1, 2, 3, 4 };

        solution.nextGreaterElement2(nums1, nums2);
        solution.revise(nums1, nums2);
    }
}

class NextGreaterElement {
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            int curr = nums2[i];

            while (!stack.empty() && curr > stack.peek()) {
                stack.pop();
            }

            int ans = stack.empty() ? -1 : stack.peek();
            map.put(curr, ans);
            stack.push(curr);
        }

        int[] out = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            out[i] = map.get(nums1[i]);
        }

        for (int i : out) {
            System.out.print(i + " ");
        }
        System.out.println();
        return out;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] out = new int[length1];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length2; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < length1; i++) {

            if (map.containsKey(nums1[i])) {
                int j = map.get(nums1[i]); // get index of nums2 array
                out[i] = -1;
                while (j < length2) {
                    if (nums1[i] < nums2[j]) {
                        out[i] = nums2[j];
                        break;
                    }
                    j++;
                }
            }

        }

        for (int i : out) {
            System.out.print(i + " ");
        }
        System.out.println();
        return out;
    }

    // 1 5 4 2 3 1
    public int[] revise(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {

            int curr = nums2[i];

            while (!stack.empty() && curr > stack.peek()) {
                stack.pop();
            }

            int rightElem = stack.empty() ? -1 : stack.peek();
            map.put(curr, rightElem);
            stack.push(curr);
        }

        int[] out = new int[nums1.length];

        for (int i = 0; i < out.length; i++) {
            out[i] = map.get(nums1[i]);
        }

        for (int i : out) {
            System.out.print(i + " ");
        }
        System.out.println();
        return out;
    }

}