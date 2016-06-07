
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int base = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - base > profit)
                profit = prices[i] - base;
            if (prices[i] < base)
                base = prices[i];
        }
        
        return profit;
    }
}
