class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for(int i = 0; i<n; i++){
            int lo = 0, hi = ans;
             while(lo < hi){
                 int m = lo + (hi-lo)/2;
                 if(dp[m] < nums[i]){
                     lo = m+1;
                 } else {
                     hi = m;
                 }
             }
            dp[lo] = nums[i];
            if(lo == ans) ans++;
        }
        return ans;
    }
}
