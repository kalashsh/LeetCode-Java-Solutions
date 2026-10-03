class Solution {
    public int maximumGap(int[] a) {
        int n = a.length;
        if (n < 2) return 0;
        int mn = a[0], mx = a[0];
        for (int x : a) {
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
        }
        if (mn == mx) return 0;
        long size = Math.max(1L, ((long) mx - mn + n - 2) / (n - 1));
        int m = (int) (((long) mx - mn) / size) + 1;
        int[] lo = new int[m], hi = new int[m];
        boolean[] used = new boolean[m];
        for (int x : a) {
            int i = (int) ((x - (long) mn) / size);
            if (!used[i]) {
                lo[i] = hi[i] = x;
                used[i] = true;
            } else {
                lo[i] = Math.min(lo[i], x);
                hi[i] = Math.max(hi[i], x);
            }
        }
        int ans = 0, prev = mn;
        for (int i = 0; i < m; i++) {
            if (!used[i]) continue;
            ans = Math.max(ans, lo[i] - prev);
            prev = hi[i];
        }
        return ans;
    }
}
