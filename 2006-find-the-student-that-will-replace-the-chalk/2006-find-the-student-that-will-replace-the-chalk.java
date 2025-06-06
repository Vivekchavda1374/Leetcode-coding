class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long sum = 0;
        for (int c : chalk) sum += c;
        k %= sum;
        for (int i = 0; i < n; i++) {
            if (k < chalk[i]) return i;
            k -= chalk[i];
        }
        return -1; 
    }
}
