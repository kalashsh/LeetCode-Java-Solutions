class Solution {
    public void rotate(int[][] a) {
        int n=a.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int x=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=x;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int x = a[i][j];
                a[i][j] = a[i][n - 1 - j];
                a[i][n - 1 - j] = x;
            }
        }
    }
}
