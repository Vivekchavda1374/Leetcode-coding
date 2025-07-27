class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return countPaths(m - 1, n - 1, dp, obstacleGrid);
    }

    private int countPaths(int i, int j, int[][] dp, int[][] grid) {
        if (i < 0 || j < 0) return 0;
        if (grid[i][j] == 1) return 0; 
        if (i == 0 && j == 0) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        int up = countPaths(i - 1, j, dp, grid);
        int left = countPaths(i, j - 1, dp, grid);

        return dp[i][j] = up + left;
    }
}
