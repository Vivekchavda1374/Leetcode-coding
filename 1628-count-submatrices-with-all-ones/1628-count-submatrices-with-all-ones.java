class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length, res = 0;
        int[] h = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                h[j] = (mat[i][j] == 0) ? 0 : h[j] + 1;

            for (int j = 0; j < n; j++) {
                int mn = Integer.MAX_VALUE;
                for (int k = j; k >= 0 && h[k] > 0; k--) {
                    mn = Math.min(mn, h[k]);
                    res += mn;
                }
            }
        }
        return res;
    }
}