
class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        int[][] right = new int[m][n];
        int[][] down = new int[m][n];

        right[0][1] = 1;
        down[1][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                if (grid[i][j] == 0) {
                    int ways = (int)(((long)right[i][j]
                            + down[i][j]) % MOD);

                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (int)(((long)right[i][j + 1] + ways) % MOD);
                    }

                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (int)(((long)down[i + 1][j] + ways) % MOD);
                    }

                } else {
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (int)(((long)down[i + 1][j]
                            + right[i][j]) % MOD);
                    }

                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (int)(((long)right[i][j + 1]
                            + down[i][j]) % MOD);
                    }
                }
            }
        }

        return (int)(((long)right[m - 1][n - 1]
                + down[m - 1][n - 1]) % MOD);
    }
}
