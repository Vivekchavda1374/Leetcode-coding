import java.util.Arrays;

class Solution {
    public int reversePairs(int[] nums) {
        count = 0;
        merge(nums, 0, nums.length - 1);
        return count;
    }

    int count;

    public void merge(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = l + (r - l) / 2;
        merge(nums, l, m);
        merge(nums, m + 1, r);
        
        int j = m + 1;
        for (int i = l; i <= m; i++) {
            while (j <= r && (long) nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            count += (j - (m + 1));
        }
        
        // Merge step (without sorting)
        int[] temp = new int[r - l + 1];
        int i = l, k = 0, p = m + 1;
        while (i <= m || p <= r) {
            if (i > m) {
                temp[k++] = nums[p++];
            } else if (p > r) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[i] < nums[p] ? nums[i++] : nums[p++];
            }
        }
        System.arraycopy(temp, 0, nums, l, temp.length);
    }
}
