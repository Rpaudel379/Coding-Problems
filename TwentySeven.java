public class TwentySeven {
    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();

        String s = "A man, a plan, a canal: Panama";

        System.out.println(vp.isPalindrome(s));
    }
}

class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int length = s.length();
        int i = 0, j = length - 1;

        while (i < j) {

            char start = s.charAt(i);
            char end = s.charAt(j);

            if (!isAlphaNumeric(start)) {
                i++;
                continue;
            }

            if (!isAlphaNumeric(end)) {
                j--;
                continue;
            }

            if (toLower(start) != toLower(end)) {
                return false;
            }

            i++;
            j--;

        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {

        if ((c >= 65 && c <= 90) ||
                (c >= 97 && c <= 122) ||
                (c >= 48 && c <= 57)) {
            return true;
        }

        return false;
    }

    private char toLower(char c) {

        if (c >= 97 && c <= 122) {
            return c;
        }

        return (char) ((int) c + 32);
    }

}