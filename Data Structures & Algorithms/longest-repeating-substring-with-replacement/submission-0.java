class Solution {
    public int characterReplacement(String s, int k) {
        char[] characterList = new char[26];
        int left = 0;

        int longestSubstring = 0;
        int currMaxFrequent = 0;
        for (int right = 0; right < s.length(); right++) {
            characterList[s.charAt(right) - 'A']++;
            currMaxFrequent = Math.max(characterList[s.charAt(right) - 'A'], currMaxFrequent);

            while (right - left + 1 - currMaxFrequent > k) {
                characterList[s.charAt(left) - 'A']--;
                left++;
            }

            longestSubstring = Math.max(longestSubstring, right - left + 1);
        }
        
        return longestSubstring;
    }
}