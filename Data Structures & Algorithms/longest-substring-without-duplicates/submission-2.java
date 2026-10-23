class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueSet = new HashSet<>();
        int left = 0;

        int longestUnique = 0;
        int currLongest = 0;
        for (int right = 0; right < s.length(); right++) {
            while (uniqueSet.contains(s.charAt(right))) {
                uniqueSet.remove(s.charAt(left));
                left++; 
                currLongest--;
            }

            currLongest++;
            uniqueSet.add(s.charAt(right));
            longestUnique = Math.max(currLongest, longestUnique);
        }
        return longestUnique;
    }
}
