class WordDictionary {
    private WordDictionary[] children;
    private boolean isWord;

    public WordDictionary() {
        children = new WordDictionary[26];
        isWord = false;
    }

    public void addWord(String word) {
        WordDictionary curr = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new WordDictionary();
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(this, word, 0);
    }

    private boolean searchHelper(WordDictionary curr, String word, int currIndex) {
        for (int i = currIndex; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (curr.children[j] != null) {
                        if (searchHelper(curr.children[j], word, i + 1)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    return false;
                } else {
                    curr = curr.children[index];
                }
            }
        }
        return curr.isWord;
    }
}
