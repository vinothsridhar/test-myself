public class MaxProfitDemo {

    public static void main(String[] args) {

        int[] input = new int[]{
                45, 24, 35, 31, 40, 38, 11
        };

        System.out.println(maxProfit(input));

    }

    public static int maxProfit(int[] prices) {
        int maxProfit = -1;
        int buyPrice = 0;
        int sellPrice;

        boolean changeBuyIndex = true;

        int buyIndex = 0;
        int sellIndex = 1;

        for (int i = 0; i < prices.length - 1; i++) {
            sellPrice = prices[i + 1];

            if (changeBuyIndex) {
                buyPrice = prices[i];
                buyIndex = i;
            }

            if (sellPrice < buyPrice) {
                changeBuyIndex = true;
            } else {
                int tempProfit = sellPrice - buyPrice;
                if (tempProfit > maxProfit) {
                    maxProfit = tempProfit;
                    sellIndex = i + 1;
                }
                changeBuyIndex = false;
            }

        }

        System.out.println("buy day: " + prices[buyIndex] + ", sell day: " + prices[sellIndex]);

        return maxProfit;
    }

}