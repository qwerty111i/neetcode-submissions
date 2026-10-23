class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;
        for (int num : nums) {
            if (numSet.contains(num - 1)) continue;
            
            int currNum = num;
            int currLongest = 1;
            while (numSet.contains(currNum + 1)) {
                currLongest++;
                currNum++;
            }

            longest = Math.max(currLongest, longest);
        }

        return longest;
    }
}
