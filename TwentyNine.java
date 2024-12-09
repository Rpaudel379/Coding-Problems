public class TwentyNine {
    public static void main(String[] args) {
        Stock1 stock = new Stock1();

        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };

        stock.maxProfit(prices);
        stock.bruteForce(prices);
        stock.maxProfit(prices);
    }
}

class Stock1 {

    /*
     * 
     * Time Complexity : O(N)
     * 
     * Space Complexity : O(1), Constant space.
     * 
     * Solved using Dynamic Programming Approach(Space optimisation).
     * 
     */
    public int dp(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        int buyAtPrice = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            buyAtPrice = Math.min(buyAtPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - buyAtPrice);
        }

        System.out.println(maxProfit);
        return maxProfit;
    }

    public int bruteForce(int[] prices) {

        int length = prices.length;
        int maxProfit = 0;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {/*
                                                   * if (prices[j] - prices[i] > maxProfit) {
                                                   * maxProfit = prices[j] - prices[i];
                                                   * }
                                                   */
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        System.out.println(maxProfit);
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int length = prices.length;

        int maxProfit = 0;
        int buyingP = 0;
        int sellingP = 1;

        while (sellingP < length) {

            int buy = prices[buyingP];
            int sell = prices[sellingP];

            int profit = sell - buy;
            if (sell > buy) {
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyingP = sellingP;
            }
            sellingP++;
        }

        System.out.println(maxProfit);
        return maxProfit;
    }
}

/*
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 */