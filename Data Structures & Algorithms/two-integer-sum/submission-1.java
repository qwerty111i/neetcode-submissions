class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> differenceMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (differenceMap.containsKey(difference)) {
                return new int[] {differenceMap.get(difference), i};
            }

            differenceMap.put(nums[i], i);
        }
        return new int[] {};
    }
}
