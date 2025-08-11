class Solution {
    public boolean reorderedPowerOf2(int n) {
        int N = n;
        int fn[] = digitCount(N);

        for (int bit = 0; bit < 32; bit++) {
            int Pow2 = 1 << bit;
            int fbit[] = digitCount(Pow2);

            boolean got = true;
            for (int i = 0; i <= 9; i++) {
                if (fn[i] != fbit[i]) {
                    got = false;
                    break;
                }
            }

            if (got == true) return true;
        }
        return false;
    }

    public int[] digitCount(int N) {
        int f[] = new int[10];
        while (N > 0) {
            int r = N % 10;
            f[r]++;
            N /= 10;
        }
        return f;
    }
}