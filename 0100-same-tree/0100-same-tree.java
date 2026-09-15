class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return serialize(p).equals(serialize(q));
    }
    private String serialize(TreeNode root) {
        if (root==null)
            return "#,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }
}