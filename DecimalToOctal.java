public class DecimalToOctal {
    public static void main(String[] args) {
        int num = 156;
        DtoO(num);

    }

    private static void DtoO(int num) {

        int octal = 0;

        int i = 1;
        while (num != 0) {
            int rem = num % 8;
            num /= 8;
            octal += (i * rem);
            i *= 10;
        }
        System.out.println(octal);

    }
}
// 