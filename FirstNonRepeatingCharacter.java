import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    static public void usingHash(String s) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        System.out.println(count);

        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                System.out.println(s.charAt(i) + " " + i);
                return;
            }
        }
    }

    static public void usingArray(String s) {

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                System.out.println(s.charAt(i) + " " + i);
                return;
            }
        }

    }

    public static void main(String[] args) {

        String s = "leetcode";
        usingHash(s);
        usingArray(s);

    }
}

// import java.util.*;

// public class FirstNonRepeatingCharacter {
// public static void main(String[] args) {

// String s = "leetcode";

// int[] count = new int[26];
// for (int i = 0; i < s.length(); i++) {
// int index = s.charAt(i) - 'a';
// count[index]++;
// }

// for (int i = 0; i < s.length(); i++) {
// int index = s.charAt(i) - 'a';
// if (count[index] == 1) {
// System.out.println(s.charAt(i) + " " + i);
// return;
// }
// }

// }
// }
