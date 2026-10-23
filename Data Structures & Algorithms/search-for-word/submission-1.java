class Solution {
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    char temp = board[r][c];

                    board[r][c] = '#';
                    boolean wordFound = checkNextLetter(board, r, c, word.substring(1, word.length()));
                    if (wordFound) return true;

                    board[r][c] = temp;
                }
            }
        }

        return false;
    }


    public boolean checkNextLetter(char[][] board, int r, int c, String word) {
        if (word.length() == 0) return true;
        
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] dir : dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            if (newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length) {
                if (board[newR][newC] == word.charAt(0)) {
                    if (word.length() == 1) return true;

                    char temp = board[newR][newC];
                    board[newR][newC] = '#';

                    boolean found = checkNextLetter(board, newR, newC, word.substring(1, word.length()));
                    if (found == true) return true;
                    board[newR][newC] = temp;
                }
            }
        }

        return false;
    }
}
