import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

// 146. LRU Cache
public class LRUCache {

    static class LinkedNode {
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;

        public LinkedNode() {
            this.pre = null;
            this.next = null;
        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public LinkedNode(int key, int value, LinkedNode pre, LinkedNode next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    private HashMap<Integer, LinkedNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private LinkedNode head, tail;

    private void addNode(LinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node) {
        LinkedNode pre = node.pre;
        LinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(LinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private LinkedNode popTail() {
        LinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }


    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) return -1;
        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            this.moveToHead(node);
        } else {
            LinkedNode newNode = new LinkedNode(key, value);
            this.cache.put(key, newNode);
            this.addNode(newNode);
            count++;
            if (count > capacity) {
                LinkedNode poppedTail = this.popTail();
                this.cache.remove(poppedTail.key);
                count--;
            }
        }
    }
}
