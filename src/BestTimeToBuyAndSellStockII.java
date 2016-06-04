
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        
        int sum = 0;
        int profit = 0;
        int base = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - base > profit) {
                profit = prices[i] - base;
            } else {
                sum += profit;
                base = prices[i];
                profit = 0;
            }
        }
        
        sum += profit;
        
        return sum;
    }
}
