class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[2 * n - 1][n][n];
        for (int[][] layer : dp)
            for (int[] row : layer)
                Arrays.fill(row, Integer.MIN_VALUE);

        dp[0][0][0] = grid[0][0];

        for (int k = 1; k < 2 * n - 1; k++) {
            for (int i = Math.max(0, k - n + 1); i <= Math.min(n - 1, k); i++) {
                for (int j = Math.max(0, k - n + 1); j <= Math.min(n - 1, k); j++) {
                    if (grid[i][k - i] == -1 || grid[j][k - j] == -1)
                        continue;

                    int max = Integer.MIN_VALUE;

                    for (int pi = i - 1; pi <= i; pi++) {
                        for (int pj = j - 1; pj <= j; pj++) {
                            if (pi >= 0 && pj >= 0)
                                max = Math.max(max, dp[k - 1][pi][pj]);
                        }
                    }

                    if (max == Integer.MIN_VALUE) continue;

                    int curr = (i == j) ? grid[i][k - i] : grid[i][k - i] + grid[j][k - j];
                    dp[k][i][j] = max + curr;
                }
            }
        }

        return Math.max(0, dp[2 * n - 2][n - 1][n - 1]);
    }
}
