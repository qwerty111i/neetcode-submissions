class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seenSet = new HashSet<>();
        for (int num : nums) {
            if (seenSet.contains(num)) return true;
            seenSet.add(num);
        }

        return false;
    }
}