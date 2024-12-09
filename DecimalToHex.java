public class DecimalToHex {
    public static void main(String[] args) {
        int num = 245192;

        DtoH(num);
    }

    private static void DtoH(int num) {

        String hex = "";

        while (num != 0) {

            int rem = num % 16;
            char d = rem > 9 ? (char) (55 + rem) : (char) (rem + '0'); // or rem + 48
            hex = d + hex;
            System.out.println(hex);

            num /= 16;
        }

    }
}
