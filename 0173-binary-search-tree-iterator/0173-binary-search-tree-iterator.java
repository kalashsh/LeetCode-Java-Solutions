class BSTIterator {
    Queue<Integer> q = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        q.offer(root.val);
        inorder(root.right);
    }
    public int next() {
        return q.poll();
    }
    public boolean hasNext() {
        return !q.isEmpty();
    }
}