class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] charArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charArr[c - 'a'] = i;
        }

        List<Integer> retList = new ArrayList<>();
        int endIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            int size = 1;
            endIdx = charArr[s.charAt(i) - 'a'];
            while (i < endIdx) {
                i++;
                size++;
                char nextChar = s.charAt(i);
                if (charArr[nextChar - 'a'] > endIdx) endIdx = charArr[nextChar - 'a'];
            }


            retList.add(size);
        }

        return retList;
    }
}
