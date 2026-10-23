class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        char[] sCharacterArr = s.toCharArray();
        for (int i = 0; i < sCharacterArr.length; i++) {
            sMap.put(sCharacterArr[i], sMap.getOrDefault(sCharacterArr[i], 0) + 1);
        }

        char[] tCharacterArr = t.toCharArray();
        for (int i = 0; i < tCharacterArr.length; i++) {
            tMap.put(tCharacterArr[i], tMap.getOrDefault(tCharacterArr[i], 0) + 1);
        }

        if (sMap.equals(tMap)) {
            return true;
        }

        return false;
    }
}
