class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> stringMap = new TreeMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            Map<Character, Integer> keyMap = new TreeMap<>();
            for (int j = 0; j < str.length(); j++) {
                keyMap.put(str.charAt(j), keyMap.getOrDefault(str.charAt(j), 0) + 1);
            }

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : keyMap.entrySet()) {
                sb.append(entry.getKey()).append(entry.getValue());
            }

            String uniqueKey = sb.toString();
            if (stringMap.containsKey(uniqueKey)) {
                List<Integer> currIndices = stringMap.get(uniqueKey);
                currIndices.add(i);
                stringMap.put(uniqueKey, currIndices);
            } else {
                List<Integer> currIndices = new ArrayList<>();
                currIndices.add(i);
                stringMap.put(uniqueKey, currIndices);
            }
        }

        List<List<String>> finalList = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : stringMap.entrySet()) {
            List<String> wordList = new ArrayList<>();
            List<Integer> integerList = entry.getValue();

            for (int index : integerList) {
                wordList.add(strs[index]);
            }

            finalList.add(wordList);
        }

        return finalList;
    }
}
