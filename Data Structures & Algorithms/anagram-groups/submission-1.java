class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringMap = new HashMap<>();
        for (String s : strs) {
            int[] charCount = new int[26];
            for (char c : s.toCharArray()) {
                charCount[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i : charCount) {
                sb.append('#').append(i);
            }

            String uniqueKey = sb.toString();
            stringMap.computeIfAbsent(uniqueKey, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(stringMap.values());
    }
}
