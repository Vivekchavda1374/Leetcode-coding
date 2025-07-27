class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(dp[i],-1);
        }
       return minPathSumhelper(grid,grid.length-1,grid[0].length-1,dp);
    }

    public int minPathSumhelper(int[][] grid, int row,int col,int[][]dp) {
        if(row < 0 || col < 0){
            return Integer.MAX_VALUE;
        }

        if(row == 0 && col == 0){
            return grid[row][col];
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int down = minPathSumhelper(grid,row-1,col,dp);
        int right = minPathSumhelper(grid,row,col-1,dp);

        
        int ans = Math.min(down,right) + grid[row][col];
        dp[row][col] = ans;
        return ans;
    }
}
