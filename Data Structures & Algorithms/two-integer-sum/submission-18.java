class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currTarget = target - nums[i];
            int targetIdx = numMap.getOrDefault(currTarget, -1);
            if (targetIdx != -1) {
                return new int[] {targetIdx, i};
            }

            numMap.put(nums[i], i);
        }

        return new int[0];
    }
}
