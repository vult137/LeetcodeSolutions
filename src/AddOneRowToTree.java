// 623. Add One Row to Tree Medium
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d < 1) return root;
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        return helper(root, v, d, 0);
    }

    public TreeNode helper(TreeNode root, int v, int d, int cur) {
        if (root == null) return null;
        if (cur == d - 2) {
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
            return root;
        }
        root.left = helper(root.left, v, d, cur+1);
        root.right = helper(root.right, v, d, cur+1);
        return root;
    }
}
