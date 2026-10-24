class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0';

                    while (!queue.isEmpty()) {
                        int[] coords = queue.poll();

                        if (coords[0] > 0) {
                            int[] left = {coords[0] - 1, coords[1]};
                            if (grid[coords[0] - 1][coords[1]] == '1') {
                                grid[coords[0] - 1][coords[1]] = '0';
                                queue.offer(left);
                            }
                        }

                        if (coords[0] < grid.length - 1) {
                            int[] right = {coords[0] + 1, coords[1]};
                            if (grid[coords[0] + 1][coords[1]] == '1') {
                                grid[coords[0] + 1][coords[1]] = '0';
                                queue.offer(right);
                            }
                        }

                        if (coords[1] > 0) {
                            int[] top = {coords[0], coords[1] - 1};
                            if (grid[coords[0]][coords[1] - 1] == '1') {
                                grid[coords[0]][coords[1] - 1] = '0';
                                queue.offer(top);
                            }
                        }

                        if (coords[1] < grid[0].length - 1) {
                            int[] bottom = {coords[0], coords[1] + 1};
                            if (grid[coords[0]][coords[1] + 1] == '1') {
                                grid[coords[0]][coords[1] + 1] = '0';
                                queue.offer(bottom);
                            }
                        }
                    }
                }
            }
        }

        return numIslands;
    }
}