class Solution {
    List<int[]> list = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        Collections.sort(list,(a,b) ->{
            if(a[1] !=b[1]) return a[1]-b[1];
            if(a[0]!=b[0]) return a[0]-b[0];
            return a[2]-b[2];
        });
        List<List<Integer>> ans=new ArrayList<>();
        int col=Integer.MIN_VALUE;
        for(int[] x:list){
            if(x[1]!=col){
                ans.add(new ArrayList<>());
                col=x[1];
            }
            ans.get(ans.size()-1).add(x[2]);
        }
        return ans;
    }
    void dfs(TreeNode root, int row, int col){
        if(root==null) return;
        list.add(new int[]{row, col, root.val});
        dfs(root.left, row+1, col-1);
        dfs(root.right, row+1, col+1);
    }
}