import java.util.HashMap;
import java.util.Map;

public class FiftyNine {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        {
            cache.put(1, 1);
            cache.put(2, 2);

            System.out.println(cache.get(1));

            cache.put(3, 3);

            System.out.println(cache.map);
        }

    }
}

class LRUCache {

    private int capacity;
    private CNode head, tail;

    Map<Integer, CNode> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;

        this.head = this.tail = null;

    }

    public int get(int key) {

        if (map.containsKey(key)) {

            detach(map.get(key));
            prepend(map.get(key));

            return map.get(key).value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        // CNode node = map.getOrDefault(key, null);
        // System.out.println(node + " nn");

        if (map.containsKey(key)) {

            CNode node = map.get(key);
            this.detach(node);
            prepend(node);
            node.value = value;

        } else {

            CNode node = new CNode(key, value);
            prepend(node);
            trimCache();
            map.put(key, node);
        }

        // if (node != null) {
        // this.detach(node);
        // prepend(node);
        // node.value = value;
        // } else {
        // node = new CNode(key, value);

        // prepend(node);
        // trimCache();
        // map.put(key, node);
        // }

    }

    private void detach(CNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (this.tail == node) {
            this.tail = node.prev;
        }

        if (this.head == node) {
            this.head = node.next;
        }

        node.next = null;
        node.prev = null;
    }

    private void prepend(CNode node) {

        if (this.head == null) {
            this.head = this.tail = node;
            return;
        }

        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    private void trimCache() {
        if (map.size() < capacity) {
            return;
        }
        
        // detach Least used
        CNode t = this.tail;

        this.detach(this.tail);

        map.remove(t.key);
    }

    class CNode {
        int key;
        int value;
        CNode next, prev;

        public CNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}