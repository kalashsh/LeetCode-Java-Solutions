class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] h) {
        int m = h.length, n = h[0].length;
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];

        bfs(h, p, true);
        bfs(h, a, false);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (p[i][j] && a[i][j])
                    ans.add(Arrays.asList(i, j));

        return ans;
    }

    void bfs(int[][] h, boolean[][] vis, boolean pacific) {
        int m = h.length, n = h[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (pacific) {
                q.add(new int[]{i, 0});
                vis[i][0] = true;
            } else {
                q.add(new int[]{i, n - 1});
                vis[i][n - 1] = true;
            }
        }

        for (int j = 0; j < n; j++) {
            if (pacific) {
                q.add(new int[]{0, j});
                vis[0][j] = true;
            } else {
                q.add(new int[]{m - 1, j});
                vis[m - 1][j] = true;
            }
        }

        int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] x : d) {
                int r = cur[0] + x[0], c = cur[1] + x[1];

                if (r >= 0 && r < m && c >= 0 && c < n &&
                    !vis[r][c] && h[r][c] >= h[cur[0]][cur[1]]) {

                    vis[r][c] = true;
                    q.add(new int[]{r, c});
                }
            }
        }
    }
}
