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
        for (int i = index; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < 26; j++) {
                    if (curr.children[j] != null) {
                        boolean currValid = searchValid(word, curr.children[j], i + 1);
                        if (currValid == true) return true;
                    }
                }

                return false;
            } else {
                int nextIndex = word.charAt(i) - 'a';
                if (curr.children[nextIndex] == null) return false;
                curr = curr.children[nextIndex];
            }
        }

        return curr.isWord;
    }
}
