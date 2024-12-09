import java.util.ArrayList;

public class Sixteen {
    public static void main(String[] args) {
        EnDe ende = new EnDe();
        String[] str = { "AnishAnishAnishAnish", "Paudel", "SWE" };

        String encode = ende.encode(str);
        ende.decode(encode);
        ende.decode2(encode);
        ende.decode3(encode);
    }
}

class EnDe {
    public String encode(String[] str) {
        String s = "";
        int length = str.length;

        for (int i = 0; i < length; i++) {
            s += Integer.toString(str[i].length()) + "#" + str[i];
        }

        System.out.println(s);
        return s;
    }

    public ArrayList<String> decode(String encoded) {
        ArrayList<String> decoded = new ArrayList<>();

        int length = encoded.length();
        int i = 0;
        while (i < length) {

            int j = i;
            while (j < length && encoded.charAt(j) != '#') {
                j++;
            }

            int l = Integer.parseInt(encoded.substring(i, j));
            String word = encoded.substring(j + 1, j + 1 + l);
            decoded.add(word);
            i = j + l + 1;
        }

        System.out.println(decoded);
        return decoded;
    }

    public ArrayList<String> decode2(String encoded) {
        ArrayList<String> decoded = new ArrayList<>();
        int length = encoded.length();

        for (int i = 0; i < length;) {

            int l = 0;

            while (i < length && encoded.charAt(i) != '#') {
                l = (l * 10) + (encoded.charAt(i) - '0');
                i++;
            }

            String word = encoded.substring(i + 1, i + 1 + l);
            decoded.add(word);

            i = i + 1 + l;
        }

        System.out.println(decoded);
        return decoded;
    }

    public ArrayList<String> decode3(String encoded) {
        ArrayList<String> decoded = new ArrayList<>();

        int length = encoded.length();
        int i = 0;
        while (i < length) {

            int j = i;
            while (j < length && Character.isDigit(encoded.charAt(j))) {
                j++;
            }
            int l = Integer.parseInt(encoded.substring(i, j));

            String word = encoded.substring(j + 1, j + 1 + l);

            decoded.add(word);

            i = j + l + 1;
        }

        System.out.println(decoded);
        return decoded;
    }

}