public class Eight {
    public static void main(String[] args) {

        // int[] arr = { 2, 4, 1 };
        // int[] arr = { 3, 4, 5, 6, 3, 10, 2, 11 };
        int[] arr = { 7, 1, 5, 3, 6, 4 };

        // int[] arr = { 3, 2, 14, 12 };
        // int[] arr = { 1, 2 };

        // maxProfit(arr);
        // revise(arr);
        revise(new int[] { 7, 2, 5, 1, 3, 6, 4, 0, 26 });

    }

    private static void maxProfit(int[] prices) {

        int length = prices.length;

        int buyP = 0;
        int sellP = 1;
        int maxProfit = 0;

        // 7,2,5,1,3,6,4

        while (sellP < length) {

            int buying = prices[buyP];
            int selling = prices[sellP];

            int currentProfit = selling - buying;
            if (selling > buying) {
                maxProfit = Math.max(maxProfit, currentProfit);
            } else {
                buyP = sellP;
            }
            sellP++;

        }

        // System.out.println(buyP + " " + sellP);
        System.out.println(maxProfit);
    }

    private static void revise(int[] prices) {

        // 7,1,5,3,6,4
        // 7,2,5,1,3,6,4,0,26
        // 5 4 3 2 1

        int max = 0;

        int b = 0, s = 0;

        while (s < prices.length) {

            int buy = prices[b];
            int sell = prices[s];

            if (buy < sell) {
                max = Math.max(max, sell - buy);
            } else {
                b = s;
            }

            s++;
        }

        System.out.println(max);
    }

}
