class Solution {
    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int numIslands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    numIslands++;

                    grid[r][c] = '0';
                    queue.offer(new int[]{r, c});

                    while (!queue.isEmpty()) {
                        int[] coords = queue.poll();

                        for (int[] dir : dirs) {
                            int newR = coords[0] + dir[0];
                            int newC = coords[1] + dir[1];

                            if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length) {
                                if (grid[newR][newC] == '1') {
                                    grid[newR][newC] = '0';
                                    queue.offer(new int[]{newR, newC});
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
