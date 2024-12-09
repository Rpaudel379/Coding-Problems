import java.util.Arrays;
import java.util.Stack;

public class ThirtySix {
    public static void main(String[] args) {
        CarFleet fleet = new CarFleet();

        {
            int target = 12;
            int[] position = new int[] { 10, 8, 0, 5, 3 };
            int[] speed = new int[] { 2, 4, 1, 1, 3 };

            fleet.carFleet(target, position, speed);
        }
        {
            int target = 12;
            int[] position = new int[] { 10, 8, 0, 5, 3 };
            int[] speed = new int[] { 2, 4, 1, 1, 3 };

            fleet.carFleet2(target, position, speed);
        }
        {
            int target = 12;
            int[] position = new int[] { 10, 8, 0, 5, 3, 9 };
            int[] speed = new int[] { 2, 4, 1, 1, 3, 3 };

            fleet.revise(target, position, speed);
        }
        {
            int target = 12;
            int[] position = new int[] { 10, 8, 0, 5, 3, 9 };
            int[] speed = new int[] { 2, 4, 1, 1, 3, 3 };

            fleet.revise2(target, position, speed);
        }

    }
}

class CarFleet {

    // T - O(N)
    // S - O(N)
    public int carFleet2(int target, int[] position, int[] speed) {
        if (position.length == 1) {
            return 1;
        }

        float[] time = new float[target];

        for (int i = 0; i < position.length; i++) {
            time[position[i]] = (float) (target - position[i]) / speed[i];
        }

        int fleet = 0;
        float maxTime = 0;

        for (int i = target - 1; i >= 0; i--) {

            float curTime = time[i];
            if (curTime > maxTime) {
                maxTime = curTime;
                fleet++;
            }
        }

        System.out.println(fleet);
        return fleet;
    }

    // T - O(NlogN) because of sorting
    // S - O(N) for extra pair array and stack
    public int carFleet(int target, int[] position, int[] speed) {

        if (position.length == 1) {
            return 1;
        }

        int length = position.length;
        int[][] pair = new int[length][2];
        for (int i = 0; i < length; i++) {
            // pair[i][0] = position[i];
            // pair[i][1] = speed[i];
            pair[i] = new int[] { position[i], speed[i] };
        }

        Arrays.sort(pair, java.util.Comparator.comparingInt(o -> o[0]));

        // for (int i = 0; i < length; i++) {
        // for (int j = 0; j < 2; j++) {
        // System.out.print(pair[i][j] + " ");
        // }
        // System.out.println();
        // }

        Stack<Double> stack = new Stack<>();

        for (int i = length - 1; i >= 0; i--) {
            double time = (double) (target - pair[i][0]) / pair[i][1];

            if (!stack.empty() && time <= stack.peek()) {
                continue;
            } else {
                stack.push(time);
            }

        }

        System.out.println(stack.size());
        return stack.size();
    }

    public int revise(int target, int[] position, int[] speed) {
        int length = position.length;
        if (length == 1) {
            return 1;
        }

        int[][] pair = new int[length][2];
        for (int i = 0; i < length; i++) {
            pair[i] = new int[] { position[i], speed[i] };
        }

        Arrays.sort(pair, java.util.Comparator.comparingInt(o -> o[0]));

        float maxTime = 0;
        int fleet = 0;
        for (int i = length - 1; i >= 0; i--) {

            float time = (float) (target - pair[i][0]) / pair[i][1];

            if (time > maxTime) {
                maxTime = time;
                fleet++;
            }
        }

        System.out.println(fleet);
        return fleet;
    }

    public int revise2(int target, int[] position, int[] speed) {
        int length = position.length;

        float[] time = new float[target];

        for (int i = 0; i < length; i++) {
            time[position[i]] = (float) (target - position[i]) / speed[i];
        }

        float maxTime = 0;
        int fleet = 0;
        for (int i = target - 1; i >= 0; i--) {

            if (time[i] > maxTime) {
                maxTime = time[i];
                fleet++;
            }

        }

        System.out.println(fleet);
        return fleet;

    }
}