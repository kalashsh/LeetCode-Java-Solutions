class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k], dp = new long[k];

        for (int a : nums) {
            long[] ndp = new long[k];
            int x = a % k;

            ndp[x]++;
            for (int r = 0; r < k; r++)
                ndp[r * x % k] += dp[r];

            for (int r = 0; r < k; r++) {
                dp[r] = ndp[r];
                ans[r] += dp[r];
            }
        }
        return ans;
    }
}