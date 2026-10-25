class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] coords = queue.poll();
            int r = coords[0];
            int c = coords[1];

            for (int[] dir : dirs) {
                int rNew = r + dir[0];
                int cNew = c + dir[1];

                if (rNew >= 0 && rNew < grid.length && cNew >= 0 && cNew < grid[0].length) {
                    int nextVal = grid[rNew][cNew];
                    if (nextVal == 2147483647) {
                        grid[rNew][cNew] = grid[r][c] + 1;
                        queue.offer(new int[]{rNew, cNew});
                    }
                }
            }
        }
    }
}
