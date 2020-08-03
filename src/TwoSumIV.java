import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 653. Two Sum IV - Input is a BST Easy
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }

    public boolean helper(TreeNode node, int k, Set<Integer> set) {
        if (node == null) return false;
        if (set.contains(k - node.val)) return true;
        set.add(node.val);
        return helper(node.left, k, set) || helper(node.right, k, set);
    }
}
