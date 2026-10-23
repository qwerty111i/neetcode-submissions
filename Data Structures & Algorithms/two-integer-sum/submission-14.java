class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currTarget = target - nums[i];
            if (numMap.containsKey(currTarget)) {
                return new int[] {numMap.get(currTarget), i};
            }

            numMap.put(nums[i], i);
        }

        return new int[] {0, 0};
    }
}
