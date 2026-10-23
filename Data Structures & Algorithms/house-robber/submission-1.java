class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int twoAgo = 0;
        int oneAgo = 0;

        int curr = Math.max(twoAgo, oneAgo);
        for (int i = 0; i < nums.length; i++) {
            curr = Math.max(oneAgo, twoAgo + nums[i]);

            twoAgo = oneAgo;
            oneAgo = curr;
        }

        return curr;
    }
}
