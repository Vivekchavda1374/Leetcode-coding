class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
       int maxP = 0;
       int minBP = prices[0];
        
       for(int i = 0; i<n; i++){
           int price = prices[i];
           if(price-minBP > maxP){
               maxP = price-minBP;
           }
           left[i] = maxP;
           minBP = Math.min(minBP , price);
       }
        maxP = 0;
        int maxSP = prices[n-1];
       for(int i = n-1; i>=0; i--){
            int price = prices[i];
            if(maxSP-price > maxP){
                maxP = maxSP- price;
            }
            right[i] = maxP;
            maxSP = Math.max(maxSP , price);
       }
    int ans = 0;
    for(int i = 0; i<n; i++){
        ans = Math.max(left[i]+right[i] , ans);
    }
    return ans;
        
    }
}
