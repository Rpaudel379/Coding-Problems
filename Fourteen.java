import java.util.HashMap;

public class Fourteen {
    public static void main(String[] args) {

        BetterCompression compression = new BetterCompression();

        String str = "a2c9a4b2c1";
        // compression.compress(str);
        // compression.revise(str);
        // compression.revise2(str);
        compression.revise3(str);

        /*
         * for i in length, search for alpha char:
         * if(alpha):
         * 1. put in the bucket, with index as alpha char
         * 2. create a variable for counting occurences of that alpha char
         * 3. loop till another alpha char, while current element is not a alpha
         * 3.1. concat it in the local variable
         * 4. update the bucket with its occurence
         * 
         * else: skip
         * 
         * 
         */
    }
}

class BetterCompression {

    public void revise3(String str) {
        // a23c9b2c
        // 1. start from first char that is alphabet
        // 2. store the current alphabet, before going into the loop
        // 3. before the loop, increment the index pointer by one, so that it will point
        // to the digit(char)
        // 4. loop till current character is not a digit. while(isDigit(curr))
        // 5. count the occurences
        // 5. after the end of the nested loop, add the count to the bucket

        int[] bucket = new int[26];
        int length = str.length();

        for (int i = 0; i < length;) {
            int idx = str.charAt(i) - 'a';
            int count = 0;
            i++;
            while (i < length && isDigit3(str.charAt(i))) {
                count = (count * 10) + charToInt3(str.charAt(i));
                i++;
            }

            if (count == 0) {
                count = 1;
            }

            bucket[idx] += count;
        }

        String out = "";
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != 0) {
                out += (char) (i + 'a') + Integer.toString(bucket[i]);
            }
        }

        System.out.println(out);
    }

    public static int charToInt3(char c) {
        return c - 48;
    }

    public static boolean isDigit3(char c) {
        if (c >= 48 && c <= 57) {
            return true;
        }
        return false;
    }

    public static boolean isalpha(char c) {
        // check for both lower and upper
        if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
            return true;
        }
        return false;
    }

    public void compress(String str) {

        int[] compressed = new int[26];

        int length = str.length();
        int i = 0;

        while (i < length) {

            char alpha = str.charAt(i);
            int count = 0;
            i++;
            while (i < length && isDigit(str.charAt(i))) {
                count = count * 10 + charToInt(str.charAt(i));
                i++;
            }

            int index = alpha - 97;
            // in case of a3c9b2c
            if (count == 0)
                count = 1;
            compressed[index] += count;
        }

        String out = "";
        for (i = 0; i < compressed.length; i++) {
            if (compressed[i] > 0) {
                char c = (char) (i + 97);
                out += c + Integer.toString(compressed[i]);
            }
        }
        System.out.println(out);

    }

    private boolean isDigit(char d) {
        if (d >= 48 && d <= 57) {
            return true;
        }
        return false;
    }

    private int charToInt(char c) {
        return c - 48;
    }

    public void revise(String s) {
        // a23c9b2c
        int length = s.length();
        String[] compress = new String[26];

        for (int i = 0; i < length;) {

            int index = s.charAt(i) - 'a';
            // int count = 0;
            String count = "";
            i++;
            while (i < length && isDigit2(s.charAt(i))) {
                // count = (count * 10) + charToInt2(s.charAt(i));
                count += s.charAt(i);
                i++;
            }

            if (count == "") {
                count = "1";
            }

            if (compress[index] == null) {
                compress[index] = count;
            } else {
                int c = Integer.parseInt(compress[index]) + Integer.parseInt(count);
                compress[index] = Integer.toString(c);
            }

        }

        String out = "";

        for (int i = 0; i < length; i++) {
            if (compress[i] != null) {
                char alpha = (char) (i + 'a');
                out += alpha + compress[i];
            }
        }
        System.out.println(out);
    }

    private boolean isDigit2(char c) {
        return c >= 48 && c <= 57;
    }

    private int charToInt2(char c) {
        return c - '0';
    }

    public void revise2(String s) {
        // a23c9b2c
        HashMap<Character, Integer> map = new HashMap<>();
        int length = s.length();

        for (int i = 0; i < length;) {

            char alpha = s.charAt(i);

            int count = 0;
            i++;
            for (; i < length && isDigit(s.charAt(i));) {
                count = (count * 10) + charToInt2(s.charAt(i));
                i++;
            }

            if (count == 0) {
                count = 1;
            }

            map.put(alpha, map.getOrDefault(alpha, 0) + count);
        }

        // String out = "";
        StringBuilder out = new StringBuilder();
        map.forEach((a, c) -> {
            out.append(a + Integer.toString(c));
        });

        System.out.println(out);
    }

}