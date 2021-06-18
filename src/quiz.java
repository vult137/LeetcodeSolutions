import java.util.ArrayList;
import java.util.List;

public class quiz {
    public List<List<Integer>> getRoute(TreeNode tree) {
        if (tree == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        helper(tree, new ArrayList<>(), result);
        return result;
    }

    public void helper(TreeNode node, List<Integer> record, List<List<Integer>> result) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            result.add(record);
            return;
        }
        record.add(node.val);
        helper(node.left, record, result);
        helper(node.right, record, result);
    }
}
