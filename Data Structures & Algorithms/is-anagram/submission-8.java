class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] charCountArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCountArr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            int idx = t.charAt(i) - 'a';
            charCountArr[idx]--;
            if (charCountArr[idx] < 0) return false;
        }

        return true;
    }
}
