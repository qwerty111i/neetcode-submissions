class Solution {
    public int climbStairs(int n) {
        int twoAway = 1;
        int oneAway = 1;

        int curr = 1;
        for (int i = 2; i <= n; i++) {
            curr = twoAway + oneAway;

            twoAway = oneAway;
            oneAway = curr;
        }

        return curr;
    }
}
