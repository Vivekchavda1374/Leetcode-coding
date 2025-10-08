class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long size = (long) n * n;

        long sum = 0, sumSq = 0;
        for (int[] row : grid) {
            for (int val : row) {
                sum += val;
                sumSq += (long) val * val;
            }
        }

        long expectedSum = size * (size + 1) / 2;
        long expectedSumSq = size * (size + 1) * (2 * size + 1) / 6;

        long diff = sum - expectedSum;
        long diffSq = sumSq - expectedSumSq; 

        long sumXY = diffSq / diff; 

        int x = (int) ((diff + sumXY) / 2); 
        int y = (int) (sumXY - x);          

        return new int[]{x, y};
    }
}
