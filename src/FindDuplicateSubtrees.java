import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 652. Find Duplicate Subtrees Medium
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        helper(root, new HashMap<>(), res);
        return res;
    }

    public String helper(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
        if (node == null) return "#";
        String serial = node.val + ","
                + helper(node.left, map, res) + ","
                + helper(node.right, map, res);
        if (map.getOrDefault(serial, 0) == 1) res.add(node);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}
