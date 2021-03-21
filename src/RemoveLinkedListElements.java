// 203. Remove Linked List Elements
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode superHead = new ListNode();
        superHead.next = head;
        ListNode ptr = superHead;
        while (ptr.next != null) {
            if (ptr.next.val == val)
                ptr = remove(ptr, ptr.next);
            else ptr = ptr.next;
        }
        return superHead.next;
    }

    public ListNode remove(ListNode first, ListNode next) {
        if (first == null || next == null) return null;
        if (first.next != next) return first;
        first.next = next.next;
        return first;
    }
}
