import java.util.*;

class Solution {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fibUtil(n, memo);
    }

    private int fibUtil(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] != -1) return memo[n];

        memo[n] = fibUtil(n - 1, memo) + fibUtil(n - 2, memo);
        return memo[n];
    }
}
