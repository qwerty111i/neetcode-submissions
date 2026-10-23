class Solution {
    public int lengthOfLIS(int[] nums) {
        int longestLength = 1;
        int[] longestNums = new int[nums.length];
        Arrays.fill(longestNums, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    longestNums[i] = Math.max(longestNums[j] + 1, longestNums[i]);
                }
            }

            longestLength = Math.max(longestNums[i], longestLength);
        }

        return longestLength;
    }
}
