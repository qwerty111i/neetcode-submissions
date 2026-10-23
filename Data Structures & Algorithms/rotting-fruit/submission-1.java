class Solution {
    public int orangesRotting(int[][] grid) {
        int numFreshFruit = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) numFreshFruit++;
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int numMinutes = 0;
        while (!queue.isEmpty() && numFreshFruit > 0) {
            numMinutes++;
            int numIterations = queue.size();
            for (int i = 0; i < numIterations; i++) {
                int[] currCoordinate = queue.poll();
                for (int[] direction : directions) {
                    int r = currCoordinate[0] + direction[0];
                    int c = currCoordinate[1] + direction[1];

                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length) {
                        if (grid[r][c] == 1) {
                            grid[r][c] = 2;
                            queue.offer(new int[]{r, c});
                            numFreshFruit--;
                        }
                    }
                }
            }
        }

        if (numFreshFruit == 0) return numMinutes;
        return -1;
    }
}
