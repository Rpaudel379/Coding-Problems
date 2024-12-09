import java.util.HashMap;

public class TwentyEight {
    public static void main(String[] args) {
        FirstUniqueCharacter fs = new FirstUniqueCharacter();
        // String s = "leetcode";
        String s = "loveleetcode";

        System.out.println(fs.usingArray(s));
        System.out.println(fs.usingHashMap(s));
    }
}

class FirstUniqueCharacter {

    public int usingHashMap(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public int usingArray(String s) {
        int length = s.length();
        int[] count = new int[26];

        // fill the count array
        for (int i = 0; i < length; i++) {
            int index = s.charAt(i) - 'a';

            count[index] += 1;

        }

        // check the unique the char
        for (int i = 0; i < length; i++) {
            int index = s.charAt(i) - 'a';

            if (count[index] == 1) {
                return i;
            }
        }

        return -1;

    }
}
