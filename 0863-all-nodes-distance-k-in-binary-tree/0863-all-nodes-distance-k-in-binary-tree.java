class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        makeParent(root, null, parent);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        q.add(target);
        seen.add(target);
        while (k-- > 0) {
            for (int i = q.size(); i > 0; i--) {
                TreeNode cur = q.poll();
                if (cur.left != null && seen.add(cur.left))
                    q.add(cur.left);
                if (cur.right != null && seen.add(cur.right))
                    q.add(cur.right);
                if (parent.get(cur) != null && seen.add(parent.get(cur)))
                    q.add(parent.get(cur));
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty())
            ans.add(q.poll().val);
        return ans;
    }
    void makeParent(TreeNode node, TreeNode p, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        parent.put(node, p);
        makeParent(node.left, node, parent);
        makeParent(node.right, node, parent);
    }
}
