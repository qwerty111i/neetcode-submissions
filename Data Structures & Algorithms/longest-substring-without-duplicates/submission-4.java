class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
                map.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i), i);
            }

            longest = Math.max(longest, i - left + 1);
        }

        return longest;
    }
}
