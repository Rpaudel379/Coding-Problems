import java.util.Stack;

public class ThirtyFour {
    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();

        // int[] temperatures = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
        // int[] temperatures = new int[] { 30, 40, 50, 60 };
        // int[] temperatures = new int[] { 30, 60, 90 };
        int[] temperatures = new int[] { 55, 38, 53, 81, 61, 93, 97, 32, 43, 78 };

        dt.dailyTemperatures(temperatures);
        dt.dailyTemperaturesBF(temperatures);
        dt.dailyTemperaturesStack(temperatures);
        dt.revise(temperatures);
    }
}

class DailyTemperatures {

    public int[] dailyTemperaturesStack(int[] temperatures) {
        int length = temperatures.length;
        int[] out = new int[length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {

            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                out[stack.peek()] = i - stack.peek();
                stack.pop();
            }

            stack.push(i);

        }
        for (int i : out) {
            System.out.print(i + " ");
        }
        System.out.println();
        return out;
    }

    public int[] dailyTemperaturesBF(int[] temperatures) {
        int length = temperatures.length;

        int[] out = new int[length];

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length && out[i] == 0; j++) {
                if (temperatures[i] < temperatures[j]) {
                    out[i] = j - i;
                    // break;
                }
            }
        }

        for (int i : out) {
            System.out.print(i + " ");
        }

        System.out.println();
        return out;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;

        int[] out = new int[length];

        int l = 0, r = 1;

        for (; l < length;) {

            if (r >= length) {
                ++l;
                r = l + 1;
                continue;
            }

            if (temperatures[l] < temperatures[r]) {
                out[l] = r - l;
                ++l;
                r = l + 1;
            } else {
                r++;
            }

        }

        for (int i : out) {
            System.out.print(i + " ");
        }
        System.out.println();
        return out;
    }

    public int[] revise(int[] temperatures) {
        int length = temperatures.length;
        int[] out = new int[length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            int curTemp = temperatures[i];

            while (!stack.empty() && temperatures[stack.peek()] < curTemp) {
                out[stack.peek()] = i - stack.pop();
            }

            stack.push(i);
        }

        for (int i : out) {
            System.out.print(i + " ");
        }
        System.out.println();
        return out;
    }

}