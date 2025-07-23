class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];
        int idx = 1;
        int startRow = 0 , startCol = 0 , endRow = n-1 , endCol = n-1;
        while(startRow <= endRow && startCol <= endCol){
            for(int i=startCol;i<=endCol;i++){
                arr[startRow][i] = idx++;
            }

            for(int i=startRow+1; i<=endRow; i++){
                arr[i][endCol] = idx++;
            }

            for(int i=endCol-1; i>=startCol; i--){
                arr[endRow][i] = idx++;
            }

            for(int i=endRow-1; i>=startRow+1; i--){
                arr[i][startCol] = idx++;
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        return arr;
    }
}