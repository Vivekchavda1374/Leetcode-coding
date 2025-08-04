class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i = 0; i<n; i++){
            arr[i+1] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        for(int [] d : dp){
            Arrays.fill(d,-1);
        }
         return burstballon_rec(arr , 0, n+1,dp);
        
    }
    public int burstballon_rec(int[] arr , int s , int e, int[][] dp){
        if(s+1 >= e) return 0;
        if(dp[s][e] != -1) return dp[s][e];
        int ans = Integer.MIN_VALUE;
        for(int i = s+1; i<e; i++){
            int leftans = burstballon_rec(arr , s , i,dp);
            int rightans = burstballon_rec(arr , i , e,dp);
            int myans = leftans+rightans + arr[s]*arr[i]*arr[e];
           ans = Math.max(ans , myans);
        }
        dp[s][e] = ans;
        return ans;
        
    }
}

