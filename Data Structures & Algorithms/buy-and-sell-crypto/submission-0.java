class Solution {
    public int maxProfit(int[] prices) {
        int leftPointer = 0;

        int maxProfit = 0;
        for (int rightPointer = 1; rightPointer < prices.length; rightPointer++) {
            int profit = prices[rightPointer] - prices[leftPointer];
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (prices[rightPointer] < prices[leftPointer]) {
                leftPointer = rightPointer;
            }
        }

        return maxProfit;
    }
}
