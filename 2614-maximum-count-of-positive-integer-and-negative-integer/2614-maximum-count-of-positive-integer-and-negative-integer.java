class Solution {
    public int maximumCount(int[] nums) {
        int negCount = findFirstZeroOrPositive(nums);  
        int posCount = nums.length - findFirstPositive(nums); 
        return Math.max(negCount,posCount);
    }

    private int findFirstZeroOrPositive(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;  
    }

    private int findFirstPositive(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;  
    }
}
