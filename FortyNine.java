import java.util.HashMap;

public class FortyNine {

    public static void main(String[] args) {

        MinimumWindowSubstring ms = new MinimumWindowSubstring();

        {

            String s = "ADOBECODEBANC", t = "ABC";

            ms.linearUsingArray(s, t);

        }

        // {

        // String s = "a", t = "a";

        // ms.minWindow(s, t);

        // }
        {

        String s = "aa", t = "aa";

        ms.linearUsingArray(s, t);

        }
        // {

        //     String s = "bdab", t = "ab";

        //     ms.linearUsingArray(s, t);

        // }

    }
}

class MinimumWindowSubstring {

    public String linearUsingArray(String s, String t) {

        if (t.length() > s.length() || t.equals("")) {
            return "";
        }

        int[] map = new int[128];
        int[] window = new int[128];
        int count = 0;

        for (char c : t.toCharArray()) {
            map[c - 'A']++;
            if (map[c - 'A'] == 1) {
                count++;
            }
        }

        int matches = 0;
        int[] res = new int[2];
        int resLen = Integer.MAX_VALUE;
        int l = 0, r = 0;

        while (r < s.length()) {
            char c = s.charAt(r);

            window[c - 'A']++;
            if (window[c - 'A'] == map[c - 'A']) {
                matches++;
            }

            while (matches == count) {

                if (r - l + 1 < resLen) {
                    res[0] = l;
                    res[1] = r;
                    resLen = r - l + 1;

                }
                System.out.println(s.substring(res[0], (res[1] + 1)));
                window[s.charAt(l) - 'A']--;
                if (window[s.charAt(l) - 'A'] < map[s.charAt(l) - 'A']) {
                    matches--;
                }
                l++;
            }

            r++;
        }

        return (resLen == Integer.MAX_VALUE) ? "" : s.substring(res[0], res[1] + 1);
    }

    public String linear(String s, String t) {
        if (t == "") {
            return "";
        }
        int l1 = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map.size());

        int[] res = new int[2];
        int resLen = Integer.MAX_VALUE;
        int have = 0, need = map.size();
        int l = 0;

        for (int r = 0; r < l1; r++) {

            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (map.containsKey(c) && window.get(c) == map.get(c)) {
                have++;
            }

            while (have == need) {
                // ADOBECODEBANC
                // update the result
                if ((r - l + 1) < resLen) {
                    res[0] = l;
                    res[1] = r;
                    resLen = r - l + 1;
                }
                System.out.println(s.substring(res[0], res[1] + 1));

                char lChar = s.charAt(l);
                // remove from left of window
                window.put(lChar, window.get(lChar) - 1);

                // compare
                if (map.containsKey(lChar) && window.get(lChar) < map.get(lChar)) {
                    have--;
                }

                l++;

            }

        }

        return (resLen == Integer.MAX_VALUE) ? "" : s.substring(res[0], res[1] + 1);

    }


}