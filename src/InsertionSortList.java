// 147. Insertion Sort List
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode helper = new ListNode(0, head);
        ListNode pre = helper, cur = head, suc;
        while (cur != null) {
            suc = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = suc;
        }
        return helper.next;
    }
}
