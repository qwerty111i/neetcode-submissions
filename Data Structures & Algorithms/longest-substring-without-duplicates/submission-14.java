class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int left = 0;
        int retVal = 1;

        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put(s.charAt(0), 0);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charMap.containsKey(c)) {
                left = Math.max(left, charMap.get(c) + 1);
            }

            charMap.put(c, i);
            retVal = Math.max(i - left + 1, retVal);
        }

        return retVal;
    }
}
