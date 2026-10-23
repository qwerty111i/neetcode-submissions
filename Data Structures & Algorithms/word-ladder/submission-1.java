class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int minNumWords = 0;
        Queue<String> frontierSet = new ArrayDeque<>();

        Set<String> wordSet = new HashSet<>(wordList);
        frontierSet.offer(beginWord);
        wordSet.remove(beginWord);

        while (!frontierSet.isEmpty()) {
            minNumWords++;
            int queueSize = frontierSet.size();
            for (int i = 0; i < queueSize; i++) {
                String nextWord = frontierSet.poll();
                if (nextWord.equals(endWord)) {
                    return minNumWords;
                }

                char[] charArr = nextWord.toCharArray();
                for (int j = 0; j < charArr.length; j++) {
                    char currChar = charArr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == currChar) continue;

                        charArr[j] = c;
                        String newString = new String(charArr);
                        if (wordSet.contains(newString)) {
                            frontierSet.offer(newString);
                            wordSet.remove(newString);
                        }
                    }
                    charArr[j] = currChar;
                }
            }
        }

        return 0;
    }
}
