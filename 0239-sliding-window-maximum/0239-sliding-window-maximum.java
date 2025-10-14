import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        result[0] = map.lastKey(); 
        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            map.put(out, map.get(out) - 1);
            if (map.get(out) == 0) map.remove(out);
            int in = nums[i];
            map.put(in, map.getOrDefault(in, 0) + 1);
            result[i - k + 1] = map.lastKey();
        }
        return result;
    }
}
