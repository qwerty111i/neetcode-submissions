class Solution {
    public int characterReplacement(String s, int k) {
        int[] charFreq = new int[26];
        int longestWindow = 0;
        int maxFreq = 0;

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i) - 'A']++;
            maxFreq = Math.max(maxFreq, charFreq[s.charAt(i) - 'A']);

            while (k < (i - left + 1) - maxFreq) {
                charFreq[s.charAt(left) - 'A']--;
                left++;
            }

            longestWindow = Math.max(longestWindow, i - left + 1);
        }

        return longestWindow;
    }
}
