class Solution {
    public int jump(int[] nums) {
        int numJumps = 0;
        int currEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);

            if (i == currEnd) {
                numJumps++;
                currEnd = farthest;
            }
        }

        return numJumps;
    }
}
