// problem: 141. Linked List Cycle
// difficulty: easy
// time: 10 minutes, 5 minutes, 30 minutes
// runtime: 0ms, beats 100%
// memory: 44.19MB, beats 74.67%
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode h2 = head;

        while (head != null && head.next != null) {
            h2 = h2.next;
            head = head.next.next;

            if (h2 == head) {
                return true;
            }
        }

        return false;
    }
}

// runtime: 4ms, beats 12.18%
// memory: 44.19MB, beats 74.67%
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if(set.contains(head)) return true;
            else {
                set.add(head);
            }
            
            head = head.next;
        }

        return false;
    }
}

// runtime: 5ms, beats 8.08%
// memory: 44.53MB, beats 24.93%
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        HashMap<ListNode, Integer> map = new HashMap<>();

        while (head != null) {
            if(map.containsKey(head)) return true;
            else {
                map.put(head,1);
            }
            
            head = head.next;
        }

        return false;
    }
}
