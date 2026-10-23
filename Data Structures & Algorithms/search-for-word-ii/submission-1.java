class Solution {
    class Node {
        Node[] children;
        String finishedWord;

        public Node() {
            children = new Node[26];
            finishedWord = null;
        }
    }

    public Node buildPrefixTree(String[] words) {
        Node newNode = new Node();
        for (String word : words) {
            Node curr = newNode;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new Node();
                }
                curr = curr.children[index];
            }
            curr.finishedWord = word;
        }

        return newNode;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node prefixTree = buildPrefixTree(words);

        List<String> outputList = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(r, c, board, outputList, prefixTree);
            }
        }

        return outputList;
    }

    public void dfs(int r, int c, char[][] board, List<String> outputList, Node prefixTree) {
        if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
            char ch = board[r][c];
            if (ch == '#') return;
            int index = ch - 'a';

            if (prefixTree.children[index] == null) return;
            
            prefixTree = prefixTree.children[index];
            if (prefixTree.finishedWord != null) {
                outputList.add(prefixTree.finishedWord);
                prefixTree.finishedWord = null;
            }

            board[r][c] = '#';
            dfs(r + 1, c, board, outputList, prefixTree);
            dfs(r - 1, c, board, outputList, prefixTree);
            dfs(r, c + 1, board, outputList, prefixTree);
            dfs(r, c - 1, board, outputList, prefixTree);

            board[r][c] = ch;
        }
    }
}
