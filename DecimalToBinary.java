public class DecimalToBinary {
    public static void main(String[] args) {
        int num = 22;
        DtoBUsingNumber(num);
        DtoBUsingString(num);
        DtoBUsingArray(num)     ;

    }

    private static void DtoBUsingNumber(int num) {
        long binary = 0;
        int i = 1;
        while (num != 0) {
            int rem = num % 2;
            num /= 2;
            binary += rem * i;
            i *= 10;
        }
        System.out.println(binary);
    }

    private static void DtoBUsingArray(int num) {
        int[] binary = new int[64];

        int i = 0;
        while (num != 0) {
            int rem = num % 2;
            num /= 2;
            binary[i] = rem;
            i++;
        }

        for (int j = i - 1; j >= 0; j--) {
            System.out.print(binary[j]);
        }

    }

    private static void DtoBUsingString(int num) {

        String bin = "";
        StringBuffer sb = new StringBuffer();

        while (num != 0) {
            int rem = num % 2;
            num /= 2;
            bin += Integer.toString(rem);
        }
        System.out.println(sb.append(bin).reverse());

    }
}
