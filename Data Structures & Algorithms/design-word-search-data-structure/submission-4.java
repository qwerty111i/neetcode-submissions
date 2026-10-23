class WordDictionary {
    private WordDictionary[] children;
    private boolean isWord;

    public WordDictionary() {
        children = new WordDictionary[26];
        isWord = false;
    }

    public void addWord(String word) {
        WordDictionary curr = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new WordDictionary();
            }

            curr = curr.children[index];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        return searchValid(word, this, 0);
    }

    public boolean searchValid(String word, WordDictionary curr, int index) {
        if (index == word.length()) {
            return curr.isWord;
        }
        
        if (word.charAt(index) == '.') {
            for (int j = 0; j < 26; j++) {
                if (curr.children[j] != null) {
                    if (searchValid(word, curr.children[j], index + 1) == true) {
                        return true;
                    }
                }
            }

            return false;
        } else {
            int wordIndex = word.charAt(index) - 'a';
            if (curr.children[wordIndex] == null) return false;
            curr = curr.children[wordIndex];

            return searchValid(word, curr, index + 1);
        }
    }
}
