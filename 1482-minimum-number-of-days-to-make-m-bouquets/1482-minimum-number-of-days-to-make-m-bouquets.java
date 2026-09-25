class Solution {
    public int minDays(int[] a, int m, int k) {
        if ((long) m * k > a.length) return -1;
        int lo = 1, hi = 1_000_000_000;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int bouquets = 0, flowers = 0;
            for (int x : a) {
                if (x <= mid) {
                    if (++flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }
            if (bouquets >= m) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
