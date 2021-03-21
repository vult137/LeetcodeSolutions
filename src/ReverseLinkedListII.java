// 92. Reverse Linked List II
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode zero = new ListNode(0);
        zero.next = head;
        ListNode pre = zero;

        for (int i = 0; i < m - 1; i++) pre = pre.next;

        ListNode start = pre.next;
        ListNode then = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return zero.next;
    }
}