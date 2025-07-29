class Solution {
    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return robHelper(nums, n - 1);
    }

    private int robHelper(int[] nums, int i) {
        if (i < 0) return 0;
        if (dp[i] != -1) return dp[i];

        int include = robHelper(nums, i - 2) + nums[i];
        int exclude = robHelper(nums, i - 1);

        dp[i] = Math.max(include, exclude);
        return dp[i];
    }
}
