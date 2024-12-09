public class Eleven {
    public static void main(String[] args) {
        String str = "Anish dai";

        reverse(str);
        revise("anish");
    }

    private static void reverse(String str) {

        char[] charStr = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            swap(charStr, left, right);
            left++;
            right--;

        }

        // System.out.println(charStr.toString());
        for (char c : charStr) {
            System.out.print(c);
        }
        System.out.println();

    }

    public static void swap(char[] str, int left, int right) {
        char temp = str[left];
        str[left] = str[right];
        str[right] = temp;
    }

    private static void revise(String str) {
        char[] arr = str.toCharArray();

        int l = 0, r = arr.length - 1;

        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }

        for (char c : arr) {
            System.out.print(c);
        }
    }
}