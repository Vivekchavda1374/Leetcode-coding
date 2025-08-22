class Solution {
    public int minimumArea(int[][] grid) {
        int length = 0;
        int breadth = 0;
        int left = grid[0].length;
        int right = 0;
        int top = grid.length;   
        int bottom = -1;         

        for (int i = 0; i < grid.length; i++) {
            boolean check = false;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    check = true;
                    left = Math.min(left, j);
                    right = Math.max(right, j + 1);
                    top = Math.min(top, i);      
                    bottom = Math.max(bottom, i);
                }
            }
        }

        if (bottom == -1) return 0; 

        length = bottom - top + 1;
        breadth = right - left;
        return length * breadth;
    }
}