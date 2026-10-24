class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;

        int totalProfit = 0;
        while (right < prices.length) {
            int profit = prices[right] - prices[left];
            totalProfit = Math.max(totalProfit, profit);

            if (prices[right] < prices[left]) {
                left = right;
            }
            
            right++;
        }

        return totalProfit;
    }
}
