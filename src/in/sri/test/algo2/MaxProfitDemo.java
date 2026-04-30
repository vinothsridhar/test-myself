package in.sri.test.algo2;

public class MaxProfitDemo {

    public static void main(String[] args) {

        int[] input = new int[]{
                45, 24, 35, 31, 40, 38, 11
        };

        System.out.println(maxProfit(input));

    }

    public static int maxProfit(int[] prices) {
        int maxProfit = -1;

        int buyIndex = 0;
        int sellIndex = 1;

        int buyPrice = prices[buyIndex];
        int sellPrice = prices[sellIndex];

        for (int i = 0; i < prices.length-1; i++) {
            sellIndex = i + 1;
            if (prices[sellIndex] < prices[buyIndex]) {
                buyIndex = sellIndex;
            } else {
                int tempProfit = prices[sellIndex] - prices[buyIndex];
                if (tempProfit > maxProfit) {
                    buyPrice = prices[buyIndex];
                    sellPrice = prices[sellIndex];
                    maxProfit = tempProfit;
                }
            }
        }

        System.out.println("buy day: " + buyPrice + ", sell day: " + sellPrice);

        return maxProfit;
    }

}