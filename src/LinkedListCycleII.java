import java.util.HashSet;
import java.util.Set;

// 142. Linked List Cycle II
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode ptr = head;
        while (ptr != null) {
            if (set.contains(ptr)) return ptr;
            set.add(ptr);
            ptr = ptr.next;
        }
        return null;
    }
}
