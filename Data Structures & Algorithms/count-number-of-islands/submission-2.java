class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    queue.offer(new int[]{r, c});
                    numIslands++;

                    while (!queue.isEmpty()) {
                        int[] newCoord = queue.poll();

                        for (int[] direction : directions) {
                            int row = newCoord[0] + direction[0];
                            int column = newCoord[1] + direction[1];

                            if (row >= 0 && column >= 0 && row < grid.length && column < grid[0].length) {
                                if (grid[row][column] == '1') {
                                    grid[row][column] = '0';
                                    queue.offer(new int[]{row, column});
                                }
                            }
                        }
                    }
                }
            }
        }

        return numIslands;
    }
}
