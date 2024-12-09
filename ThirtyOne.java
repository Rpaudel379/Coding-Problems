public class ThirtyOne {
    public static void main(String[] args) {
        Stock2 stock = new Stock2();

        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        // int[] prices = new int[] { 1, 2, 3, 4, 5 };
        // int[] prices = new int[] { 7, 6, 4, 3, 1 };
        stock.maxProfit(prices);
        stock.maxProfit2(prices);
    }
}

class Stock2 {

    public int maxProfit2(int[] prices) {

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        System.out.println(profit);
        return profit;
    }

    public int maxProfit(int[] prices) {

        int profit = 0;

        int buyP = 0;
        int sellP = 1;
        int length = prices.length;

        while (sellP < length) {

            int buy = prices[buyP];
            int sell = prices[sellP];

            if (sell > buy) {
                profit += (sell - buy);
            }

            buyP = sellP;
            sellP++;
        }

        System.out.println(profit);
        return profit;
    }
}