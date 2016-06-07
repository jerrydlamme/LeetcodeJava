
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                if (i < prices.length -2 && prices[i] - prices[i-1] < prices[i+2] - prices[i+1]) {
                    i++;
                    continue;
                }
                profit += prices[i] - prices[i-1];
                if (i < prices.length - 1 && prices[i+1] < prices[i]) i += 2; 
            }
        }
        
        return profit;
    }
}
