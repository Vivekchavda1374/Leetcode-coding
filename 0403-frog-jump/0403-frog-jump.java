class Solution {
    public boolean canCross(int[] stones) {
         HashMap<Integer , HashSet<Integer>> map = new HashMap<>();
        int n = stones.length;
         for(int ele : stones){
             map.put(ele , new HashSet<>());
         }
         map.get(stones[0]).add(1);
         for(int i = 0; i<n-1; i++){
             int num = stones[i];
             HashSet<Integer> jumps = map.get(num);
             for(int k : jumps){
                 int nextStone = num+k;
                 if(nextStone == stones[n-1]) return true;
                 if(map.containsKey(nextStone)){
                    if(k-1>0) map.get(nextStone).add(k-1);
                     map.get(nextStone).add(k);
                     map.get(nextStone).add(k+1);
                 }
             }
         }
        return false;
         
    }
}
