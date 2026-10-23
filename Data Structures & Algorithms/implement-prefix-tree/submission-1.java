class PrefixTree {
    PrefixTree[] children;
    boolean isWord;

    public PrefixTree() {
         children = new PrefixTree[26];
         isWord = false;
    }

    public void insert(String word) {
        PrefixTree curr = this;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (curr.children[index] == null) curr.children[index] = new PrefixTree();
            curr = curr.children[index];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        PrefixTree curr = this;

        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] != null) curr = curr.children[word.charAt(i) - 'a'];
            else return false;
        }

        if (curr.isWord == true) return true;
        else return false;
    }

    public boolean startsWith(String prefix) {
        PrefixTree curr = this;

        for (int i = 0; i < prefix.length(); i++) {
            if (curr.children[prefix.charAt(i) - 'a'] != null) curr = curr.children[prefix.charAt(i) - 'a'];
            else return false;
        }

        return true;
    }
}
