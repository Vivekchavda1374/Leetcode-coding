class Solution {
    public int majorityElement(int[] nums) {
        int val = nums[0];
        int n = nums.length;
        int count = 1;
        
        for (int i = 1; i < n; i++) {
            if (count == 0) {
                val = nums[i];
                count = 1;
            } else if (nums[i] == val) {
                count++;
            } else {
                count--;
            }
        }
        return val;
    }
}