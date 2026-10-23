class Solution {
    public int rob(int[] nums) {
        int twoAgo = 0;
        int oneAgo = 0;
        int curr = 0;
        
        for (int i = 0; i < nums.length; i++) {
            curr = Math.max(oneAgo, twoAgo + nums[i]);

            twoAgo = oneAgo;
            oneAgo = curr;
        }

        return curr;
    }
}
