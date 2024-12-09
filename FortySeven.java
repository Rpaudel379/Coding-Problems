import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class FortySeven {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longest = new LongestRepeatingCharacterReplacement();

        {
            // longest.characterReplacement("ABAB", 1);
            // longest.characterReplacement("ABAABBAAAAB", 2);
            // longest.bruteForce("ABAABBAAAAB", 2);
            longest.bruteForce("AABBBA", 1);
            longest.linear("AABBBA", 1);
            longest.linear("AABBABAA", 1);
        }

    }
}

class LongestRepeatingCharacterReplacement {

    // O(N)
    // O(N)

    public int linear2(String s, int k) {
        int length = s.length();
        int longest = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0;
        int maxF = 0;
        while (right < length) {
            char currC = s.charAt(right);
            map.put(currC, map.getOrDefault(currC, 0) + 1);


             maxF = Math.max(maxF, map.get(currC));

            while (((right - left + 1) - maxF) > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            longest = Math.max(longest, right - left + 1);
            right++;
        }

        System.out.println(longest);
        return longest;
    }
    // O(26*N)
    // O(N)

    public int linear(String s, int k) {
        int length = s.length();
        int longest = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0;

        while (right < length) {
            char currC = s.charAt(right);
            map.put(currC, map.getOrDefault(currC, 0) + 1);

            // int maxValue = Collections.max(map.values());

            while (((right - left + 1) - Collections.max(map.values())) > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            longest = Math.max(longest, right - left + 1);
            right++;
        }

        System.out.println(longest);
        return longest;
    }

    public int bruteForce(String s, int k) {

        int[] longest = { 0 };
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        // ABAABBAAAAB
        set.forEach(ch -> {

            int left = 0, right = 0;
            int t = 0;

            while (right < s.length()) {
                char currC = s.charAt(right);

                if (ch == currC) {
                    right++;
                } else if (ch != currC && t < k) {
                    right++;
                    t++;
                } else {
                    longest[0] = Math.max(longest[0], right - left);

                    while (s.charAt(left) == ch) {
                        left++;
                    }

                    left++;
                    t--;
                }

                longest[0] = Math.max(longest[0], right - left);

            }

        });
        System.out.println(longest[0]);
        return longest[0];
    }

    public int characterReplacement(String s, int k) {
        int length = s.length();
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        int[] longest = { 0 };
        set.forEach(ch -> {

            int left = 0, right = 0;
            int t = k;

            while (right < length) {

                if (ch == s.charAt(right)) {
                    right++;
                } else if ((ch != s.charAt(right)) && (t > 0)) {
                    right++;
                    t--;
                } else {
                    longest[0] = Math.max(longest[0], right - left);
                    while (s.charAt(left) == ch) {
                        left++;
                    }
                    left++;
                    t++;
                }
            }
            longest[0] = Math.max(longest[0], right - left);
        });

        System.out.println(longest[0]);
        return longest[0];
    }
}