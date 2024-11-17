// problem: 146. LRU Cache. Least Recently Used
// difficulty: medium
// runtime: 36ms, beats 98.99%
// memory: 69%
import java.util.LinkedHashMap;

class ListNode {
    int key;
    int value;
    ListNode prev;
    ListNode next;

    public ListNode(int k, int val) {
        key = k;
        value = val;
    }
}

class LRUCache {
    private int[] map;
    private ListNode[] value;
    private ListNode head;
    private ListNode tail;
    private int cap;
    private int mapSize;

    public LRUCache(int capacity) {
        map = new int[10001];
        value = new ListNode[10001];
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        cap = capacity;
        head.next = tail;
        tail.prev = head;
        mapSize = 0;
    }
    
    public int get(int key) {
        if (map[key] > 0) {
            ListNode node = value[key];
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int val) {
        if (map[key] > 0) {
            remove(value[key]);
            mapSize--;
        }
        
        if (mapSize == cap) {
            remove(tail.prev);
            mapSize--;
        }

        insert(new ListNode(key,val));
        mapSize++;
    }

    private void remove(ListNode node) {
        map[node.key] = 0;
        value[node.key] = null;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(ListNode node) {
        map[node.key]++;
        value[node.key] = node;
        ListNode next = head.next;
        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
