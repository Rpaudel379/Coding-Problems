public class HexToDecimal {
    public static void main(String[] args) {

        String hex = "1234F";

        HtoD(hex);
        second(hex);

    }

    private static void second(String hex) {
        int decimal = 0;

        int base = 1;
        for (int i = hex.length() - 1; i >= 0; i--) {

            decimal += (hex.charAt(i) >= '0' && hex.charAt(i) <= '9' ? hex.charAt(i) - 48 : hex.charAt(i) - 55) * base;

            base *= 16;
        }

        System.out.println(decimal);

    }

    private static void HtoD(String hex) {

        int decimal = 0;
        int j = 0;
        for (int i = hex.length() - 1; i >= 0; i--) {

            int rem = hex.charAt(i) >= '0' && hex.charAt(i) <= '9' ? hex.charAt(i) - 48 : hex.charAt(i) - 55;
            decimal += rem * Math.pow(16, j);
            System.out.println(decimal);
            j++;
            
        }

    }
}
