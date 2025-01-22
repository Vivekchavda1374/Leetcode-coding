class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] heights = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize heights array with -1 and find water cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    heights[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    heights[i][j] = -1;
                }
            }
        }
        
        // Directions for adjacent cells
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        // BFS to fill heights
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && heights[nx][ny] == -1) {
                    heights[nx][ny] = heights[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        return heights;
    }
}