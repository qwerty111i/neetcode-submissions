class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] returnArr = new int[2];

        Map<Integer, Integer> differenceMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (differenceMap.containsKey(difference)) {
                returnArr[0] = differenceMap.get(difference);
                returnArr[1] = i;
                return returnArr;
            }

            differenceMap.put(nums[i], i);
        }
        return returnArr;
    }
}
