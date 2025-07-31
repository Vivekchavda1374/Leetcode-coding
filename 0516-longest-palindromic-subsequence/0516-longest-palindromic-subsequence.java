class Solution {
    public int longestPalindromeSubseq(String s) {
         int n = s.length();
         char[] arr = s.toCharArray();
         int i = 0,j = n-1;
         while(i<j){
             char c = arr[i];
             arr[i] = arr[j];
              arr[j] = c;
             i++;
             j--;
         }
        String revs = new String(arr);
        int[][] dp= new int[n][n];
        for(int[] d : dp){
           Arrays.fill(d , -1);
        }
        return LCS(s , n-1 , revs , n-1 , dp);
    }
      public static int LCS(String s1 , int i , String s2 , int j , int[][] dp){
        if(i==-1 || j==-1) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
      
        if(s1.charAt(i) == s2.charAt(j)){
           int x = LCS(s1 , i-1 , s2 , j-1 , dp);
            dp[i][j] = x+1;
            return dp[i][j];
        }   else{
             int x = LCS(s1 , i-1 , s2 , j , dp);
             int y = LCS(s1 , i , s2 , j-1 , dp);
             dp[i][j] = Math.max(x,y);
            return Math.max(x,y);
        }
         
    }
}
