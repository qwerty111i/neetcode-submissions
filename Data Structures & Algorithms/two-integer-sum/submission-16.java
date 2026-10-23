class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currTarget = target - nums[i];
            Integer targetIdx = numMap.get(currTarget);
            if (targetIdx != null) {
                return new int[] {targetIdx, i};
            }

            numMap.put(nums[i], i);
        }

        return new int[0];
    }
}
