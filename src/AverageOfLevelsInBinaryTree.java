import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 637. Average of Levels in Binary Tree Easy
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            double temp = 0.0;
            int cnt = 0;
            int s = q.size();
            for (int i = 0; i < s; i++) {
                TreeNode node = q.poll();
                temp += node.val;
                cnt += 1;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(temp / cnt);
        }
        return res;
    }
}
