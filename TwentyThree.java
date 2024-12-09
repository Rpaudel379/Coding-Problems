public class TwentyThree {
    public static void main(String[] args) {
        TwoSum2 ts = new TwoSum2();

        int[] numbers = new int[] { 2, 7, 11, 15 };

        ts.twoPointers(numbers, 18);
    }
}

class TwoSum2 {
    public int[] twoPointers(int[] numbers, int target) {

        int length = numbers.length;
        int i = 0, j = length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                System.out.println(i + 1 + " " + (j + 1));
                return new int[] { i + 1, j + 1 };
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return null;
    }
}