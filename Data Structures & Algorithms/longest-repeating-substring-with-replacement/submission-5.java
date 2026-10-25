class Solution {
    public int characterReplacement(String s, int k) {
        int mostFreq = 0;
        int[] charArr = new int[26];

        int left = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            charArr[s.charAt(i) - 'A']++;
            mostFreq = Math.max(mostFreq, charArr[s.charAt(i) - 'A']);

            while (i - left + 1 - mostFreq > k) {
                charArr[s.charAt(left) - 'A']--;
                left++;
            }

            longest = Math.max(longest, i - left + 1);
        }

        return longest;
    }
}
