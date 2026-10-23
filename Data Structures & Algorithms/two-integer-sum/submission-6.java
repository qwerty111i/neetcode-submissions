class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            int targetNum = target - currNum;

            if (numMap.containsKey(targetNum)) {
                int j = numMap.get(targetNum);
                return new int[] {j, i};
            }

            numMap.put(currNum, i);
        }

        return new int[] {};
    }
}
