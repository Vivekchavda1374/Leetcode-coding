class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, N = m * n;
        int[] ans = new int[N];
        for(int k=0, idx = 0; idx<N; k++) {
            if(k % 2 == 1){
                for(int j=Math.min(n-1, k), i=k-j; i<m && j>=0; i++, j--) {
                    ans[idx++] = mat[i][j];
                }
            } else {
                for(int i=Math.min(m-1,k), j=k-i; i>=0 && j<n; i--, j++) {
                    ans[idx++] = mat[i][j];
                }
            }
        }
        return ans;
    }
}