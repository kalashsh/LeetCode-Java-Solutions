class Solution {
    public String[] createGrid(int m, int n) {
        char[][] g = new char[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(g[i], '#');
        }
        int r = 0, c = 0;
        g[0][0] = '.';
        while(c + 1 < n){
            c++;
            g[r][c] = '.';
            if(r+1<m){
                r++;
                g[r][c] = '.';
            }
        }
        while(r+1<m){
            r++;
            g[r][c]='.';
        }
        List<String>ans = new ArrayList<>();
        for(char[] row :g){
            ans.add(new String(row));
        }
        return ans.toArray(new String[0]);
    }
}