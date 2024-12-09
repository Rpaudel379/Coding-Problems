import java.util.Stack;

public class ThirtySeven {
    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

        {
            int[] heights = new int[] { 2, 1, 5, 6, 2, 3 };
            solution.largestRectangleArea(heights);
        }
        {
            int[] heights = new int[] { 2, 4 };
            solution.largestRectangleArea(heights);
        }
        {
            int[] heights = new int[] { 1, 3, 2, 4, 5, 4, 2 };
            solution.largestRectangleArea(heights);
            solution.revise(heights);
        }
        {
            int[] heights = new int[] { 1, 3, 3, 1 };
            solution.largestRectangleArea(heights);
            solution.revise(heights);
        }

    }
}

class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {

        int length = heights.length;
        if (length == 1) {
            return heights[0];
        }

        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < length; i++) {

            int curHeight = heights[i];
            int start = i;

            while (!stack.empty() && stack.peek().getHeight() > curHeight) {
                int index = stack.peek().getIndex();
                int h = stack.peek().getHeight();

                maxArea = Math.max(maxArea, (i - index) * h);
                stack.pop();
                start = index;
            }

            stack.push(new Pair(start, curHeight));

        }

        while (!stack.empty()) {
            int index = stack.peek().getIndex();
            int h = stack.peek().getHeight();

            maxArea = Math.max(maxArea, (length - index) * h);
            stack.pop();
        }

        System.out.println(maxArea);
        return maxArea;
    }

    public int revise(int[] heights) {
        int length = heights.length;
        if (length == 1) {
            return heights[0];
        }

        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();
        // 1 3 3 1
        // [1 3 ]
        for (int i = 0; i < length; i++) {

            int start = i;
            int curHeight = heights[i];

            while (!stack.empty() && stack.peek().getHeight() > curHeight) {
                int idx = stack.peek().getIndex();
                int h = stack.peek().getHeight();

                int area = (i - idx) * h;
                maxArea = Math.max(maxArea, area);

                start = idx;
                stack.pop();
            }

            stack.push(new Pair(start, curHeight));
        }

        while (!stack.empty()) {

            int idx = stack.peek().getIndex();
            int h = stack.peek().getHeight();

            int area = (length - idx) * h;
            maxArea = Math.max(maxArea, area);
            stack.pop();
        }

        System.out.println(maxArea);
        return maxArea;
    }

    class Pair {
        private int index;
        private int height;

        public Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }

        public int getIndex() {
            return this.index;
        }

        public int getHeight() {
            return this.height;
        }
    }
}
