class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestSeq = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currLongestSeq = 1;
                while (numSet.contains(num + 1)) {
                    num++;
                    currLongestSeq++;
                }

                longestSeq = Math.max(longestSeq, currLongestSeq);
            }
        }

        return longestSeq;
    }
}
