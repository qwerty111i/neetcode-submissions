class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0;
        
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - prices[left]);
            if (prices[i] < prices[left]) left = i;
        }

        return profit;
    }
}
