import java.util.ArrayList;
import java.util.List;

// 109. Convert Sorted List to Binary Search Tree
public class ConvertSortedListToBinarySearchTree {
//    public TreeNode sortedListToBST(ListNode head) {
//        if (head == null) return null;
//        List<Integer> list = new ArrayList<>();
//        ListNode ptr = head;
//        while (ptr != null) {
//            list.add(ptr.val);
//            ptr = ptr.next;
//        }
//        return helper(head, list, 0, list.size() - 1);
//    }
//
//    public TreeNode helper(ListNode head, List<Integer> list, int start, int end) {
//        if (end < start) return null;
//        int mid = (start + end) / 2;
//        TreeNode node = new TreeNode(list.get(mid));
//        node.left = helper(head, list, start, mid - 1);
//        node.right = helper(head, list, mid + 1, end);
//        return node;
//    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head, null);
    }

    public TreeNode helper(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head;
        if (head == tail) return null;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode treeHead = new TreeNode(slow.val);
        treeHead.left = helper(head, slow);
        treeHead.right = helper(slow.next, tail);
        return treeHead;
    }
}
