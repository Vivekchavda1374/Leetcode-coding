class Solution {
    public int minMoves(int[] nums, int k) {
        List<Integer> pos = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) pos.add(i);
        }
        int n = pos.size();
        int[] pre = new int[n + 1]; 

        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (pos.get(i) - i);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i + k <= n; i++) {
            int mid = i + k / 2;
            int median = pos.get(mid) - mid;
            int left = pre[mid] - pre[i];
            int right = pre[i + k] - pre[mid + 1];

            int cost = (median * (mid - i) - left) + (right - median * (i + k - mid - 1));
            res = Math.min(res, cost);
        }

        return res;
    }
}
