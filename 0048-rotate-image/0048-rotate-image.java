class Solution {
    public void rotate(int[][] m) {
        int top = 0;
        int bottom = m.length - 1;

        while (top < bottom) {
            for (int col = 0; col < m.length; col++) {
                int temp = m[top][col];
                m[top][col] = m[bottom][col];
                m[bottom][col] = temp;
            }
            top++;
            bottom--;
        }
        for(int i=0  ; i<m.length;i++){
            for(int j = 0 ; j<i;j++){
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }

        }

       
    }
}