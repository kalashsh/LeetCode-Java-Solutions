class Solution {
    public long minCost(int[] nums, int[] cost) {
        long l = 1, r = 1000000;

        while (l < r) {
            long m = (l + r) / 2;

            long a = 0, b = 0;
            for (int i = 0; i < nums.length; i++) {
                a += Math.abs((long) nums[i] - m) * cost[i];
                b += Math.abs((long) nums[i] - (m + 1)) * cost[i];
            }

            if (a <= b) r = m;
            else l = m + 1;
        }

        long ans = 0;
        for (int i = 0; i < nums.length; i++)
            ans += Math.abs((long) nums[i] - l) * cost[i];

        return ans;
    }
}