class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> rowSet = new ArrayList<>();
        List<Set<Integer>> colSet = new ArrayList<>();
        List<Set<Integer>> boxSet = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rowSet.add(new HashSet<>());
            colSet.add(new HashSet<>());
            boxSet.add(new HashSet<>());
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                char boardChar = board[r][c];
                if (boardChar == '.') continue;
                int num = Integer.parseInt(String.valueOf(boardChar));

                if (rowSet.get(r).contains(num)) {
                    return false;
                }
                rowSet.get(r).add(num);

                if (colSet.get(c).contains(num)) {
                    return false;
                }
                colSet.get(c).add(num);

                if (boxSet.get((r / 3) * 3 + c / 3).contains(num)) {
                    return false;
                }
                boxSet.get((r / 3) * 3 + c / 3).add(num);
            }
        }

        return true;
    }
}
