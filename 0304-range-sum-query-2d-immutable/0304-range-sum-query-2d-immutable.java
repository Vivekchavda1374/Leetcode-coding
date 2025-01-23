class NumMatrix {
int[][] psum;
    public NumMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        psum = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j == 0){
                    psum[i][j] = mat[i][j];
                }else{
                    psum[i][j] = psum[i][j-1] + mat[i][j];
                }
            }
        }

        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                psum[i][j] = psum[i-1][j] + psum[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;

        ans = ans+ psum[row2][col2];
        if(row1 > 0){
            ans -= psum[row1-1][col2];
        }

        if(col1 > 0){
            ans -= psum[row2][col1-1];
        }

        if(row1 > 0 && col1 > 0){
            ans += psum[row1-1][col1-1];
        }

        return ans;
    }
}



/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */