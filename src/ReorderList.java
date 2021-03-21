// 143. Reorder List
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode middle = p1;
        ListNode preCurrent = p1.next;
        assert preCurrent != null;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = middle.next;
            middle.next = current;
        }

        p1 = head;
        p2 = middle.next;
        while (p1 != middle) {
            middle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = middle.next;
        }
    }
}
