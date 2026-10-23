class Solution {
    public int longestConsecutive(int[] nums) {
        int currLongest = 0;
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : nums) {
            if (numSet.contains(num - 1)) continue;

            int nextNum = num + 1;
            int currLength = 1;
            while (numSet.contains(nextNum)) {
                currLength++;
                nextNum++;
            }

            currLongest = Math.max(currLongest, currLength);
        }

        return currLongest;
    }
}
