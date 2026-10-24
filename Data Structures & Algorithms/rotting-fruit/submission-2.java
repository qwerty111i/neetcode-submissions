class Solution {
    public int orangesRotting(int[][] grid) {
        int numMins = 0;
        Deque<int[]> queue = new ArrayDeque<>();

        int numFresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numFresh++;
                }

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty() && numFresh > 0) {
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                int[] coords = queue.poll();
                int i = coords[0];
                int j = coords[1];

                for (int[] direction : dirs) {
                    int row = i + direction[0];
                    int col = j + direction[1];

                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
                        if (grid[row][col] == 1) {
                            grid[row][col] = 2;
                            numFresh--;
                            queue.offer(new int[]{row, col});
                        }
                    }
                }
            }

            numMins++;
        }

        if (numFresh > 0) return -1;
        return numMins;
    }
}
