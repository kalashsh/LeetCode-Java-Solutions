class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long total = 0;

        for (int battery : batteries) {
            total += battery;
        }

        long left = 0;
        long right = total / n;

        while (left < right) {
            long mid = left + (right - left + 1) / 2;

            if (canRun(n, batteries, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canRun(int n, int[] batteries, long time) {
        long available = 0;

        for (int battery : batteries) {
            available += Math.min((long) battery, time);
        }

        return available >= time * n;
    }
}