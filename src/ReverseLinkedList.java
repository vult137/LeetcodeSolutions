// 206. Reverse Linked List
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode prev = null, ptr = head, next = head.next;
        while (next != null) {
            ptr.next = prev;
            prev = ptr;
            ptr = next;
            next = ptr.next;
        }
        ptr.next = prev;
        return ptr;
    }
}
