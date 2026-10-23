class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] char1 = new char[26];
        char[] char2 = new char[26];

        int numMatches = 0;
        for (char c : s1.toCharArray()) {
            if (char1[c - 'a'] == 0) numMatches++;
            char1[c - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            if (char2[s2.charAt(right) - 'a'] == char1[s2.charAt(right) - 'a']) {
                numMatches++;
            }

            char2[s2.charAt(right) - 'a']++;
            if (char2[s2.charAt(right) - 'a'] == char1[s2.charAt(right) - 'a']) {
                numMatches--;
            }

            if (numMatches == 0) return true;


            if (right - left + 1 == s1.length())  {
                if (char2[s2.charAt(left) - 'a'] == char1[s2.charAt(left) - 'a']) {
                    numMatches++;
                }

                char2[s2.charAt(left) - 'a']--;
                left++;

                if (char2[s2.charAt(left - 1) - 'a'] == char1[s2.charAt(left - 1) - 'a']) {
                    numMatches--;
                }

                if (numMatches == 0) return true;
            }
        }

        return false;
    }
}
