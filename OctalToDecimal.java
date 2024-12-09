public class OctalToDecimal {
    public static void main(String[] args) {
        int num = 123;
        OtoD(num);
    }

    private static void OtoD(int num) {
        int decimal = 0;
        int i = 0;
        while (num != 0) {

            int rem = num % 10;

            decimal +=  rem * Math.pow(8, i);
            System.out.println(rem + " " + decimal + " " + i);
            i++;
            num /= 10;
        }
        System.err.println(decimal);
    }
}
