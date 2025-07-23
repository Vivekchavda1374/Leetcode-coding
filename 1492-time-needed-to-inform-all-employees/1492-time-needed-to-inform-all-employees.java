import java.util.*;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                tree.get(manager[i]).add(i);
            }
        }
        return dfs(tree, informTime, headID);
    }

    private int dfs(List<List<Integer>> tree, int[] informTime, int current) {
        int maxTime = 0;
        for (int sub : tree.get(current)) {
            maxTime = Math.max(maxTime, dfs(tree, informTime, sub));
        }
        return informTime[current] + maxTime;
    }
}
