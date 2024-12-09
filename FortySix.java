import java.util.HashMap;
import java.util.HashSet;

public class FortySix {
    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters longest = new LongestSubstringWithoutRepeatingCharacters();

        String s = "abcabcbb";

        {
            longest.lengthOfLongestSubstring(s);
        }
        {
            longest.usingSet(s);
        }

    }
}

class LongestSubstringWithoutRepeatingCharacters {

    public int usingSet(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int longest = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;

            }

            longest = Math.max(longest, r - l + 1);
            set.add(c);
        }

        System.out.println(longest);
        return longest;
    }

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int start = 0;

        // abcabcbb
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (map.getOrDefault(c, -1) >= start) {
                start = map.get(c) + 1;
            }

            longest = Math.max(longest, i - start + 1);
            map.put(c, i);
        }

        // System.out.println(map);
        System.out.println(longest);
        return longest;
    }

}