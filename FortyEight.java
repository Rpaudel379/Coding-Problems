import java.util.Arrays;
import java.util.HashMap;

public class FortyEight {
    public static void main(String[] args) {
        PermutationInString p = new PermutationInString();

        {
            boolean a1 = p.bySorting("ab", "eidbaooo");
            System.out.println(a1);
        }
        {
            boolean a1 = p.usingHashmap("oz", "eidbaooz");
            System.out.println(a1);
        }
        {
            boolean a1 = p.usingArrays("ooz", "eidbaooz");
            System.out.println(a1);
        }
        {
            boolean a1 = p.slidingWindow1("ooz", "eidbaooz");
            System.out.println(a1);
        }

    }
}

class PermutationInString {

    // O(n1 + (n2 - n1))
    // O(1)
    public boolean slidingWindowOptimized1(String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 > l2) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // fill the first window on second array
        for (int i = 0; i < l1; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        // check the matching characters from the first sliding window
        for (int i = 0; i < 26; i++) {
            if (freq1[i] == freq2[i]) {
                count = count + 1;
            }
        }

        // check the matching characters from the remaining windows
        int l = 0;
        for (int r = l1; r < l2; r++) {
            if (count == 26) {
                return true;
            }

            // check the right pointer
            int index = s2.charAt(r) - 'a';

            // [1] [0] at first
            // [1] [1] after increment, count++
            // OR
            // [0] [0] at first
            // [0] [1] after increment, count--
            freq2[index]++;
            if (freq1[index] == freq2[index]) {
                count++;
            } else if (freq1[index] + 1 == freq2[index]) {
                count--;
            }

            index = s2.charAt(l) - 'a';
            freq2[index]--;
            // [1] [1] at first
            // [1] [0] after decrement, count--
            // OR
            // [0] [1] at first
            // [0] [0] after decrement, count++
            if (freq1[index] == freq2[index]) {
                count++;
            } else if (freq1[index] - 1 == freq2[index]) {
                count--;
            }

            l++;
        }

        return count == 26;
    }

    public boolean slidingWindowOptimized2(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 > l2) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < l1; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq1[i] == freq2[i]) {
                count = count + 1;
            }
        }

        for (int i = 0; i < (l2 - l1); i++) {

            if (count == 26) {
                return true;
            }

            int l = s2.charAt(i) - 'a';
            int r = s2.charAt(i + l1) - 'a';

            // left pointer
            freq2[l]--;
            if (freq1[l] == freq2[l]) {
                count++;
            } else if (freq1[l] - 1 == freq2[l]) {
                count--;
            }

            // right pointer
            freq2[r]++;
            if (freq1[r] == freq2[r]) {
                count++;
            } else if (freq1[r] + 1 == freq2[r]) {
                count--;
            }
        }

        return count == 26;
    }

    // O(n1 + 26*(n2 - n1))
    // O(n)
    public boolean slidingWindow2(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        // left pointer (i)
        for (int i = 0; i < (s2.length() - s1.length()); i++) {
            if (compareArrays(freq1, freq2)) {
                return true;
            }

            freq2[s2.charAt(i) - 'a']--;
            freq2[s2.charAt(i + s1.length()) - 'a']++;
        }

        return compareArrays(freq1, freq2);
    }

    // O(n1 + 26*(n2 - n1))
    // O(n)
    public boolean slidingWindow1(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        int l = 0, r = 0;
        for (r = 0; r < s1.length(); r++) {
            freq1[s1.charAt(r) - 'a']++;
            freq2[s2.charAt(r) - 'a']++;
        }

        // right pointer
        for (; r < s2.length();) {
            if (compareArrays(freq1, freq2)) {
                return true;
            }

            freq2[s2.charAt(r) - 'a']++;
            freq2[s2.charAt(l) - 'a']--;

            r++;
            l++;
        }

        return compareArrays(freq1, freq2);
    }

    // O(n1 + 26n1 (n2 - n1))
    // O(1) size 26 alphabets
    public boolean usingArrays(String s1, String s2) {

        int[] arr1 = new int[26];
        for (char c : s1.toCharArray()) {
            arr1[c - 'a']++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] arr2 = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                arr2[s2.charAt(i + j) - 'a']++;
            }

            if (compareArrays(arr1, arr2)) {
                return true;
            }

        }

        return false;
    }

    private boolean compareArrays(int[] arr1, int[] arr2) {

        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    // O(n1 + 26n1(n2 - n1))
    // O(1) , hashmap contains at most 26 key value pairs
    public boolean usingHashmap(String s1, String s2) {

        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> map2 = new HashMap<>();

            for (int j = 0; j < s1.length(); j++) {
                map2.put(s2.charAt(i + j), map2.getOrDefault(s2.charAt(i + j), 0) + 1);
            }

            if (compareHashMaps(map1, map2)) {
                return true;
            }

        }

        return false;
    }

    private boolean compareHashMaps(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {

        for (char keys : map1.keySet()) {

            if (map1.get(keys) - map2.getOrDefault(keys, -1) != 0) {
                return false;
            }

        }

        return true;
    }

    // O(n1 log(n1) + (n2 - n1) n1log(n1))
    // O(n1)
    public boolean bySorting(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        s1 = sort(s1);

        for (int i = 0; i < s2.length() - s1.length(); i++) {

            if (s1.equals(sort(s2.substring(i, i + s1.length())))) {
                return true;
            }

        }

        return false;
    }

    private String sort(String s) {

        char[] c = s.toCharArray();
        Arrays.sort(c);

        return new String(c);
    }

}