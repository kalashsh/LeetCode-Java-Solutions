class Solution {
    int[] p;
    public int makeConnected(int n, int[][] c) {
        if (c.length < n - 1) return -1;
        p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        int groups = n;
        for (int[] e : c) {
            int a = find(e[0]);
            int b = find(e[1]);
            if (a != b) {
                p[a] = b;
                groups--;
            }
        }
        return groups - 1;
    }
    int find(int x) {
        return p[x] == x ? x : (p[x] = find(p[x]));
    }
}