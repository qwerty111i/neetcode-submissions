class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] charCountArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCountArr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            charCountArr[t.charAt(i) - 'a']--;
            if (charCountArr[t.charAt(i) - 'a'] < 0) return false;
        }

        for (int count : charCountArr) {
            if (count != 0) return false;
        }

        return true;
    }
}
