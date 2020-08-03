import java.util.Arrays;
import java.util.List;

// 654. Maximum Binary Tree Medium
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        int index = -1;
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > m) {
                m = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(m);
        node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, index));
        node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, index + 1, nums.length));
        return node;
    }
}
