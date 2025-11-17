class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderFrequency = new HashMap<>();
        remainderFrequency.put(0, 1);
      
        int count = 0;       
        int prefixSum = 0; 
        for (int num : nums) {
            prefixSum = ((prefixSum + num) % k + k) % k;
            count += remainderFrequency.getOrDefault(prefixSum, 0);
            remainderFrequency.merge(prefixSum, 1, Integer::sum);
        }
      
        return count;
    }
}