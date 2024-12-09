/**
 * BinaryToDecimal
 */
public class BinaryToDecimal {

    public static void main(String[] args) {

        int num = 110101010;

        BtoD(num);

    }

    private static void BtoD(int num) {

        int digits = num;
        int i = 0;
        int dec = 0;
        while (digits != 0) {
            int msb = digits % 10;
            digits /= 10;

            dec = dec + (int) (msb * Math.pow(2, i));
            i++;
            System.out.print(dec);  
        }

    }
}