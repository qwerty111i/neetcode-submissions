class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        int numCombinations = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - k;

            if (prefixSum.containsKey(target)) {
                numCombinations += prefixSum.get(target);
            }
            
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return numCombinations;
    }
}