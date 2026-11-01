class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[left]) {
                left = i;
            } else {
                max = Math.max(max, prices[i] - prices[left]);
            }
        }

        return (max <= 0) ? 0 : max;
    }
}
