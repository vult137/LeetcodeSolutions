import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 662. Maximum Width of Binary Tree Medium
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        return helper(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }

    public int helper(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
        if (root == null) return 0;
        if (start.size() == level) {
            start.add(order);
            end.add(order);
        } else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = helper(root.left, level + 1, order * 2, start, end);
        int right = helper(root.right, level + 1, order * 2 + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}
