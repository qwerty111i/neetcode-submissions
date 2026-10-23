class PrefixTree {
    private PrefixTree[] children;
    private boolean isWord;

    public PrefixTree() {
         this.children = new PrefixTree[26];
         this.isWord = false;
    }

    public void insert(String word) {
        PrefixTree curr = this;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new PrefixTree();
            }

            curr = curr.children[index];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        PrefixTree curr = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return false;
            } else {
                curr = curr.children[index];
            }
        }

        if (curr.isWord == true) {
            return true;
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        PrefixTree curr = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return false;
            } else {
                curr = curr.children[index];
            }
        }
        return true;
    }
}
