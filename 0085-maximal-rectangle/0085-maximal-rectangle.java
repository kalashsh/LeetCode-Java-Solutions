class Solution {
    public int maximalRectangle(char[][] m) {
        int n=m[0].length, ans=0;
        int[] h=new int[n+1];
        for(char[] row:m){
            for(int j=0; j<n; j++)
            h[j]=row[j]=='1'? h[j]+1:0;
            java.util.Stack<Integer> s= new java.util.Stack<>();
            for(int j=0; j<=n; j++){
                while(!s.isEmpty()&&h[s.peek()]>h[j]){
                    int height=h[s.pop()];
                    int width=s.isEmpty()?j:j-s.peek()-1;
                    ans=Math.max(ans, height * width);
                }
                s.push(j);
            }
        }
        return ans;
    }
}