// 206. Reverse Linked List
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode zero = new ListNode(0);
        zero.next = head;

        ListNode prev = zero, ptr = head, next = head.next;
        while (next != null) {
            ptr.next = prev;
            prev = ptr;
            ptr = next;
            next = ptr.next;
        }
        ptr.next = prev;
        head.next = null;
        return ptr;
    }
}
