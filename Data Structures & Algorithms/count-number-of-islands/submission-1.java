class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        Deque<int[]> stack = new ArrayDeque<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r > 0 && grid[r - 1][c] == '1') {
                        grid[r - 1][c] = '0';
                        stack.push(new int[]{r - 1, c});
                    }
                    if (r < grid.length - 1 && grid[r + 1][c] == '1') {
                        grid[r + 1][c] = '0';
                        stack.push(new int[]{r + 1, c});
                    }
                    if (c > 0 && grid[r][c - 1] == '1') {
                        grid[r][c - 1] = '0';
                        stack.push(new int[]{r, c - 1});
                    }
                    if (c < grid[0].length - 1 && grid[r][c + 1] == '1') {
                        grid[r][c + 1] = '0';
                        stack.push(new int[]{r, c + 1});
                    }

                    numIslands++;
                }

                while (!stack.isEmpty()) {
                    int[] newCoord = stack.poll();
                    int nextR = newCoord[0];
                    int nextC = newCoord[1];

                    if (nextR > 0 && grid[nextR - 1][nextC] == '1') {
                        grid[nextR - 1][nextC] = '0';
                        stack.push(new int[]{nextR - 1, nextC});
                    }
                    if (nextR < grid.length - 1 && grid[nextR + 1][nextC] == '1') {
                        grid[nextR + 1][nextC] = '0';
                        stack.push(new int[]{nextR + 1, nextC});
                    }
                    if (nextC > 0 && grid[nextR][nextC - 1] == '1') {
                        grid[nextR][nextC - 1] = '0';
                        stack.push(new int[]{nextR, nextC - 1});
                    }
                    if (nextC < grid[0].length - 1 && grid[nextR][nextC + 1] == '1') {
                        grid[nextR][nextC + 1] = '0';
                        stack.push(new int[]{nextR, nextC + 1});
                    }
                }
            }
        }

        return numIslands;
    }
}
