class Solution {
    int d=0;
    int h(TreeNode n){
        if(n==null) return 0;
        int l=h(n.left), r=h(n.right);
        d=Math.max(d, l+r);
        return 1+Math.max(l,r);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        h(root);
        return d;
    }
}