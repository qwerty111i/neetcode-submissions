class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charArr = new int[128];
        int longest = 0;

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            charArr[s.charAt(i)]++;
            while (charArr[s.charAt(i)] > 1) {
                charArr[s.charAt(left)]--;
                left++;
            }
            
            longest = Math.max(longest, i - left + 1);
        }

        return longest;
    }
}
