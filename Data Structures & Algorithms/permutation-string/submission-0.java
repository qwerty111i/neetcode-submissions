class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] char1 = new char[26];
        char[] char2 = new char[26];
        for (char c : s1.toCharArray()) {
            char1[c - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            char2[s2.charAt(right) - 'a']++;
            if (Arrays.equals(char1, char2)) return true;

            if (right - left + 1 == s1.length())  {
                char2[s2.charAt(left) - 'a']--;
                left++;
            }
        }

        return false;
    }
}
