class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int twoAgo = cost[0];
        int oneAgo = cost[1];
        int totalCost = 0;

        for (int i = 2; i < cost.length; i++) {
            totalCost = cost[i] + Math.min(twoAgo, oneAgo);

            twoAgo = oneAgo;
            oneAgo = totalCost;
        }

        return Math.min(oneAgo, twoAgo);
    }
}
