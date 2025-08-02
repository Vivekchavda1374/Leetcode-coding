class Solution {
    public int maxProfit(int[] prices) {
        int buy = -prices[0] , sell = 0, cool = 0;
         for(int i = 1; i<prices.length; i++){
            int cbuy = Math.max(buy , cool - prices[i]);
            int csell = Math.max(sell , prices[i] + buy);
            cool = Math.max(cool , sell);
            buy = cbuy;
            sell = csell;
        }
        return sell;
    }
}
