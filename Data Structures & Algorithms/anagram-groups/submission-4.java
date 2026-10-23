class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> wordMap = new HashMap<>();

       for (String str : strs) {
        int[] charArr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            charArr[c - 'a']++;
        }

        String key = Arrays.toString(charArr);
        if (wordMap.containsKey(key)) {
            List<String> currList = wordMap.get(key);
            currList.add(str);
            wordMap.put(key, currList);
        } else {
            List<String> newList = new ArrayList<>();
            newList.add(str);
            wordMap.put(key, newList);
        }
       }

       List<List<String>> outputList = new ArrayList<>();
       wordMap.forEach((key, value) -> {
        outputList.add(value);
       });

       return outputList;
    }
}
