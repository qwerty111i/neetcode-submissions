class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charArr = new int[128];

        int left = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charArr[c]++;

            while (charArr[c] > 1) {
                charArr[s.charAt(left)]--;
                left++;
            }

            length = Math.max(length, i - left + 1);
        }

        return length;
    }
}
