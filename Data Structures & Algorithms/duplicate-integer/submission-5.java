class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seenSet = new HashSet<>();
        for (int num : nums) {
            if (!seenSet.add(num)) {
                return true;
            }
        }

        return false;
    }
}