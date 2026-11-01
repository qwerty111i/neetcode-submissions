class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> stringMap = new HashMap<>();

       for (String str : strs) {
        int[] charArr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            charArr[str.charAt(i) - 'a']++;
        }

        String charString = Arrays.toString(charArr);

        List<String> currList = stringMap.getOrDefault(charString, new ArrayList<>());
        currList.add(str);
        stringMap.put(charString, currList);
       }

       List<List<String>> retList = new ArrayList<>();
       stringMap.forEach((key, value) -> {
        retList.add(value);
       });

       return retList;
    }
}
